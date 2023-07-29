package com.subrat.course_schedule.services;


import java.util.Optional;
import com.subrat.course_schedule.enums.Constants;
import com.subrat.course_schedule.entities.Course;
import com.subrat.course_schedule.entities.Employee;
import com.subrat.course_schedule.repositories.ICourse;
import com.subrat.course_schedule.repositories.IEmployee;

public class EmployeeService {
    private final ICourse courseRepository;
    private final IEmployee employeeRepository;
    
    public EmployeeService(ICourse courseRepository, IEmployee employeeRepository) {
        this.courseRepository = courseRepository;
        this.employeeRepository = employeeRepository;
    }

    public Optional<Employee> register(String emailId, String offering) throws Exception {
        Employee e = null;
        if(courseRepository.isSeatAvailable(offering)){
            String name = emailId.split("@")[0];
            String courseName = courseRepository.getCourseNameByOffering(offering);
            String regNum = "REG-COURSE-"+name+"-"+courseName;
            Employee employee = new Employee(name,emailId,offering,regNum);
            e = employeeRepository.save(employee);
            courseRepository.addEmployees(offering,e);
            
        }
        return Optional.ofNullable(e);
    }

    public void cancelRegisteration(String regNum) {
        Employee employee = employeeRepository.findByRegNum(regNum).get();
        String offering = employee.getOffering();
        Course course = courseRepository.findByOfferingName(offering).get();
        if(course.getStatus().equals(Constants.NOT_CONFIRMED.getStatus())){
            courseRepository.deleteEmployee(course, employee);
            System.out.println(regNum+" "+Constants.CANCEL_ACCEPTED.getStatus());
        }else{
            System.out.println(regNum+" "+Constants.CANCEL_REJECTED.getStatus());
        }
    }

    
    
}

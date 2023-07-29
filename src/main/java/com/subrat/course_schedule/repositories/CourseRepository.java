package com.subrat.course_schedule.repositories;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.subrat.course_schedule.enums.Constants;
import com.subrat.course_schedule.entities.Allotment;
import com.subrat.course_schedule.entities.Course;
import com.subrat.course_schedule.entities.Employee;

public class CourseRepository implements ICourse{
    private final Map<Long,Course> courseMap;
    private Long autoIncrement = 1L;

    public CourseRepository(){
        courseMap = new HashMap<Long,Course>();
    }

    @Override
    public Course save(Course course) {
        Course c = new Course(autoIncrement,course.getTitle(),course.getInstructor(),course.getDate(),course.getMinEmployees(),course.getMaxEmployees());
        courseMap.put(autoIncrement,c);
        ++autoIncrement;
        return c;
    }

    @Override
    public Optional<Course> findByOfferingName(String courseOfferingName) {
        for (Map.Entry<Long,Course> entry : courseMap.entrySet()) {
            
            Course course = entry.getValue();
            if(course.getOffering().equals(courseOfferingName)){
                return Optional.ofNullable(course);
            }
        }
        return Optional.ofNullable(null);
    }

    @Override
    public List<Course> findAll() {
        return courseMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public void deleteEmployee(Course course, Employee employee) {
        course.removeEmployee(employee);
    }

    @Override
    public boolean isSeatAvailable(String courseOfferingName){
        Course course = findByOfferingName(courseOfferingName).get();
        if(course.getEmployeesCount()<course.getMaxEmployees() && course.getStatus().equals("NOT_CONFIRMED")) return true;
        else System.out.println(Constants.COURSE_FULL_ERROR.getStatus());
        return false;
    }

    @Override
    public String getCourseNameByOffering(String courseOfferingName) {
        Course course = findByOfferingName(courseOfferingName).get();
        return course.getTitle();
    }

    @Override
    public void addEmployees(String offering, Employee employee){
        Course course = findByOfferingName(offering).get();
        course.addEmployee(employee);
    }

    @Override
    public List<Allotment> findAllAllotmentsByOffering(String courseOfferingName) {
        List<Allotment> allotments = new ArrayList<>();
        Course course = findByOfferingName(courseOfferingName).get();
        List<Employee> employees = course.getEmployees();

        for (Employee employee : employees) {
            Allotment allotment = new Allotment(employee, course);
            allotments.add(allotment);
        }
        Collections.sort(allotments);
        return allotments;
    }

    @Override
    public Optional<Course> findByCourseName(String courseName) {
        for (Map.Entry<Long,Course> entry : courseMap.entrySet()) {
            
            Course course = entry.getValue();
            if(course.getTitle().equals(courseName)){
                return Optional.ofNullable(course);
            }
        }
        return Optional.ofNullable(null);
        
    }


}

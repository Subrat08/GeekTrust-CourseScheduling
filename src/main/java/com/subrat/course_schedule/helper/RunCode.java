package com.subrat.course_schedule.helper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

import com.subrat.course_schedule.entities.Allotment;
import com.subrat.course_schedule.entities.Course;
import com.subrat.course_schedule.entities.Employee;
import com.subrat.course_schedule.enums.ParametersCount;
import com.subrat.course_schedule.exceptions.InputDataException;
import com.subrat.course_schedule.repositories.CourseRepository;
import com.subrat.course_schedule.repositories.EmployeeRepository;
import com.subrat.course_schedule.repositories.ICourse;
import com.subrat.course_schedule.repositories.IEmployee;
import com.subrat.course_schedule.services.CourseService;
import com.subrat.course_schedule.services.EmployeeService;

public class RunCode {
    public static void run(List<String> commandLineArgs) throws Exception{
		// Initialize repositories
        ICourse courseRepository = new CourseRepository();
		IEmployee employeeRepository = new EmployeeRepository();        

        // Initialize services
        CourseService courseService = new CourseService(courseRepository);
        EmployeeService employeeService = new EmployeeService(courseRepository,employeeRepository);

        final int idx0 = 0, idx1 = 1, idx2 = 2, idx3 = 3, idx4 = 4, idx5 = 5;

        String inputFile = commandLineArgs.get(idx0);

        try(BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            while (true) {
                String line = reader.readLine();
                if (line == null){
                    break;
                }
                List<String> tokens = Arrays.asList(line.split(" "));

                // Execute Services
                switch(tokens.get(idx0)){
					case "ADD-COURSE-OFFERING":
					{   
                        
                        if(checkParameters(ParametersCount.ADD_COURSE_OFFERING.getNumberOfParameters(), tokens.size())){
                            String courseName = tokens.get(idx1);
                            String instructorName = tokens.get(idx2);
                            String date = tokens.get(idx3);
                            int minEmployees = Integer.parseInt(tokens.get(idx4));
                            int maxEmployees = Integer.parseInt(tokens.get(idx5));
                            Course course = courseService.createCourse(courseName,instructorName,date,minEmployees,maxEmployees);
                            System.out.println(course); 
                        }
                                      
					}
					break;

                    case "REGISTER":
					{
						try{
                            if(checkParameters(ParametersCount.REGISTER.getNumberOfParameters(), tokens.size())){
                                String emailId = tokens.get(idx1);
                                String offering = tokens.get(idx2);
                                Employee employee = employeeService.register(emailId,offering).get();
                                System.out.println(employee); 
                            }
                        }catch(java.util.NoSuchElementException e){

                        }
					}
                    break;

                    case "ALLOT":
					{
                        if(checkParameters(ParametersCount.ALLOT.getNumberOfParameters(), tokens.size())){
                            
                            String offering = tokens.get(idx1);
                            List<Allotment> allotments = courseService.allotCourse(offering);
                            for (Allotment allotment : allotments) {
                                System.out.println(allotment); 
                            }
                        }
                        
					}
                    break;

					case "CANCEL":
					{
                       
                        if(checkParameters(ParametersCount.CANCEL.getNumberOfParameters(), tokens.size())){
                                String offering = tokens.get(idx1);
                                employeeService.cancelRegisteration(offering); 
                        }
                                                       
                        
					}
					break;
                    default:
                        throw new RuntimeException("Invalid Command");
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static boolean checkParameters(int expected, int actual) {
        try{
            if(expected!=actual-1){
                throw new InputDataException();
                
            }
        }catch(InputDataException e){
            return false;
        }
        return true;
        

    }
}

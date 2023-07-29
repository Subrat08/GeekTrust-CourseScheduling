package com.subrat.course_schedule.services;

import java.util.List;
import java.util.Optional;

import com.subrat.course_schedule.enums.Constants;
import com.subrat.course_schedule.entities.Allotment;
import com.subrat.course_schedule.entities.Course;
import com.subrat.course_schedule.repositories.ICourse;

public class CourseService {
    private final ICourse courseRepository;

    public CourseService(ICourse courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course createCourse(String courseName, String instructorName, String date, int minEmployees,
            int maxEmployees) {
        
        Optional<Course> c =courseRepository.findByCourseName(courseName);

        if(c.isPresent()){
            c.get().resetAttributes(minEmployees, maxEmployees);
            return c.get();
        }else{
            Course course = new Course(courseName, instructorName, date, minEmployees, maxEmployees);
            return courseRepository.save(course);
        }
        
    }

    public List<Allotment> allotCourse(String offering){
        Course course = courseRepository.findByOfferingName(offering).get();
        if(course.getMinEmployees()<=course.getEmployeesCount())
            course.setStatus(Constants.COURSE_ALLOTED.getStatus());
        else{
            course.setStatus(Constants.COURSE_CANCELED.getStatus());
        }
        return courseRepository.findAllAllotmentsByOffering(offering);
    }
}

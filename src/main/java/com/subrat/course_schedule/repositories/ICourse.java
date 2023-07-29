package com.subrat.course_schedule.repositories;

import java.util.List;

import java.util.Optional;

import com.subrat.course_schedule.entities.Allotment;
import com.subrat.course_schedule.entities.Course;
import com.subrat.course_schedule.entities.Employee;

public interface ICourse {
    Course save(Course course);
    Optional<Course> findByOfferingName(String courseOfferingName);
    Optional<Course> findByCourseName(String courseName);
    List<Course> findAll();
    void deleteEmployee(Course course, Employee employee);
    boolean isSeatAvailable(String courseOfferingName) throws Exception;
    String getCourseNameByOffering(String courseOfferingName);
    void addEmployees(String offering, Employee employee);
    List<Allotment> findAllAllotmentsByOffering(String courseOfferingName);
}

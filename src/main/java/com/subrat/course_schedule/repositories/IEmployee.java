package com.subrat.course_schedule.repositories;

import java.util.List;

import java.util.Optional;

import com.subrat.course_schedule.entities.Employee;

public interface IEmployee {
    Employee save(Employee employee);
    Optional<Employee> findByRegNum(String regNum);
    List<Employee> findAll();
}

package com.subrat.course_schedule.entities;

import java.util.ArrayList;
import java.util.List;

import com.subrat.course_schedule.enums.Constants;

public class Course {
    private final Long id;
    private final String title;
    private final String instructor;
    private final String date;
    private Integer minEmployees;
    private Integer maxEmployees;
    private final String offering;
    private String status;
    private List<Employee> employees;

    public Course(Long id, String title, String instructor, String date, Integer minEmployees, Integer maxEmployees) {
        this.id = id;
        this.title = title;
        this.instructor = instructor;
        this.date = date;
        this.minEmployees = minEmployees;
        this.maxEmployees = maxEmployees;
        this.offering = "OFFERING-"+title+"-"+instructor;
        this.status = Constants.NOT_CONFIRMED.getStatus();
        this.employees = new ArrayList<Employee>();
    }

    public Course(String title, String instructor, String date, Integer minEmployees, Integer maxEmployees) {
        this(null,title,instructor,date,minEmployees,maxEmployees);
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getInstructor() {
        return instructor;
    }

    public String getDate() {
        return date;
    }

    public Integer getMinEmployees() {
        return minEmployees;
    }

    public int getMaxEmployees() {
        return maxEmployees;
    }

    public String getOffering() {
        return offering;
    }

    public String getStatus() {
        return status;
    }

    public Integer getEmployeesCount() {
        return employees.size();
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void addEmployee(Employee employee){
        this.employees.add(employee);
    }

    @Override
    public String toString() {
        return offering;
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    public void resetAttributes(int minEmployees, int maxEmployees) {
        this.minEmployees=minEmployees;
        this.maxEmployees=maxEmployees;
        this.employees=new ArrayList<Employee>();
        this.status=Constants.NOT_CONFIRMED.getStatus();
        
    }
    
}

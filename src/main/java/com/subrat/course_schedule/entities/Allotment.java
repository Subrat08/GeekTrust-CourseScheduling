package com.subrat.course_schedule.entities;

public class Allotment implements Comparable<Allotment>{
    private final Employee employee;
    private final Course course;

    public Allotment(Employee employee, Course course) {
        this.employee = employee;
        this.course = course;
    }

    @Override
    public int compareTo(Allotment o) {
        return this.employee.getRegNum().compareTo(o.employee.getRegNum());
    }

    @Override
    public String toString() {
        return this.employee.getRegNum() + " " + this.employee.getEmailId() + " " + this.course.getOffering() + " " + this.course.getTitle()
                + " " + this.course.getInstructor() + " " + this.course.getDate() + " " + this.course.getStatus();
    }
}

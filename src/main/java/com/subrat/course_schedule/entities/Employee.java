package com.subrat.course_schedule.entities;

import com.subrat.course_schedule.enums.Constants;

public class Employee {
    private final Long id;
    private final String name;
    private final String emailId;
    private final String offering;
    private final String regNum;

    public Employee(Long id, String name, String emailId, String offering, String regNum) {
        this.id = id;
        this.name = name;
        this.emailId = emailId;
        this.offering = offering;
        this.regNum = regNum;
    }

    public Employee(String name, String emailId, String offering, String regNum) {
        this(null,name, emailId, offering, regNum);
    }

    public Long getId() {
        return id;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getName() {
        return name;
    }

    public String getRegNum() {
        return regNum;
    }

    public String getOffering() {
        return offering;
    }

    @Override
    public String toString() {
        return regNum+" "+Constants.ACCEPTED.getStatus();
    }
    
}

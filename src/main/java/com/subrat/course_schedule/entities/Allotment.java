package com.subrat.course_schedule.entities;

public class Allotment implements Comparable<Allotment>{
    private final String regNum;
    private final String emailId;
    private final String offering; 
    private final String title;
    private final String instructor;
    private final String date;
    private String status;

    public Allotment(String regNum, String emailId, String offering, String title, String instructor, String date,
            String status) {
        this.regNum = regNum;
        this.emailId = emailId;
        this.offering = offering;
        this.title = title;
        this.instructor = instructor;
        this.date = date;
        this.status = status;
    }

    @Override
    public int compareTo(Allotment o) {
        return this.regNum.compareTo(o.regNum);
    }

    @Override
    public String toString() {
        return regNum + " " + emailId + " " + offering + " " + title
                + " " + instructor + " " + date + " " + status;
    }

    
}

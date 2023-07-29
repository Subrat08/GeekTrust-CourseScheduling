package com.subrat.course_schedule.exceptions;

import com.subrat.course_schedule.enums.Constants;

public class CourseFullException extends Exception{
    
    public CourseFullException(){
        System.out.println(Constants.COURSE_FULL_ERROR.getStatus());
    }
}
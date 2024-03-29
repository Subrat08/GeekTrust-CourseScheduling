/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.subrat.course_schedule;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.subrat.course_schedule.helper.RunCode;

public class CourseScheduleApp {

	public static void main(String[] args) throws Exception {
        if (args.length != 1){
            throw new RuntimeException();
        }
        List<String> commandLineArgs = new LinkedList<>(Arrays.asList(args));

        RunCode.run(commandLineArgs);
    }

    
}

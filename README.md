# GeekTrust-CourseScheduling
The head of the Learning management system (LMS) has hired you as a consultant. The LMS team has the goal of upskilling the employees with the latest topics via courses. You need to help build a system to schedule and manage the courses.

# Goal
Your job is to build a simple command line application that accomplishes the following tasks:

## Add Course Offering
A course offering includes course title, instructor, and date. It should also specify the minimum and maximum number of employees allowed for the course.

## Register for the Course
Employees have the option to register for courses. If the maximum number of employees registered for a course is reached, the registration result will be COURSE_FULL_ERROR. Otherwise, the result of the registration will be ACCEPTED.

## Cancel Registration
Employees can cancel their course registration until the course allotment process is completed.

## Course Allotment
This feature allots employees to course offerings before the course offering date. It prints a list of all employees with their details, including the final course allotment status, sorted based on the registration number. The details include Registration Number, Employee Name, Email, Course Offering ID, Course Name, Instructor, Date, and Final Status. If sufficient registrations are not received, the course offering itself gets canceled. Employees who have registered will be confirmed unless the minimum number of registrations is not received. Even if the course offering gets canceled due to the minimum number of employees not registered, the list should still be printed.

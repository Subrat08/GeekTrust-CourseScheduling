# [GeekTrust-CourseScheduling](https://www.geektrust.com/coding/detailed/course-scheduling)

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

# Commands and Output Format

Every input command has an output. The format for each command and its corresponding output is as follows:

### Add Course Offering

**Command**: `ADD-COURSE-OFFERING <course-name> <instructor> <date-in-ddmmyyyy> <minEmployees> <maxEmployees>`

**Output**: `<course-offering-id>`

The format of the course-offering-id is `OFFERING-<COURSE-NAME>-<INSTRUCTOR>`

### Register for the Course

**Command**: `REGISTER <email-id> <course-offering-id>`

**Output**: `<course-registration-id> <status>`

The combination of email-id and course-offering-id in the input should be unique. The format of the course-registration-id is `REG-COURSE-<EMPLOYEE-NAME>-<COURSE-NAME>`. If the number of employees has not exceeded the maximum number of employees allowed for the course offering, the status will be `ACCEPTED`. If the number of employees has exceeded the maximum number of employees allowed for the course offering, the status will be `COURSE_FULL_ERROR`. If the minimum number of employees for the course offering is not reached before the course date, the status of the course offering would be `COURSE_CANCELED`. Course-registration-id will only be returned if the status is `ACCEPTED`.

### Course Allotment

**Command**: `ALLOT-COURSE <course-offering-id>`

**Output**: `<course-registration-id> <email-id> <course-offering-id> <course-name> <instructor> <date-in-ddmmyyyy> <status>`

The output should be sorted by course-registration-id in ascending order.

### Cancel Registration

The employee can cancel the course registration given a course registration id until course allotment.

**Command**: `CANCEL <course-registration-id>`

**Output**: `<course-registration-id> <status>`

There are 2 statuses: `CANCEL_ACCEPTED` when the cancellation is successful and `CANCEL_REJECTED` when the course is already allotted.

## Assumptions

1. If there is a validation error in the input (data validation or mandatory fields missing), then the application should print an error message `INPUT_DATA_ERROR`.
2. Employees can only cancel their registration until the course is allotted.
3. Instructor names and course names are unique.
4. None of the input fields accept whitespace (whitespace acts as a delimiter between fields).
5. Course offering ID generated is a combination of `OFFERING-<COURSENAME>-<INSTRUCTORNAME>`.
6. Registration ID generated is a combination of `REG-COURSE-<EMPLOYEENAME>-<COURSENAME>`. `<EMPLOYEENAME>` is extracted from the email ID, which is everything before the @ sign in the email.


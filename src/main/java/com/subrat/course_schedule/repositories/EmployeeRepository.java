package com.subrat.course_schedule.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.subrat.course_schedule.entities.Employee;

public class EmployeeRepository implements IEmployee {
    private final Map<Long,Employee> employeeMap;
    private Long autoIncrement = 1L;

    public EmployeeRepository(){
        employeeMap = new HashMap<Long,Employee>();
    }

    @Override
    public Employee save(Employee employee) {
        Employee e = new Employee(autoIncrement,employee.getName(),employee.getEmailId(),employee.getOffering(),employee.getRegNum());
        employeeMap.put(autoIncrement,e);
        ++autoIncrement;
        return e;
    }

    @Override
    public Optional<Employee> findByRegNum(String regNum) {
        for (Map.Entry<Long,Employee> entry : employeeMap.entrySet()) {
            
            Employee employee = entry.getValue();
            if(employee.getRegNum().equals(regNum)){
                return Optional.ofNullable(employee);
            }
        }
        return Optional.ofNullable(null);
    }

    @Override
    public List<Employee> findAll() {
        return employeeMap.values().stream().collect(Collectors.toList());
    }

}

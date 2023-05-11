package com.example.homework2_7.Model;
import com.example.homework2_7.Exceptions.EmployeeNotFound;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service


public class DeptEmployeeServiceImpl {

    private EmployeeBookImpl employeeBook;

    public DeptEmployeeServiceImpl(EmployeeBookImpl employeeBook) {
        this.employeeBook = employeeBook;
    }

    public Set<Employee> getEmployeeInDept(int department) {
        return employeeBook.getEmployees().stream()
                .filter(employee -> employee.getDepartament() == department)
                .collect(Collectors.toSet())
                ;

    }

    public Map<Integer, List<Employee>> getAllEmployees() {
        return employeeBook.getALl().values().stream()
                .collect(Collectors.groupingBy((Employee::getDepartament)));

    }

    public Employee getEmployeeMaxSalary(int department) {
        return employeeBook.getALl().values().stream()
                .filter((employee -> employee.getDepartament() == department))
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFound("В указанном отделе сотрудник не найден"));
    }

    public Employee getEmployeeMinSalary(int department) {
        return employeeBook.getALl().values().stream()
                .filter((employee -> employee.getDepartament() == department))
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFound("В указанном отделе сотрудник не найден"));
    }


}
package com.example.homework2_7.Model;

import com.example.homework2_7.Exceptions.EmployeeAlreadyInList;
import com.example.homework2_7.Exceptions.EmployeeNotFound;
import com.example.homework2_7.Exceptions.WrongParametr;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeBookImpl implements EmployeeBook {
    private  Map<String, Employee> employees;


    public EmployeeBookImpl() {
        this.employees = new HashMap<> ();
    }

    @Override
    public Employee add(String firstName, String lastName, double salary, int department) {
        firstName = StringUtils.replace(firstName," ","");
        lastName = StringUtils.replace(lastName," ","");
        if (!checkParametr(firstName)||!checkParametr(lastName)) {
            throw new WrongParametr("Введите строку");}


        Employee employee = new Employee(firstName, lastName, salary, department);

        if (employees.containsKey(employee.KeyEmp())) {
            throw new EmployeeAlreadyInList("Указанный сотрудник уже есть в мап");
        }
        employees.put(employee.KeyEmp(), employee);
        return employee;


    }

    @Override
    public Employee remove(String firstName, String lastName, double salary, int departament) {
        firstName = StringUtils.replace(firstName," ","");
        lastName = StringUtils.replace(lastName," ","");
        if (!checkParametr(firstName)||!checkParametr(lastName)) {
            throw new WrongParametr("Введите строку");}
        Employee employee = new Employee(firstName, lastName, salary, departament);
        boolean b = employees.containsKey(employee.KeyEmp());
        if (b) {
            employees.remove(employee.KeyEmp());
            return employee;
        }
        throw new EmployeeNotFound("Сотрудник не найден ");
    }

    @Override
    public Employee find(String firstName, String lastName, double salary, int departament) {
        firstName = StringUtils.replace(firstName," ","");
        lastName = StringUtils.replace(lastName," ","");
        if (!checkParametr(firstName)||!checkParametr(lastName)) {
            throw new WrongParametr("Введите строку");}
        Employee employee = new Employee(firstName, lastName, salary, departament);
        boolean b = employees.containsKey(employee.KeyEmp());
        if (b) {
            return employee;
        }
        throw new EmployeeNotFound("Сотрудник не найден ");
    }

    public Map<String, Employee> getALl() {
        return employees;
    }

    public HashSet<Employee> getEmployees() {
        return new HashSet<>(employees.values());
    }

    public void setEmployees(Map<String, Employee> employees) {
        this.employees = employees;
    }

    public boolean checkParametr(String s) {
        return  StringUtils.isAlpha(s);

    }
}

package com.example.homework2_7.Model;

public class Employee {
    private String firstname;
    private String lastname;
    private double salary;
    private int department;


    public Employee(String firstname, String lastname, double salary, int department) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.salary = salary;
        this.department = department;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public double getSalary() {
        return salary;
    }

    public int getDepartament() {
        return department;
    }

    public String KeyEmp() {
        return firstname + "  " + lastname;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", salary=" + salary +
                ", department=" + department +
                '}';
    }
}

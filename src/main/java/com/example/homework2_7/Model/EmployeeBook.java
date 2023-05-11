package com.example.homework2_7.Model;

public interface EmployeeBook {
    Employee add(String firstName, String lastName,double salary,int departament);

    Employee remove(String firstName, String lastName,double salary,int departament);

    Employee find(String firstName, String lastName,double salary,int departament );
}
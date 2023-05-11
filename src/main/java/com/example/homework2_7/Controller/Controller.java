package com.example.homework2_7.Controller;

import com.example.homework2_7.Model.Employee;
import com.example.homework2_7.Model.EmployeeBookImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/employee")
public class Controller {
    private final EmployeeBookImpl employeeBook;

    public Controller(EmployeeBookImpl employeeBook) {
        this.employeeBook = employeeBook;
    }

    @GetMapping("/add")
    public Employee add(@RequestParam("firstName") String firstName,
                        @RequestParam("lastName") String lastName,
                        @RequestParam("salary") double salary,
                        @RequestParam ("department") int department) {
        return employeeBook.add(firstName, lastName,salary,department);
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,
                           @RequestParam("salary") double salary,@RequestParam ("department")int department) {
        return employeeBook.remove(firstName, lastName,salary,department);
    }

    @GetMapping("/find")
    public Employee find(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,
                         @RequestParam ("salary") double salary ,@RequestParam ("department") int department) {
        return employeeBook.find(firstName, lastName,salary,department);
    }
    @GetMapping("/getall")
    public Map<String,Employee> getAll () {
        return employeeBook.getALl();
    }
}
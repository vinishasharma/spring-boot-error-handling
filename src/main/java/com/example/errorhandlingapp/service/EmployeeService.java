package com.example.errorhandlingapp.service;

import com.example.errorhandlingapp.model.Employee;
import reactor.core.publisher.Mono;

public interface EmployeeService {


    Mono<Employee> getEmployeeById(int id);

    Mono<Employee> getEmployeeByName(String name);

    Mono<Employee> createEmployee(Employee employee);

    Mono<String> deleteEmployeeById(int id);

}

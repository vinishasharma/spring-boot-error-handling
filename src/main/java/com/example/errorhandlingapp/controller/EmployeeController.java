package com.example.errorhandlingapp.controller;


import com.example.errorhandlingapp.model.Employee;
import com.example.errorhandlingapp.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
public class EmployeeController {


    private EmployeeService employeeService;

    @GetMapping(value = "/employee/id/{id}")
    public Mono<Employee> getEmployeeById(@PathVariable("id") int id) {

        return employeeService.getEmployeeById(id);
    }

    @GetMapping(value = "/employee/name/{name}")
    public Mono<Employee> getEmployeeByName(@PathVariable("name") String name) {

        return employeeService.getEmployeeByName(name);
    }

    @PostMapping(value = "/employee", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Employee> createEmployee(@RequestBody Employee employee) {

        return employeeService.createEmployee(employee);
    }

    @DeleteMapping(value = "/employee/id/{id}")
    public Mono<String> deleteEmployeeById(@PathVariable("id") int id) {

        return employeeService.deleteEmployeeById(id);

    }


}

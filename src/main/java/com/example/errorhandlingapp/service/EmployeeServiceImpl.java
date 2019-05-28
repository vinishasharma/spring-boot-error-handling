package com.example.errorhandlingapp.service;


import com.example.errorhandlingapp.exception.DatabaseException;
import com.example.errorhandlingapp.exception.ExceptionHandler;
import com.example.errorhandlingapp.model.Employee;
import com.example.errorhandlingapp.repositories.EmployeeCouchBaseRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeCouchBaseRepository employeeRepository;

    @Override
    public Mono<Employee> getEmployeeById(int id) {

        return employeeRepository.findById(id)
                .switchIfEmpty(Mono.error(new DatabaseException("Employee with id " + id + " not found")));

    }

    @Override
    public Mono<Employee> getEmployeeByName(String name) {

        return employeeRepository.findByName(name);
    }

    @Override
    public Mono<Employee> createEmployee(Employee employee) {

        return employeeRepository.save(employee)
                .onErrorMap(ex -> ExceptionHandler.handleException(ex, "Creating Employee failed"));

    }

    @Override
    public Mono<String> deleteEmployeeById(int id) {

        return employeeRepository.deleteById(id)
                .then(Mono.just("Employee with id " + id + " is deleted."))
                .onErrorMap(ex -> {
                    throw new DatabaseException("Employee with id " + id + " is not found.");
                });

    }
}

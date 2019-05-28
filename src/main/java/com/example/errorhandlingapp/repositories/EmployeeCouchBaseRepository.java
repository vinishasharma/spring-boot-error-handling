package com.example.errorhandlingapp.repositories;


import com.example.errorhandlingapp.model.Employee;
import org.springframework.data.couchbase.repository.ReactiveCouchbaseRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface EmployeeCouchBaseRepository extends ReactiveCouchbaseRepository<Employee, Integer > {
    Flux<Employee> findAll();

    Mono<Employee> findById(Integer id);

    Mono<Employee> findByName(String Name);

    Mono<Employee> save(Employee employee);

    Mono<Void> deleteById(Integer id);
}

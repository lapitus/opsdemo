package com.lapitus.opsdemoapp.repositories;


import com.lapitus.opsdemoapp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}

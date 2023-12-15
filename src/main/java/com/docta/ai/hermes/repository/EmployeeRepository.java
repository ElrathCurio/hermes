package com.docta.ai.hermes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.docta.ai.hermes.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}

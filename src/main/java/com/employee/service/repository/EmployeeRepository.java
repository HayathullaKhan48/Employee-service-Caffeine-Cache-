package com.employee.service.repository;

import com.employee.service.entity.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeModel, Long> {
    Optional<EmployeeModel> findByPhoneNumber(String phoneNumber);
}

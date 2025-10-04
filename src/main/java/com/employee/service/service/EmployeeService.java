package com.employee.service.service;

import com.employee.service.request.EmployeeRequest;
import com.employee.service.response.EmployeeResponse;

import java.util.List;

public interface EmployeeService {

    EmployeeResponse createEmployee(EmployeeRequest request);
    List<EmployeeResponse> getAllEmployees();
    EmployeeResponse getByEmployeeId(Long id);
    EmployeeResponse getByPhoneNumber(String phoneNumber);
    EmployeeResponse updateAll(Long id, EmployeeRequest request);
    EmployeeResponse updateEmailAddress(Long id, String email);
    String deleteEmployee(Long id);
}

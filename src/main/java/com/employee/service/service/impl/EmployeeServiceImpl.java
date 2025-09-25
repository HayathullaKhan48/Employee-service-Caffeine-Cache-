package com.employee.service.service.impl;

import com.employee.service.entity.EmployeeModel;
import com.employee.service.mapper.EmployeeMapper;
import com.employee.service.repository.EmployeeRepository;
import com.employee.service.request.EmployeeRequest;
import com.employee.service.response.EmployeeResponse;
import com.employee.service.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;

    @Override
    @CachePut(value = "employees", key = "#result.employeeId")
    public EmployeeResponse createEmployee(EmployeeRequest request) {
        EmployeeModel saved = repository.save(EmployeeMapper.toEntity(request));
        return EmployeeMapper.toResponse(saved);
    }

    @Override
    @Cacheable(value = "employees")
    public List<EmployeeResponse> getAllEmployees() {
        return repository.findAll()
                .stream()
                .map(EmployeeMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Cacheable(value = "employee", key = "#id")
    public EmployeeResponse getByEmployeeId(Long id) {
        EmployeeModel employeeModel = repository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
        return EmployeeMapper.toResponse(employeeModel);
    }

    @Override
    @Cacheable(value = "employeePhone", key = "#phoneNumber")
    public EmployeeResponse getByPhoneNumber(String phoneNumber) {
        EmployeeModel employeeModel = repository.findByPhoneNumber(phoneNumber).orElseThrow(() -> new RuntimeException("Employee not found"));
        return EmployeeMapper.toResponse(employeeModel);
    }

    @Override
    @CachePut(value = "employee", key = "#id")
    public EmployeeResponse updateAll(Long id, EmployeeRequest request) {
        EmployeeModel employeeModel = repository.findById(id).orElseThrow(() ->
                new RuntimeException("Employee not found"));
        employeeModel.setName(request.getName());
        employeeModel.setPhoneNumber(request.getPhoneNumber());
        employeeModel.setEmailAddress(request.getEmailAddress());
        employeeModel.setDepartment(request.getDepartment());
        EmployeeModel updated = repository.save(employeeModel);
        return EmployeeMapper.toResponse(updated);
    }

    @Override
    @CachePut(value = "employee", key = "#id")
    public EmployeeResponse updateEmailAddress(Long id, String email) {
        EmployeeModel employeeModel = repository.findById(id).orElseThrow(() ->
                new RuntimeException("Employee not found"));
        employeeModel.setEmailAddress(email);
        EmployeeModel updated = repository.save(employeeModel);
        return EmployeeMapper.toResponse(updated);
    }

    @Override
    @CacheEvict(value = {"employee", "employees"}, key = "#id")
    public String deleteEmployee(Long id) {
        EmployeeModel employeeModel = repository.findById(id).orElseThrow(() ->
                new RuntimeException("Employee not found"));
        repository.delete(employeeModel);
        return "Employee with ID " + id + " deleted successfully!";
    }
}
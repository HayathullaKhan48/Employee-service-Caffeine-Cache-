package com.employee.service.controller;

import com.employee.service.request.EmployeeRequest;
import com.employee.service.response.EmployeeResponse;
import com.employee.service.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService service;

    @PostMapping("/create")
    public EmployeeResponse create(@RequestBody EmployeeRequest request) {
        return service.createEmployee(request);
    }

    @GetMapping("/getEmployees")
    public List<EmployeeResponse> getEmployees() {
        return service.getAllEmployees();
    }

    @GetMapping("/getByEmployeeId/{employeeId}")
    public EmployeeResponse getById(@PathVariable Long employeeId) {
        return service.getByEmployeeId(employeeId);
    }

    @GetMapping("/getByPhoneNumber/{phoneNumber}")
    public EmployeeResponse getByPhone(@PathVariable String phoneNumber) {
        return service.getByPhoneNumber(phoneNumber);
    }

    @PutMapping("/updateAll/{employeeId}")
    public EmployeeResponse updateAll(@PathVariable Long employeeId, @RequestBody EmployeeRequest request) {
        return service.updateAll(employeeId, request);
    }

    @PatchMapping("/updateEmployeeEmailAddress/{employeeId}")
    public EmployeeResponse updateEmailAddress(@PathVariable Long employeeId, @RequestParam String email) {
        return service.updateEmailAddress(employeeId, email);
    }

    @DeleteMapping("/delete/{employeeId}")
    public String delete(@PathVariable Long employeeId) {
        return service.deleteEmployee(employeeId);
    }
}


package com.employee.service.mapper;

import com.employee.service.entity.EmployeeModel;
import com.employee.service.request.EmployeeRequest;
import com.employee.service.response.EmployeeResponse;

public class EmployeeMapper {

    public static EmployeeModel toEntity(EmployeeRequest request){
        return EmployeeModel.builder()
                .name(request.getName())
                .phoneNumber(request.getPhoneNumber())
                .emailAddress(request.getEmailAddress())
                .department(request.getDepartment())
                .build();
    }

    public static EmployeeResponse toResponse(EmployeeModel model){
        return EmployeeResponse.builder()
                .employeeId(model.getEmployeeId())
                .name(model.getName())
                .phoneNumber(model.getPhoneNumber())
                .emailAddress(model.getEmailAddress())
                .department(model.getDepartment())
                .createdDate(model.getCreatedDate())
                .updatedDate(model.getUpdatedDate())
                .build();
    }
}

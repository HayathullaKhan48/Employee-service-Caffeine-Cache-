package com.employee.service.response;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponse {

    private Long employeeId;
    private String name;
    private String phoneNumber;
    private String emailAddress;
    private String department;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}

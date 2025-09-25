package com.employee.service.request;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequest {

    private String name;
    private String phoneNumber;
    private String emailAddress;
    private String department;
}

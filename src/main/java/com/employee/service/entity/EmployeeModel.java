package com.employee.service.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@Table(name = "Employees")
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "employeeId")
    private Long employeeId;

    @Column(name = "name")
    private String name;

    @Column(name = "phoneNumber", unique = true)
    private String phoneNumber;

    @Column(name = "emailAddress", unique = true)
    private String emailAddress;

    @Column(name = "department")
    private String department;

    @Column(name = "createdDate")
    @CreationTimestamp
    private LocalDateTime createdDate;

    @Column(name = "updatedDate")
    @UpdateTimestamp
    private LocalDateTime updatedDate;
}

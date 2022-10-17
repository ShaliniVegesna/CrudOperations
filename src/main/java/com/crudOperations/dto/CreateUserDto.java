package com.crudOperations.dto;

import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateUserDto {
    private Long id;
    private String name;
    private String job;
    private LocalDateTime createdAt;
}

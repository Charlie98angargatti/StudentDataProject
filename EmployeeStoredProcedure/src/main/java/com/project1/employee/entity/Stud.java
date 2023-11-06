package com.project1.employee.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stud {

	private LocalDateTime timestamp;

	private int code;

	private String status;

	private String message;
}

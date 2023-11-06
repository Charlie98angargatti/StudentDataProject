package com.project1.employee.validate;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
public class StudentValid {
   
	private int id;
	
	@Min(1)
	@Max(4)
	private int year;
	
	@NotBlank(message = "Name couldn't give a blank space")
	private String name;
	
	@NotBlank(message="Don't give a blank space ")
	private String branch;
	
	@NotBlank(message="select your college name")
	private String cname;
	
//	@Pattern(regexp = "^\\d{10}$", message = "Invalid mobile number you entered")
	private long mobile;
}

package com.tenco.model.student;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class StudentDTO {
	
	private String id;
	private String name;
	private String birth_date;
	private String gender;
	private String tel;
	private String email;
	private int dept_id;
	private int grade;
	private int semester;
	private String entrance_date;

}

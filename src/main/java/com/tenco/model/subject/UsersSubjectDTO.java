package com.tenco.model.subject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

public class UsersSubjectDTO {
	
	private int studentId;
	private String subjectName;
	private String professorName;
	private int roomId;
	private String departmentName;
	private String majorType;
	private String year;
	private String semester; 
	private String grades;
	
}

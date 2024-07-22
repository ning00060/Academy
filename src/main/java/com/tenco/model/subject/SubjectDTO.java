package com.tenco.model.subject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SubjectDTO {
	private int id;
	private String name;
	private int roomId;
	private String departmentName;
	private String majorType;
	private String year;
	private String semester;
	private String grades;
}

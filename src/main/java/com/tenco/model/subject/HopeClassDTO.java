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

public class HopeClassDTO {
	private int id;
	private int professorId;
	private String name;
	private String roomId;
	private int deptId;
	private String majorType;
	private int year;
	private int semester;
	private int grades;
}

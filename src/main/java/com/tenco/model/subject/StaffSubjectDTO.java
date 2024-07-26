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
public class StaffSubjectDTO {

		private int id;
		private String name;
		private int professorId;
		private String roomId;
		private int deptId;
		private String majorType;
		private int year;
		private int semester;
		private int grades;
}

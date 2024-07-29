package com.tenco.model.student;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Builder
public class EnrollSearchListDTO {
	// 학생의 아이디로 수강신청 완료된 목록을 확인하는 DTO 이다.
	
	private int s_number; // 과목번호
	private String name; // 과목이름
	private String professor; // 교수이름
	private int grades; // 학점
	private String room; // 강의실

}

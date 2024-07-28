package com.tenco.model.student;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class EnrollSearchDTO {
	// 학생이 강의 목록을 조회하기 위해서 만든 DTO
	String c_name; // 단과대학
	String d_name; // 개설학과
	int s_number; // 학수번호
	String s_major_type; // 강의구분
	String s_name; // 강의명
	String p_name; // 담당교수
	int s_grade; // 학점
	String s_room_id; // 강의실 
}

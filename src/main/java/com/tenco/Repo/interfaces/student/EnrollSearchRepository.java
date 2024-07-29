package com.tenco.Repo.interfaces.student;

import java.util.List;

import com.tenco.model.student.EnrollSearchDTO;
import com.tenco.model.student.EnrollSearchListDTO;
import com.tenco.model.temp.EnrollDTO;

public interface EnrollSearchRepository {
	
	// 학생 수강 리스트 페이지 확인
	List<EnrollSearchDTO> searchSubject(String major, String departname, String subjectname);
	
	// 학생 강의 예약 기능
	void InsertEnroll(int id1, int b);
	
	// 학생 수강신청 완료 리스트 보여주기 기능
	List<EnrollSearchListDTO> searchEnrollList(int number);
	
	// 학생이 수강신청(완료) 강의 목록보기 에서 취소 기능
	void DeleteEnroll(int student_id, int subject_id);
	
	// 학생이 수강신청 완료 후 같은 수강을 신청하지 못하게 학생 id로 과목 이름을 추출한다.
	List<EnrollDTO> SearchEnrollList(int student_id); 

}

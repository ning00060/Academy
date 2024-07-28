package com.tenco.Repo.interfaces.student;

import java.util.List;

import com.tenco.model.student.EnrollSearchDTO;
import com.tenco.model.student.EnrollSearchListDTO;

public interface EnrollSearchRepository {
	
	// 학생 수강 리스트 페이지 확인
	List<EnrollSearchDTO> searchSubject(String major, String departname, String subjectname);
	
	// 학생 강의 예약 기능
	void InsertEnroll(int id1, int b);
	
	// 학생 수강신청 완료 리스트 보여주기 기능
	List<EnrollSearchListDTO> searchEnrollList(int number);

}

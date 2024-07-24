package com.tenco.Repo.interfaces.student;

import com.tenco.model.student.StudentDTO;

public interface StudentRepository {
	// 학생 정보 출력
	StudentDTO studentInfo(int id);
	// 학생 정보 수정
	StudentDTO studentInfoModify(String password, String email, String tel, String address, int id);
	
//	StudentDTO selectStudentById(int id);
	
	// 보류 (내 정보 수정)
//	StudentDTO studentInfoModify(int password, String email, String tel, String address, int id);
	

}

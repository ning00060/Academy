package com.tenco.Repo.interfaces.student;

import java.util.List;

import com.tenco.model.student.StudentDTO;
import com.tenco.model.subject.UsersSubjectDTO;
import com.tenco.model.temp.EvaluationQuestionDTO;

public interface StudentRepository {
<<<<<<< HEAD
	
	StudentDTO search(int id);
	List<UsersSubjectDTO> readMySubject(int studentId, int year, int semester);
    StudentDTO studentInfo(int id);
    EvaluationQuestionDTO getEvaluationQuestion();
//    StudentDTO selectStudentById(int id);

    // 보류 (내 정보 수정)
//    StudentDTO studentInfoModify(int password, String email, String tel, String address, int id);


}
 
=======

	// 학생 정보 출력
	StudentDTO studentInfo(int id);
	// 학생 정보 수정
	StudentDTO studentInfoModify(String password, String email, String tel, String address, int id);
	
//	StudentDTO selectStudentById(int id);
	
	// 보류 (내 정보 수정)
//	StudentDTO studentInfoModify(int password, String email, String tel, String address, int id);
	

	
	StudentDTO search(int id);
	List<UsersSubjectDTO> readMySubject(int studentId, int year, int semester);

}

>>>>>>> d86186af8a7c574a94443a28fe149534a3638c6b

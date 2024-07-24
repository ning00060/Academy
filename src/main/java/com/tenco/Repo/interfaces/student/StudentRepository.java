package com.tenco.Repo.interfaces.student;

import java.util.List;

import com.tenco.model.student.StudentDTO;
import com.tenco.model.subject.UsersSubjectDTO;
import com.tenco.model.temp.EvaluationQuestionDTO;

public interface StudentRepository {
	
	StudentDTO search(int id);
	List<UsersSubjectDTO> readMySubject(int studentId, int year, int semester);
    StudentDTO studentInfo(int id);
    EvaluationQuestionDTO getEvaluationQuestion();
//    StudentDTO selectStudentById(int id);

    // 보류 (내 정보 수정)
//    StudentDTO studentInfoModify(int password, String email, String tel, String address, int id);


}
 
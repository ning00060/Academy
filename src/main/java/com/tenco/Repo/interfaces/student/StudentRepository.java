package com.tenco.Repo.interfaces.student;

import java.util.List;

import com.tenco.model.student.StudentDTO;
import com.tenco.model.subject.UsersSubjectDTO;

public interface StudentRepository {
<<<<<<< HEAD
	
	StudentDTO search(int id);
	List<UsersSubjectDTO> readMySubject(int studentId, int year, int semester);
}
=======


    StudentDTO studentInfo(int id);

//    StudentDTO selectStudentById(int id);

    // 보류 (내 정보 수정)
//    StudentDTO studentInfoModify(int password, String email, String tel, String address, int id);


}
>>>>>>> c3cc76563f1f4c720ec167e804a8492cd28f599e

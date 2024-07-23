package com.tenco.Repo.interfaces.student;

import java.util.List;

import com.tenco.model.student.StudentDTO;
import com.tenco.model.subject.UsersSubjectDTO;

public interface StudentRepository {
	
	StudentDTO search(int id);
	List<UsersSubjectDTO> readMySubject(int studentId, int year, int semester);
}

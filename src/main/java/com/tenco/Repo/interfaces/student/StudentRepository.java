package com.tenco.Repo.interfaces.student;

import com.tenco.model.student.StudentDTO;

public interface StudentRepository {
	
	StudentDTO search(int id);

}

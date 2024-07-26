package com.tenco.Repo.interfaces.staff;

import java.util.List;

import com.tenco.model.student.StudentDTO;

public interface StaffStudentRepository {
	List<StudentDTO> SelectStudentAll();

	StudentDTO selectStudentById(int id);

	StudentDTO selectStudentByNameEmail(StudentDTO studentDTO);
}

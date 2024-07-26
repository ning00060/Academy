package com.tenco.Repo.interfaces.staff;

import java.util.List;

import com.tenco.model.staff.staffProfessorDTO;

public interface StaffProfessorRepository {


	List<staffProfessorDTO> SelectStudentAll();
	staffProfessorDTO selectStudentById(int id);
	staffProfessorDTO selectStudentByNameEmail(staffProfessorDTO staffProfessorDTO);


}

package com.tenco.Repo.interfaces.staff;

import com.tenco.model.professor.ProfessorDTO;
import com.tenco.model.staff.StaffDTO;
import com.tenco.model.student.StudentDTO;

public interface StaffRepository {
	StaffDTO selectUserIdById(int id);
	StaffDTO selectUserIdByNameEmail();
	StaffDTO selectUserIdByNameIdEmail();
	int addUser(StaffDTO staffDTO,String password );
	StaffDTO addStaff(StaffDTO staffDTO);
	
	int addUserStaff(StaffDTO staffDTO,String password );
	int addUserProfessor(ProfessorDTO professorDTO,String password );
	int addUserStudent(StudentDTO studentDTO,String password );
	void updateUserStaff(StaffDTO staffDTO,String password,int level ,int id);
	void updateUserProfessor(ProfessorDTO professorDTO,String password,int level ,int id);
	void updateUserStudent(StudentDTO studentDTO,String password,int level,int id );

	StaffDTO getAllInfoById(int id);
}

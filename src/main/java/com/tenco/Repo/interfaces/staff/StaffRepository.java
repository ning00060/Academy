package com.tenco.Repo.interfaces.staff;

import com.tenco.model.staff.StaffDTO;

import java.util.List;

import com.tenco.model.staff.DepartmentDTO;

public interface StaffRepository {

	StaffDTO selectUserIdByNameEmail();
	StaffDTO selectUserIdByNameIdEmail();
	StaffDTO getAllInfoById(int id);
	
	//학과 관련
	void addDepartment(DepartmentDTO departmentDTO);
	void deleteDepartment(int id);
	List<DepartmentDTO> getAllDepartments();
	DepartmentDTO getDepartment(int id);
	void upDateDepartmentById(int id);
	
	
	
}

package com.tenco.Repo.interfaces.temp;

import java.util.List;

import com.tenco.model.temp.DepartmentDTO;

public interface DepartmentRepository {

	List<DepartmentDTO> selectDepartmentAll();
	DepartmentDTO selectDepartmentById(int id);
	void addDepartment(DepartmentDTO departmentDTO);
	void updateDepartment(DepartmentDTO departmentDTO,int id);
	void deleteDepartment(int id);
}

package com.tenco.Repo.interfaces.staff;

import java.util.List;

import com.tenco.model.subject.StaffSubjectDTO;

public interface StaffSubjectRepository {

	List<StaffSubjectDTO> selectSubjectAll();
	StaffSubjectDTO selectSubjectById(int id);
	List<StaffSubjectDTO> orderHopeclass();
	void addSubject(StaffSubjectDTO staffSubjectDTO);
	void updateSubject(StaffSubjectDTO subjectDTO,int id);
	void deleteSubject(int id);
}

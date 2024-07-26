package com.tenco.Repo.interfaces.staff;

import java.util.List;

import com.tenco.model.subject.StaffSubjectDTO;

public interface SubjectRepository {

	List<StaffSubjectDTO> selectSubjectAll();
	StaffSubjectDTO selectSubjectById(int id);
	void addSubject(StaffSubjectDTO staffSubjectDTO);
	void updateSubject(StaffSubjectDTO subjectDTO,int id);
	void deleteSubject(int id);
}

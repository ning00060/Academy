package com.tenco.Repo.interfaces.professor;

import java.util.List;

import com.tenco.model.subject.SubjectDTO;

public interface ProfessorRepository {
	List<SubjectDTO> selectAllSubjectByProfessorIdYearSemester(int professorId, int year, int semester);
	
}

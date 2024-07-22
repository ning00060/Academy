package com.tenco.Repo.professor;

import java.util.ArrayList;
import java.util.List;

import com.tenco.Repo.interfaces.professor.ProfessorRepository;
import com.tenco.model.subject.SubjectDTO;

public class ProfessorRepositoryImpl implements ProfessorRepository{
	
	
	
	// 교수 id로 자신의 모든 강의를 조회 / 과목 DTO 리스트로 반환
	@Override
	public List<SubjectDTO> selectAllSubjectByProfessorId() {
		List<SubjectDTO> subjectList = new ArrayList<>();
		return subjectList;
	}

}

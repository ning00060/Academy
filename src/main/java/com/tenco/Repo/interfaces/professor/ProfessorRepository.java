package com.tenco.Repo.interfaces.professor;

import java.util.List;

import com.tenco.model.professor.StudentIdNameDTO;
import com.tenco.model.subject.SubjectDTO;

public interface ProfessorRepository {
	List<SubjectDTO> selectAllSubjectByProfessorIdYearSemester(int professorId, int year, int semester);
	void insertStudentsGradesByStudentId(int studentId, int midExam, int finalExam, int convertedMark);
	List<StudentIdNameDTO> selectStudentIdNameBySubjectId(int subjectId);
}

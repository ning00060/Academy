package com.tenco.Repo.interfaces.professor;

import java.util.List;

import com.tenco.model.professor.EvaluationResultDTO;
import com.tenco.model.professor.RestClassDTO;
import com.tenco.model.student.StudentIdNameDTO;
import com.tenco.model.subject.SubjectDTO;

public interface ProfessorRepository {
	List<SubjectDTO> selectAllSubjectByProfessorIdYearSemester(int professorId, int year, int semester);
	void insertStudentsGradesByStudentId(int studentId, int subjectId, int midExam, int finalExam, float convertedMark);
	List<StudentIdNameDTO> selectStudentIdNameBySubjectId(int subjectId);
	List<RestClassDTO> selectRestClassByProfessorId(int professorId, int year, int semester);
	void insertRestClass(int subjectId, String subjectName, int professorId, String restDay, String roomId, int year, int semester, String supplement);
	List<EvaluationResultDTO> selectEvaluationResultBySubjectId(int subjectId);
}

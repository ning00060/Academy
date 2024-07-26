package com.tenco.Repo.staff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tenco.Repo.interfaces.staff.SubjectRepository;
import com.tenco.model.subject.StaffSubjectDTO;
import com.tenco.model.subject.SubjectDTO;
import com.tenco.model.temp.RoomDTO;
import com.tenco.util.DBUtil;

public class SubjectRepositoryImpl implements SubjectRepository{
	private static final String SELECT_SUBJECT_ALL="select * from tb_subject ";
	private static final String SELECT_SUBJECT_BY_ID="select * from tb_subject where id=? ";
	private static final String ADD_SUBJECT="insert into tb_subject values(?, ?,?,?,?,?,?,?,?) ";
	private static final String UPDATE_SUBJECT=" update tb_room set id=? or name=? or professor_id=? or\r\n"
			+ "		room_id=? or dept_id=? or major_type=? or year=? or semester=? or grades=? where id=? ";
	private static final String DELETE_SUBJECT="delete from tb_subject where id=? ";
	
	
	@Override
	public List<StaffSubjectDTO> selectSubjectAll() {
		List<StaffSubjectDTO> subList = new ArrayList<>();
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECT_SUBJECT_ALL)) {
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				subList.add(StaffSubjectDTO.builder()
						.id(rs.getInt("id"))
						.name(rs.getString("name"))
						.professorId(rs.getInt("professor_id"))
						.roomId(rs.getString("room_id"))
						.deptId(rs.getInt("dept_id"))
						.majorType(rs.getString("major_type"))
						.year(rs.getInt("year"))
						.semester(rs.getInt("semester"))
						.grades(rs.getInt("grades"))
						.build());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return subList;
	}


	@Override
	public StaffSubjectDTO selectSubjectById(int id) {
		StaffSubjectDTO subjectDTO = null;
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECT_SUBJECT_BY_ID)) {
				pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				subjectDTO=StaffSubjectDTO.builder()
						.id(rs.getInt("id"))
						.name(rs.getString("name"))
						.professorId(rs.getInt("professor_id"))
						.roomId(rs.getString("room_id"))
						.deptId(rs.getInt("dept_id"))
						.majorType(rs.getString("major_type"))
						.year(rs.getInt("year"))
						.semester(rs.getInt("semester"))
						.grades(rs.getInt("grades"))
						.build();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return subjectDTO;
	}


	@Override
	public void addSubject(StaffSubjectDTO staffSubjectDTO) {
		try (Connection conn=DBUtil.getConnection()){
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt=conn.prepareStatement(ADD_SUBJECT)){
				pstmt.setInt(1, staffSubjectDTO.getId());
				pstmt.setString(2, staffSubjectDTO.getName());
				pstmt.setInt(3, staffSubjectDTO.getProfessorId());
				pstmt.setString(4, staffSubjectDTO.getRoomId());
				pstmt.setInt(5, staffSubjectDTO.getDeptId());
				pstmt.setString(6, staffSubjectDTO.getMajorType());
				pstmt.setInt(7, staffSubjectDTO.getYear());
				pstmt.setInt(8, staffSubjectDTO.getSemester());
				pstmt.setInt(9, staffSubjectDTO.getGrades());
				pstmt.executeUpdate();
				conn.commit();
				System.out.println("add커밋됨:" +staffSubjectDTO.toString() );
			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateSubject(StaffSubjectDTO subjectDTO, int id) {
		try (Connection conn=DBUtil.getConnection()){
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt=conn.prepareStatement(UPDATE_SUBJECT)){
				pstmt.setInt(1, subjectDTO.getId());
				pstmt.setString(2, subjectDTO.getName());
				pstmt.setInt(3, subjectDTO.getProfessorId());
				pstmt.setString(4, subjectDTO.getRoomId());
				pstmt.setInt(5, subjectDTO.getDeptId());
				pstmt.setString(6, subjectDTO.getMajorType());
				pstmt.setInt(7, subjectDTO.getYear());
				pstmt.setInt(8, subjectDTO.getSemester());
				pstmt.setInt(9, subjectDTO.getGrades());
				pstmt.setInt(10, id);
				pstmt.executeUpdate();
				
				conn.commit();
			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	@Override
	public void deleteSubject(int id) {
		try (Connection conn=DBUtil.getConnection()){
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt=conn.prepareStatement(DELETE_SUBJECT)){
				pstmt.setInt(1, id);
				pstmt.executeUpdate();
				conn.commit();
			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}



}

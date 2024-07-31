package com.tenco.Repo.staff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tenco.Repo.interfaces.staff.StaffSubjectRepository;
import com.tenco.model.subject.StaffSubjectDTO;
import com.tenco.util.DBUtil;

public class StaffSubjectRepositoryImpl implements StaffSubjectRepository{
	private static final String SELECT_SUBJECT_ALL="select * from tb_subject ";
	private static final String SELECT_SUBJECT_BY_ID="select * from tb_subject where id=? ";
	private static final String SELECT_HOPECLASS=" select * from tb_hopeclass  ";
	private static final String UPDATE_SUBJECT=" update tb_room set id=? or name=? or professor_id=? or\r\n"
			+ "		room_id=? or dept_id=? or major_type=? or year=? or semester=? or grades=? where id=? ";
	private static final String DELETE_SUBJECT="delete from tb_subject where id=? ";
	private static final String ADD_SUBJECT="insert into tb_subject(name,professor_id,room_id,dept_id,major_type,year,semester,grades) values( ?,?,?,?,?,?,?,?) ";
	private static final String ADD_SUBSCHEDULE="insert into tb_sub_schedule(subject_id,day,period,limit_count) values(? ,? ,? ,?) ";
	
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
	public void addSubject(StaffSubjectDTO staffSubjectDTO,int day,int period,int limitCount) {
		try (Connection conn=DBUtil.getConnection()){
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt1 = conn.prepareStatement(ADD_SUBJECT, Statement.RETURN_GENERATED_KEYS);
					PreparedStatement pstmt2 = conn.prepareStatement(ADD_SUBSCHEDULE)) {
				pstmt1.setString(1, staffSubjectDTO.getName());
				pstmt1.setInt(2, staffSubjectDTO.getProfessorId());
				pstmt1.setString(3, staffSubjectDTO.getRoomId());
				pstmt1.setInt(4, staffSubjectDTO.getDeptId());
				pstmt1.setString(5, staffSubjectDTO.getMajorType());
				pstmt1.setInt(6, staffSubjectDTO.getYear());
				pstmt1.setInt(7, staffSubjectDTO.getSemester());
				pstmt1.setInt(8, staffSubjectDTO.getGrades());
				pstmt1.executeUpdate();
				// 생성된 키 가져오기
				try (ResultSet generatedKeys = pstmt1.getGeneratedKeys()) {
					if (generatedKeys.next()) {
						int id = generatedKeys.getInt(1);
						staffSubjectDTO.setId(id);
						System.out.println();
					} else {
						throw new SQLException("ID없음");
					}
				}

				// ADD_USER 작업
				pstmt2.setInt(1, staffSubjectDTO.getId());
				pstmt2.setInt(2, day);
				pstmt2.setInt(3, period);
				pstmt2.setInt(4, limitCount);
				pstmt2.executeUpdate();

				conn.commit(); // 트랜잭션 커밋
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
				pstmt.setInt(10, subjectDTO.getId());
				pstmt.setString(2, subjectDTO.getName());
				pstmt.setInt(3, subjectDTO.getProfessorId());
				pstmt.setString(4, subjectDTO.getRoomId());
				pstmt.setInt(5, subjectDTO.getDeptId());
				pstmt.setString(6, subjectDTO.getMajorType());
				pstmt.setInt(7, subjectDTO.getYear());
				pstmt.setInt(8, subjectDTO.getSemester());
				pstmt.setInt(9, subjectDTO.getGrades());
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


	@Override
	public List<StaffSubjectDTO> orderHopeclass() {
		List<StaffSubjectDTO> subjectList = new ArrayList<>();
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECT_HOPECLASS)) {
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				subjectList.add( StaffSubjectDTO.builder()
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
		return subjectList;
	}

}

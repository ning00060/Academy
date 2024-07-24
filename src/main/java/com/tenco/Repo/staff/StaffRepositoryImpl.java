package com.tenco.Repo.staff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.tenco.Repo.interfaces.staff.StaffRepository;
import com.tenco.model.professor.ProfessorDTO;
import com.tenco.model.staff.StaffDTO;
import com.tenco.model.student.StudentDTO;
import com.tenco.util.DBUtil;

public class StaffRepositoryImpl implements StaffRepository{
	private static final String ADD_STAFF=" INSERT INTO tb_staff(name,birth_date,gender,address,tel,email) VALUES (?,?,?,?,?,?) ";
	private static final String ADD_PROFESSOR=" INSERT INTO tb_staff(name,birth_date,gender,address,tel,email,dept_id) VALUES (?,?,?,?,?,?,?) ";
	private static final String ADD_STUDENT=" INSERT INTO tb_staff(name,birth_date,gender,address,tel,email) VALUES (?,?,?,?,?,?) ";
	private static final String SELECT_STAFF_BY_EMAIL=" SELECT * FROM tb_staff WHERE email=? ";
	private static final String ADD_USER=" INSERT INTO tb_user VALUES(?,?,?) ";
	
	
	@Override
	public StaffDTO selectUserIdByNameEmail() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StaffDTO selectUserIdByNameIdEmail() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StaffDTO addStaff(StaffDTO DTO) {
		StaffDTO staffDTO=null;
		try (Connection conn=DBUtil.getConnection()){
			conn.setAutoCommit(false);
			try(PreparedStatement pstmt=conn.prepareStatement(ADD_STAFF);
					PreparedStatement pstmt2=conn.prepareStatement(SELECT_STAFF_BY_EMAIL)	) {
				pstmt.setString(1, DTO.getName());
				pstmt.setString(2, DTO.getBirthDate());
				pstmt.setString(3, DTO.getGender());
				pstmt.setString(4, DTO.getAddress());
				pstmt.setString(5, DTO.getTel());
				pstmt.setString(6, DTO.getEmail());
				pstmt.executeUpdate();
				
				pstmt2.setString(1, DTO.getEmail());
				ResultSet rs=pstmt2.executeQuery();
				if(rs.next()) {
					staffDTO=StaffDTO.builder()
							.id(rs.getInt("id"))
							.name(rs.getString("name"))
							.build();
				}
				conn.commit();
			} catch (Exception e) {
				e.printStackTrace();
			} 
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return staffDTO;
	}

	@Override
	public int addUser(StaffDTO staffDTO,String password) {
		int rowCount=0;
		try (Connection conn=DBUtil.getConnection()){
			conn.setAutoCommit(false);
			try(PreparedStatement pstmt=conn.prepareStatement(ADD_USER)) {
				pstmt.setInt(1, staffDTO.getId());
				pstmt.setString(2, password);
				pstmt.setInt(3, 3);
				rowCount= pstmt.executeUpdate();
				conn.commit();
			} catch (Exception e) {
				e.printStackTrace();
			} 
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return rowCount;
	}

	public int addUserStaff(StaffDTO staffDTO, String password) {
	    int rowCount = 0;
	    try (Connection conn = DBUtil.getConnection()) {
	        conn.setAutoCommit(false); // 트랜잭션 시작

	        try (PreparedStatement pstmt1 = conn.prepareStatement(ADD_STAFF, Statement.RETURN_GENERATED_KEYS);
	             PreparedStatement pstmt2 = conn.prepareStatement(ADD_USER)) {

	            // ADD_STAFF 작업
	            pstmt1.setString(1, staffDTO.getName());
	            java.sql.Date birthDate = java.sql.Date.valueOf(staffDTO.getBirthDate());
	            pstmt1.setDate(2, birthDate);
	            pstmt1.setString(3, staffDTO.getGender());
	            pstmt1.setString(4, staffDTO.getAddress());
	            pstmt1.setString(5, staffDTO.getTel());
	            pstmt1.setString(6, staffDTO.getEmail());
	            pstmt1.executeUpdate();

	            // 생성된 키 가져오기
	            try (ResultSet generatedKeys = pstmt1.getGeneratedKeys()) {
	                if (generatedKeys.next()) {
	                    int id = generatedKeys.getInt(1);
	                    staffDTO.setId(id);
	                    System.out.println();
	                } else {
	                    throw new SQLException("ID없음");
	                }
	            }

	            // ADD_USER 작업
	            pstmt2.setInt(1, staffDTO.getId());
	            pstmt2.setString(2, password);
	            pstmt2.setInt(3, 3); // 파라미터
	            rowCount = pstmt2.executeUpdate();

	            conn.commit(); // 트랜잭션 커밋
	        } catch (Exception e) {
	            conn.rollback(); // 예외 발생 시 롤백
	            e.printStackTrace();
	            throw e; 
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return rowCount;
	}

	@Override
	public int addUserProfessor(ProfessorDTO professorDTO, String password) {
		int rowCount = 0;
	    try (Connection conn = DBUtil.getConnection()) {
	        conn.setAutoCommit(false); // 트랜잭션 시작

	        try (PreparedStatement pstmt1 = conn.prepareStatement(ADD_PROFESSOR, Statement.RETURN_GENERATED_KEYS);
	             PreparedStatement pstmt2 = conn.prepareStatement(ADD_USER)) {

	            // ADD_PROFESSOR 작업
	            pstmt1.setString(1, staffDTO.getName());
	            java.sql.Date birthDate = java.sql.Date.valueOf(staffDTO.getBirthDate());
	            pstmt1.setDate(2, birthDate);
	            pstmt1.setString(3, staffDTO.getGender());
	            pstmt1.setString(4, staffDTO.getAddress());
	            pstmt1.setString(5, staffDTO.getTel());
	            pstmt1.setString(6, staffDTO.getEmail());
	            pstmt1.executeUpdate();

	            // 생성된 키 가져오기
	            try (ResultSet generatedKeys = pstmt1.getGeneratedKeys()) {
	                if (generatedKeys.next()) {
	                    int id = generatedKeys.getInt(1);
	                    staffDTO.setId(id);
	                    System.out.println();
	                } else {
	                    throw new SQLException("ID없음");
	                }
	            }

	            // ADD_USER 작업
	            pstmt2.setInt(1, staffDTO.getId());
	            pstmt2.setString(2, password);
	            pstmt2.setInt(3, 3); // 파라미터
	            rowCount = pstmt2.executeUpdate();

	            conn.commit(); // 트랜잭션 커밋
	        } catch (Exception e) {
	            conn.rollback(); // 예외 발생 시 롤백
	            e.printStackTrace();
	            throw e; 
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return rowCount;
	}

	@Override
	public int addUserStudent(StudentDTO studentDTO, String password) {
		// TODO Auto-generated method stub
		return 0;
	}


//	@Override
//	public int addUserStaff(StaffDTO staffDTO,String password) {
//		StaffDTO DTO=addStaff(staffDTO);
//		int rowCount=addUser(DTO,password);
//		return rowCount;
//	}



}

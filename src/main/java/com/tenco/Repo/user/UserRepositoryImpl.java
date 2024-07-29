package com.tenco.Repo.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.tenco.Repo.interfaces.user.UserRepository;
import com.tenco.model.staff.StaffUserDTO;
import com.tenco.model.user.UserDTO;
import com.tenco.util.DBUtil;

public class UserRepositoryImpl implements UserRepository {
	private static final String SELECT_USERID_BY_NAME_EMAIL_STUDENT = " select u.id from tb_user as u join tb_student  as s on u.id=s.id\r\n"
			+ "where email= ? and name= ? ";
	private static final String SELECT_USERID_BY_NAME_EMAIL_PROFESSOR = " select u.id from tb_user as u join tb_professor  as s on u.id=s.id\r\n"
			+ "where email= ? and name= ? ";
	private static final String SELECT_USERID_BY_NAME_EMAIL_STAFF = " select u.id from tb_user as u join tb_staff  as s on u.id=s.id\r\n"
			+ "where email= ? and name= ? ";
	private static final String SELECT_USERPW_BY_ID_NAME = " select u.password from tb_user as u join tb_student  as s on u.id=s.id\r\n"
			+ "where u.id=? and name=?  ";

	@Override
	public UserDTO userLogin(int id, String password) {
		// TODO - sql 작성
		String commonSql = " SELECT id,permission_level FROM tb_user where id = ? and password = ? ";
		String sqlStudent = " SELECT * FROM tb_student where id = ? ";
		String sqlProfessor = " SELECT * FROM tb_professor where id = ? ";
		String sqlStaff = " SELECT * FROM tb_staff where id = ? ";
		UserDTO verifiedUser = null;

		String tempSql = null;
		int tempId = 0;
		int tempPL = 0;
		try (Connection conn = DBUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(commonSql)) {
			pstmt.setInt(1, id);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {

				tempId = rs.getInt("id");
				tempPL = rs.getInt("permission_level");
				if (tempPL == 1) {
					tempSql = sqlStudent;
					verifiedUser = checkStudent(conn, tempSql, tempId, tempPL);
				} else if (tempPL == 2) {
					tempSql = sqlProfessor;
					verifiedUser = checkCommon(conn, tempSql, tempId, tempPL);
				} else if (tempPL == 3) {
					tempSql = sqlStaff;
					verifiedUser = checkCommon(conn, tempSql, tempId, tempPL);
				} else {
					// TODO handle exception
				}
				System.out.println(tempPL);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// System.out.println(verifiedUser.toString()+" /UserRepositoryImpl");
		return verifiedUser;
	}

	private UserDTO checkCommon(Connection conn, String tempSql, int tempId, int tempPL) {

		UserDTO verifiedUser = null;
		try (PreparedStatement pstmt2 = conn.prepareStatement(tempSql)) {
			pstmt2.setInt(1, tempId);
			ResultSet rs2 = pstmt2.executeQuery();
			if (rs2.next()) {
				verifiedUser = UserDTO.builder().id(tempId).permissionLevel(tempPL).name(rs2.getString("name"))
						.birth(rs2.getString("birth_date")).gender(rs2.getString("gender"))
						.address(rs2.getString("address")).phoneNum(rs2.getString("tel")).email(rs2.getString("email"))
						.build();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return verifiedUser;

	}

	private UserDTO checkStudent(Connection conn, String tempSql, int tempId, int tempPL) {
		UserDTO verifiedUser = null;
		try (PreparedStatement pstmt2 = conn.prepareStatement(tempSql)) {
			pstmt2.setInt(1, tempId);
			ResultSet rs2 = pstmt2.executeQuery();
			if (rs2.next()) {
				verifiedUser = UserDTO.builder().id(tempId).permissionLevel(tempPL).name(rs2.getString("name"))
						.birth(rs2.getString("birth_date")).gender(rs2.getString("gender"))
						.address(rs2.getString("address")).phoneNum(rs2.getString("tel")).email(rs2.getString("email"))
						.build();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return verifiedUser;

	}

	@Override
	public StaffUserDTO userId(String name, String email, int num) {
		StaffUserDTO userDTO = null;
		String query = null;
		if (num == 1) {
			query = SELECT_USERID_BY_NAME_EMAIL_STUDENT;
		} else if (num == 2) {
			query = SELECT_USERID_BY_NAME_EMAIL_PROFESSOR;
		} else if (num == 3) {
			query = SELECT_USERID_BY_NAME_EMAIL_STAFF;
		}
		try (Connection conn = DBUtil.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, email);
			pstmt.setString(2, name);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				userDTO = StaffUserDTO.builder().id(rs.getInt("id")).build();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return userDTO;

	}

	@Override
	public StaffUserDTO userPw(int id, String name) {
		StaffUserDTO userDTO = null;

		try (Connection conn = DBUtil.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(SELECT_USERPW_BY_ID_NAME);
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				userDTO = StaffUserDTO.builder()
						.id(id)
						.password(rs.getString("password"))
						.build();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return userDTO;

	}

}

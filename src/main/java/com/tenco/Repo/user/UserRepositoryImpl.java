package com.tenco.Repo.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.tenco.Repo.interfaces.user.UserRepository;
import com.tenco.model.user.UserDTO;
import com.tenco.util.DBUtil;

public class UserRepositoryImpl implements UserRepository{

	@Override
	public UserDTO userLogin(int id, String password) {
		//TODO - sql 작성
		String sql = " SELECT id,permission_level FROM tb_user where id = ? and password = ? ";
		UserDTO verifiedUser = null;
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setInt(1, id);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				verifiedUser = UserDTO.builder()
									.id(rs.getString("id"))
									.permissionLevel(rs.getInt("permission_level"))
									.build();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(verifiedUser.toString()+" /UserRepositoryImpl");
		return verifiedUser;
	}

}

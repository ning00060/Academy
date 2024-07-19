package com.tenco.Repo.user;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.tenco.Repo.interfaces.user.UserRepository;
import com.tenco.util.DBUtil;

public class UserRepositoryImpl implements UserRepository{

	@Override
	public int userLogin(String id, String password) {
		//TODO - sql 작성
		String sql = "";
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return 0;
	}

}

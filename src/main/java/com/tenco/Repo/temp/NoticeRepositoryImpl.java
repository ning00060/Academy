package com.tenco.Repo.temp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tenco.Repo.interfaces.temp.NoticeRepository;
import com.tenco.model.temp.NoticeDTO;
import com.tenco.model.user.UserDTO;
import com.tenco.util.DBUtil;

import lombok.Builder;

public class NoticeRepositoryImpl implements NoticeRepository{
			private static final String SELECT_NOTICE_ALL	=" select * from tb_notice order by created_time desc ";
			private static final String SELECT_NOTICE_ALL_5	=" select * from tb_notice order by created_time desc limit 5 ";
	
			
			
			
			
			
	@Override
	public NoticeDTO SelectNoticeById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NoticeDTO> SelectNoitceAll() {
		List<NoticeDTO> noticeList=new ArrayList<>();
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECT_NOTICE_ALL)){
			ResultSet rs = pstmt.executeQuery();
			System.out.println("noticeAll 받음");
			while (rs.next()) {
				noticeList.add(NoticeDTO.builder()
						.id(rs.getInt("id"))
						.category(rs.getString("category"))
						.title(rs.getString("title"))
						.content(rs.getString("content"))
						.createdTime(rs.getTimestamp("created_time"))
						.views(rs.getInt("views"))
						.build());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return noticeList;
	}

	@Override
	public List<NoticeDTO> SelectNoitceAll5() {
		List<NoticeDTO> noticeList=new ArrayList<>();
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECT_NOTICE_ALL_5)){
			ResultSet rs = pstmt.executeQuery();
			System.out.println("noticeAll 받음");
			while (rs.next()) {
				noticeList.add(NoticeDTO.builder()
						.id(rs.getInt("id"))
						.category(rs.getString("category"))
						.title(rs.getString("title"))
						.content(rs.getString("content"))
						.createdTime(rs.getTimestamp("created_time"))
						.views(rs.getInt("views"))
						.build());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return noticeList;
	}

}

package com.tenco.Repo.interfaces.temp;

import java.util.List;

import com.tenco.model.temp.NoticeDTO;

public interface NoticeRepository {

	NoticeDTO SelectNoticeById();
	List<NoticeDTO> SelectNoitceAll();
	List<NoticeDTO> SelectNoitceAll5();
}

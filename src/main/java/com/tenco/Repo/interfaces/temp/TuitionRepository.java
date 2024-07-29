package com.tenco.Repo.interfaces.temp;

import java.util.List;

import com.tenco.model.temp.TuitionDTO;

public interface TuitionRepository {

	List< TuitionDTO> selectTuitionAll();
	void addTuition(TuitionDTO tuitionDTO);
	void updateTution(TuitionDTO tuitionDTO,int id);
	void deleteTution(int id);
}

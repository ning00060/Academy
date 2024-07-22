package com.tenco.Repo.interfaces.staff;

import com.tenco.model.staff.StaffDTO;

public interface StaffRepository {

	StaffDTO selectUserIdByNameEmail();
	StaffDTO selectUserIdByNameIdEmail();
}

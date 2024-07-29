package com.tenco.Repo.interfaces.user;

import com.tenco.model.staff.StaffUserDTO;
import com.tenco.model.user.UserDTO;

public interface UserRepository {

	UserDTO userLogin(int id, String password);

	StaffUserDTO userId(String name, String email, int num);

	StaffUserDTO userPw(int id, String name);

}

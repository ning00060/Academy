package com.tenco.model.staff;

import com.tenco.model.user.UserDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@ToString
public class StaffUserDTO {
	private int id;
	private String password;
	private int permissionLevel;
}

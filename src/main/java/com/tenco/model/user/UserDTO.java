package com.tenco.model.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@Getter
@Builder

public class UserDTO {
	
	private String id;
	private int permissionLevel;
}

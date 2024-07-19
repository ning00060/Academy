package com.tenco.model.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@Getter
@Builder
@ToString

public class UserDTO {
	
	private String id;
	private int permissionLevel;
}

package com.ast.zeus.biller.vo;

import java.io.Serializable;

import org.springframework.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserVO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Integer id;

	@NonNull
	private String userName;
	
	@NonNull
	private String password;
}

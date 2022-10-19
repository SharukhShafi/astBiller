package com.ast.zeus.biller.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class DriverVO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Integer driverID;

	private String driverName;

	private String driverMobileNumber;
}

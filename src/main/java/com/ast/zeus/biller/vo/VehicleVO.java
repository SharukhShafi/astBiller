package com.ast.zeus.biller.vo;

import java.io.Serializable;
import java.util.Date;

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
public class VehicleVO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private VehicleTypeVO vehicleTypeVO;

	private String vehicleNumber;

	private Date createdDtm = new Date();

	private String color;
}

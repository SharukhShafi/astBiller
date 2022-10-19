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
public class VehicleTypeVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String vehicleType;

	private boolean isAc;

	private Date createdDtm;

	private Double costPerBasicKms;
}

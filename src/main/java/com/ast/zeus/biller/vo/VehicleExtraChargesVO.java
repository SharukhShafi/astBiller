package com.ast.zeus.biller.vo;

import java.io.Serializable;
import java.util.Objects;

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
public class VehicleExtraChargesVO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private VehicleTypeVO vehicleTypeVO;

	private double kmsCost;

	private double timeCost;

}

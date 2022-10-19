package com.ast.zeus.biller.vo;

import java.io.Serializable;
import java.time.LocalDateTime;

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
public class TripSheetVO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private VehicleVO vehicleVO;

	private DriverVO driver;

	private String facilitatedStaff;

	private LocalDateTime startDateTime;

	private LocalDateTime closeDateTime;

	private double startKms;

	private double closeKms;

	private double parkingFee;

	private double extraTime;

	private double extraKms;

	private CompanyVO company;

	private LocalDateTime createdDtm;

	private LocalDateTime lastUpdatedDtm;

	private double totalAmount;

	private double totalRunningHours;

	private double totalRunningKms;

}

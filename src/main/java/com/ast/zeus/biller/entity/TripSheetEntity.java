package com.ast.zeus.biller.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="trip_sheet")
public class TripSheetEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name ="trip_sheet_id", unique = true, nullable = false)
	private Integer tripSheetId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="vehicle_id")
	private VehicleEntity vehicle;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="driver_id")
	private DriverEntity driver;
	
	@Column(name ="facilitated_staff")
	private String facilitatedStaff;

	@Column(name ="start_time")
	private LocalTime startTime;

	@Column(name ="closing_time")
	private LocalTime closeTime;

	@Column(name ="start_kms")
	private double startKms;
	
	@Column(name ="closing_kms")
	private double closeKms;
	
	@Column(name ="parking_fee")
	private double parkingFee;

	@Column(name="total_running_hours")
	private double totalRunningHours;

	@Column(name="total_running_kms")
	private double totalRunningKms;
	
	@Column(name ="extra_time")
	private double extraTime;
	
	@Column(name ="extra_kms")
	private double extraKms;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="company_id")
	private CompanyEntity company;
	
	@Column(name ="created_datetime")
	private LocalDateTime createdDtm;
	
	@Column(name ="lastupdated_datetime")
	private LocalDateTime lastUpdatedDtm;
	
	@Column(name ="total_amount")
	private double totalAmount;

}

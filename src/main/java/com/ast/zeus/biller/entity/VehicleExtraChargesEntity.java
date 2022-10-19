package com.ast.zeus.biller.entity;

import java.io.Serializable;
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
@Table(name="vehicle_extra_charges")
public class VehicleExtraChargesEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name ="vehicle_extra_id", unique = true, nullable = false)
	private Integer vehicleTypeId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="vehicle_type_id")
	private VehicleTypeEntity vehicleTypeEntity;
	
	@Column(name ="cost_per_extra_kilometer")
	private double kmsCost;
	
	@Column(name ="cost_per_extra_time")
	private double timeCost;
	
	@Column(name ="created_datetime")
	private Date createdDtm = new Date();
	
	@Column(name ="lastupdated_datetime")
	private Date lastUpdatedDtm = new Date();
	
}

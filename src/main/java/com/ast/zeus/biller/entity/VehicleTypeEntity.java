package com.ast.zeus.biller.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name="vehicle_type")
public class VehicleTypeEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name ="vehicle_type_id", unique = true, nullable = false)
	private Integer vehicleTypeId;
	
	@Column(name ="vehicle_type")
	private String vehicleTypeName;

	@Column(name="cost_per_basic_kms")
	private Double costPerBasicKms;
	
	@Column(name ="created_datetime")
	private LocalDateTime createdDtm;
	
	@Column(name ="lastupdated_datetime")
	private LocalDateTime lastUpdatedDtm;
	
	@OneToMany(mappedBy = "vehicleType", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<VehicleEntity> vehicles;
	
	@OneToMany(mappedBy = "vehicleTypeEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<VehicleExtraChargesEntity> vehicleExtraCharges;
}

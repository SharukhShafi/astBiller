package com.ast.zeus.biller.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

import javax.persistence.*;

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
@Table(name="vehicle")
public class VehicleEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name ="vehicle_id", unique = true, nullable = false)
	private Integer vehicleId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="vehicle_type_id", referencedColumnName = "vehicle_type_id")
	private VehicleTypeEntity vehicleType;
	
	@Column(name ="vehicle_number")
	private String vehicleNumber;
	
	@Column(name ="created_datetime")
	private LocalDateTime createdDtm;

	@Column(name ="color")
	private String color;
}

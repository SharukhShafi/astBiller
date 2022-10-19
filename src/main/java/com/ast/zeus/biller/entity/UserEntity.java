package com.ast.zeus.biller.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name="user")
public class UserEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name ="user_id", unique = true, nullable = false)
	private Integer userId;
	
	@Column(name ="name")
	private String userName;
	
	@Column(name ="password")
	private String password;
 
	@Column(name ="email")
	private String email;
	
	@Column(name ="created_datetime")
	private LocalDateTime createdDtm;
	
	@Column(name ="lastupdated_datetime")
	private LocalDateTime lastUpdatedDtm;

}

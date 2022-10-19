package com.ast.zeus.biller.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ast.zeus.biller.entity.VehicleEntity;

@Repository
public interface VehicleRepo extends JpaRepository<VehicleEntity,Integer> {

	VehicleEntity findByVehicleNumber(String vehicleNumber);

}

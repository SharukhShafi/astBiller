package com.ast.zeus.biller.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ast.zeus.biller.entity.VehicleTypeEntity;

@Repository
public interface VehicleTypeRepo extends JpaRepository<VehicleTypeEntity,Integer> {


	VehicleTypeEntity findByVehicleTypeName(String vehicleTypeName);
    
}

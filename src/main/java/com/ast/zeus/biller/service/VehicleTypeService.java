package com.ast.zeus.biller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ast.zeus.biller.entity.VehicleTypeEntity;
import com.ast.zeus.biller.exception.ASTBillerException;
import com.ast.zeus.biller.repo.VehicleTypeRepo;
import com.ast.zeus.biller.vo.VehicleTypeVO;

@Service
public class VehicleTypeService {
    @Autowired
    VehicleTypeRepo vehicleTypeRepo;

	public void addVehicleType(VehicleTypeVO vehicleTypeVO) throws ASTBillerException{
		if (null != vehicleTypeVO) {
			VehicleTypeEntity vehicleType = new VehicleTypeEntity();
			vehicleType.setVehicleTypeName(vehicleTypeVO.getVehicleType());
			vehicleType.setCostPerBasicKms(vehicleTypeVO.getCostPerBasicKms());
			vehicleTypeRepo.save(vehicleType);
		}
	}
}

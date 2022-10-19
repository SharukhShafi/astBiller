package com.ast.zeus.biller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ast.zeus.biller.entity.VehicleEntity;
import com.ast.zeus.biller.entity.VehicleTypeEntity;
import com.ast.zeus.biller.exception.ASTBillerException;
import com.ast.zeus.biller.repo.VehicleRepo;
import com.ast.zeus.biller.repo.VehicleTypeRepo;
import com.ast.zeus.biller.vo.VehicleTypeVO;
import com.ast.zeus.biller.vo.VehicleVO;

@Service
public class VehicleService {
    @Autowired
    VehicleRepo vehicleRepo;

    @Autowired
    VehicleTypeRepo vehicleTypeRepo;

    public void addVehicle(VehicleVO vehicleVO) throws ASTBillerException{
        if(null != vehicleVO){
            VehicleTypeVO vehicleTypeVO = vehicleVO.getVehicleTypeVO();
            VehicleTypeEntity vehicleType = vehicleTypeRepo.findByVehicleTypeName(vehicleTypeVO.getVehicleType());
            VehicleEntity vehicle = new VehicleEntity();
            vehicle.setVehicleType(vehicleType);
            vehicle.setVehicleNumber(vehicleVO.getVehicleNumber());
            vehicle.setColor(vehicleVO.getColor());
            vehicleRepo.save(vehicle);
        }
    }
}

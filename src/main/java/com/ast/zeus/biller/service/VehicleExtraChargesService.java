package com.ast.zeus.biller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ast.zeus.biller.entity.VehicleExtraChargesEntity;
import com.ast.zeus.biller.entity.VehicleTypeEntity;
import com.ast.zeus.biller.exception.ASTBillerException;
import com.ast.zeus.biller.repo.VehicleExtraChargesRepo;
import com.ast.zeus.biller.repo.VehicleTypeRepo;
import com.ast.zeus.biller.vo.VehicleExtraChargesVO;

@Service
public class VehicleExtraChargesService {
    @Autowired
    VehicleExtraChargesRepo vehicleExtraChargesDao;

    @Autowired
    VehicleTypeRepo vehicleTypeDao;

    public void addVehicleExtraCharges(VehicleExtraChargesVO vehicleExtraChargesVO) throws ASTBillerException{
        if(null != vehicleExtraChargesVO &&
            null != vehicleExtraChargesVO.getVehicleTypeVO()){
            VehicleExtraChargesEntity vehicleExtraCharges = new VehicleExtraChargesEntity();
            vehicleExtraCharges.setKmsCost(vehicleExtraChargesVO.getKmsCost());
            vehicleExtraCharges.setTimeCost(vehicleExtraChargesVO.getTimeCost());
            VehicleTypeEntity vehicleType = vehicleTypeDao.findByVehicleTypeName(vehicleExtraChargesVO.getVehicleTypeVO().getVehicleType());
            vehicleExtraCharges.setVehicleTypeEntity(vehicleType);
            vehicleExtraChargesDao.save(vehicleExtraCharges);
        }
    }
}

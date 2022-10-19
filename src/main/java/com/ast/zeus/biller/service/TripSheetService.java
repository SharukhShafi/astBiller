package com.ast.zeus.biller.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ast.zeus.biller.entity.CompanyEntity;
import com.ast.zeus.biller.entity.DriverEntity;
import com.ast.zeus.biller.entity.TripSheetEntity;
import com.ast.zeus.biller.entity.VehicleEntity;
import com.ast.zeus.biller.entity.VehicleExtraChargesEntity;
import com.ast.zeus.biller.exception.ASTBillerException;
import com.ast.zeus.biller.repo.CompanyRepo;
import com.ast.zeus.biller.repo.DriverRepo;
import com.ast.zeus.biller.repo.TripSheetRepo;
import com.ast.zeus.biller.repo.VehicleExtraChargesRepo;
import com.ast.zeus.biller.repo.VehicleRepo;
import com.ast.zeus.biller.repo.VehicleTypeRepo;
import com.ast.zeus.biller.util.CalculateUtil;
import com.ast.zeus.biller.vo.TripSheetVO;

@Service
public class TripSheetService {
    @Autowired
    VehicleRepo vehicleRepo;

    @Autowired
    VehicleTypeRepo vehicleTypeRepo;

    @Autowired
    VehicleExtraChargesRepo vehicleExtraChargesRepo;

    @Autowired
    CompanyRepo companyRepo;

    @Autowired
    DriverRepo driverRepo;

    @Autowired
    TripSheetRepo tripSheetRepo;

    public void addTripSheet(TripSheetVO tripSheetVO) throws ASTBillerException{
        CalculateUtil calculateUtil = new CalculateUtil();
        if(null != tripSheetVO){
            VehicleEntity vehicle = vehicleRepo.findByVehicleNumber(tripSheetVO.getVehicleVO().getVehicleNumber());
            Optional<DriverEntity> driver = driverRepo.findById(tripSheetVO.getDriver().getDriverID());
            Optional<CompanyEntity> company = companyRepo.findById(tripSheetVO.getCompany().getCompanyId());
            VehicleExtraChargesEntity vehicleExtraCharges = vehicleExtraChargesRepo.findVehicleExtraChargeByVehicleName(tripSheetVO.getVehicleVO().getVehicleNumber());
            TripSheetEntity tripSheet = new TripSheetEntity();
            if(company.isPresent()) {
                tripSheet.setCompany(company.get());
            }
            if(driver.isPresent()) {
                tripSheet.setDriver(driver.get());
            }
            tripSheet.setVehicle(vehicle);
            tripSheet.setStartTime(tripSheetVO.getStartDateTime().toLocalTime());
            tripSheet.setCloseTime(tripSheetVO.getCloseDateTime().toLocalTime());
            tripSheet.setFacilitatedStaff(tripSheetVO.getFacilitatedStaff());
            calculateUtil.populateAmount(tripSheetVO,vehicleExtraCharges);
            tripSheet.setExtraTime(tripSheetVO.getExtraTime());
            tripSheet.setStartKms(tripSheetVO.getStartKms());
            tripSheet.setCloseKms(tripSheetVO.getCloseKms());
            tripSheet.setTotalAmount(tripSheetVO.getTotalAmount());
            tripSheet.setParkingFee(tripSheetVO.getParkingFee());
            tripSheet.setTotalRunningHours(tripSheetVO.getTotalRunningHours());
            tripSheet.setTotalRunningKms(tripSheetVO.getTotalRunningKms());
            tripSheet.setExtraKms(tripSheetVO.getExtraKms());
            tripSheetRepo.save(tripSheet);
        }
    }
}

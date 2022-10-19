package com.ast.zeus.biller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ast.zeus.biller.entity.DriverEntity;
import com.ast.zeus.biller.exception.ASTBillerException;
import com.ast.zeus.biller.repo.DriverRepo;
import com.ast.zeus.biller.vo.DriverVO;

@Service
public class DriverService {

    @Autowired
    DriverRepo driverRepo;

    public void addDriver(DriverVO driverVO) throws ASTBillerException{
        if(null != driverVO){
            DriverEntity driver = new DriverEntity();
            driver.setDriverMobileNumber(driverVO.getDriverMobileNumber());
            driver.setDriverName(driverVO.getDriverName());
            driverRepo.save(driver);
        }
    }
}

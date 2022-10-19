package com.ast.zeus.biller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ast.zeus.biller.entity.CompanyEntity;
import com.ast.zeus.biller.exception.ASTBillerException;
import com.ast.zeus.biller.repo.CompanyRepo;
import com.ast.zeus.biller.vo.CompanyVO;


@Service
public class CompanyService {
    @Autowired
    CompanyRepo companyRepo;

    public void addCompany(CompanyVO companyVO) throws ASTBillerException{
        if(null != companyVO){
            CompanyEntity company = new CompanyEntity();
            company.setCompanyName(companyVO.getCompanyName());
            company.setAddress(companyVO.getAddress());
            companyRepo.save(company);
        }
    }
}

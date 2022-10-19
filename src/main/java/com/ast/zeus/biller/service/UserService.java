package com.ast.zeus.biller.service;

import java.time.LocalDateTime;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.ast.zeus.biller.entity.UserEntity;
import com.ast.zeus.biller.exception.ASTBillerException;
import com.ast.zeus.biller.repo.UserRepo;
import com.ast.zeus.biller.vo.UserVO;


@Service 
public class UserService {

    @Autowired
    private UserRepo userRepo;
    

    public UserEntity verifyUser(UserVO userVO) throws ASTBillerException{
        if(null != userVO
            && null != userVO.getUserName()) {
            return userRepo.findByUserName(userVO.getUserName());
        } else{
            return null;
        }
    }

    public boolean addUser(UserVO userVO) throws ASTBillerException{
        UserEntity user = new UserEntity();
        if(null != userVO) {
            user.setUserName(userVO.getUserName());
            user.setPassword(hashPassword(userVO.getPassword()));
            user.setCreatedDtm(LocalDateTime.now(ZoneId.of("Asia/Kolkata")));
            user.setLastUpdatedDtm(LocalDateTime.now(ZoneId.of("Asia/Kolkata")));
            userRepo.save(user);
            return true;
        } else {
            return false;
        }
    }
    
    private String hashPassword(String plainTextPassword) {
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    }
}

package com.ast.zeus.biller.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ast.zeus.biller.entity.UserEntity;

@Repository
public interface UserRepo extends JpaRepository<UserEntity,Integer> {
    UserEntity findByUserName(String userName);
}

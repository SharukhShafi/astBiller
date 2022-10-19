package com.ast.zeus.biller.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ast.zeus.biller.entity.DriverEntity;

@Repository
public interface DriverRepo extends JpaRepository<DriverEntity,Integer> {
}

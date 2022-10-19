package com.ast.zeus.biller.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ast.zeus.biller.entity.VehicleExtraChargesEntity;

@Repository
public interface VehicleExtraChargesRepo extends JpaRepository<VehicleExtraChargesEntity,Integer> {

	/*
	 * @Query(value = " select ve.*,vt.* from vehicle_extra_charges ve \n" +
	 * " inner join vehicle v on\n" + " v.vehicle_type_id = ve.vehicle_type_id\n" +
	 * " inner join vehicle_type vt on\n" +
	 * " vt.vehicle_type_id = v.vehicle_type_id\n" +
	 * " where v.vehicle_number =:vehicleNumber",nativeQuery = true)
	 * VehicleExtraCharges
	 * findVehicleExtraChargeByVehicleName(@Param("vehicleNumber")String
	 * vehicleNumber);
	 */
   
   @Query("SELECT ve FROM VehicleExtraChargesEntity ve "
   		+ "INNER JOIN FETCH ve.vehicleTypeEntity vt "
   		+ "INNER JOIN FETCH vt.vehicles v "
   		+ "where v.vehicleNumber = :vehicleNumber")
   VehicleExtraChargesEntity findVehicleExtraChargeByVehicleName(@Param("vehicleNumber")String vehicleNumber);

}

package com.ast.zeus.biller.util;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.ast.zeus.biller.constants.ApplicationContants;
import com.ast.zeus.biller.entity.VehicleExtraChargesEntity;
import com.ast.zeus.biller.vo.TripSheetVO;
public class CalculateUtil {

    public void  populateAmount(TripSheetVO tripSheetVO, VehicleExtraChargesEntity vehicleExtraCharges) {
        calculateRunningHours(tripSheetVO);
        calculateRunningkms(tripSheetVO);
        Map<String,Double> hourMap = calculateTotalAmountForHours(tripSheetVO,vehicleExtraCharges);
        double extraKmsAmount = calculateTotalAmountForkms(tripSheetVO,vehicleExtraCharges,hourMap);
        calculateFullTotal(tripSheetVO,vehicleExtraCharges,hourMap,extraKmsAmount);
    }

    public void calculateRunningHours(TripSheetVO tripSheetVO){
        if(null != tripSheetVO
            && null != tripSheetVO.getCloseDateTime()
            && null != tripSheetVO.getStartDateTime()) {
            LocalDateTime startTime = tripSheetVO.getStartDateTime();
            LocalDateTime endTime = tripSheetVO.getCloseDateTime();
            Duration duration = Duration.between(startTime, endTime);
            tripSheetVO.setTotalRunningHours(duration.toHours());
        }
    }

    public void calculateRunningkms(TripSheetVO tripSheetVO){
        if(null != tripSheetVO) {
            double totalKms = tripSheetVO.getCloseKms() - tripSheetVO.getStartKms();
            tripSheetVO.setTotalRunningKms(totalKms);
        }
    }

    public Map<String,Double> calculateTotalAmountForHours(TripSheetVO tripSheetVO, VehicleExtraChargesEntity vehicleExtraCharges){
        Map<String,Double> hourMap = new HashMap<>();
        double extraHourAmount = 0;
        if(null != tripSheetVO
            && null != vehicleExtraCharges
            && vehicleExtraCharges.getTimeCost() != 0
            && tripSheetVO.getTotalRunningHours() != 0) {
            double totalRunningHours = tripSheetVO.getTotalRunningHours();
            if (totalRunningHours < 5) {
                hourMap.put(ApplicationContants.QUOTIENT_STRING, 5d);
                hourMap.put(ApplicationContants.EXTRA_HOURS_AMOUNT, 0d);
                return hourMap;
            }
            double remainderHours = totalRunningHours % 5;
            double differenceHours = totalRunningHours - remainderHours;
            if (remainderHours >= 3) {
                totalRunningHours = differenceHours + 5;
            } else {
                extraHourAmount = remainderHours * vehicleExtraCharges.getTimeCost();
            }
            int quotient = (int) totalRunningHours / 5;
            hourMap.put(ApplicationContants.QUOTIENT_STRING, (double) quotient);
            hourMap.put(ApplicationContants.EXTRA_HOURS_AMOUNT, extraHourAmount);
            tripSheetVO.setExtraTime(remainderHours);
        }
        return hourMap;
    }

    public double calculateTotalAmountForkms(TripSheetVO tripSheetVO, VehicleExtraChargesEntity vehicleExtraCharges,Map<String,Double> hourMap){
        double extraKmAmount = 0;
        double extraKM =0;
        if(null != tripSheetVO
            && tripSheetVO.getTotalRunningKms() != 0
            && vehicleExtraCharges.getKmsCost() != 0) {
            double totalRunningKms = tripSheetVO.getTotalRunningKms();
            double quotient = hourMap.get(ApplicationContants.QUOTIENT_STRING);
            double limitKm =50*quotient;
                if(limitKm >  totalRunningKms){
                    tripSheetVO.setExtraKms(0);
                    return 0;
                } else {
                    extraKM = totalRunningKms - limitKm;
                }
            extraKmAmount = extraKM * vehicleExtraCharges.getKmsCost();
            tripSheetVO.setExtraKms(extraKM);
        }
        return extraKmAmount;
    }

    public void calculateFullTotal(TripSheetVO tripSheetVO, VehicleExtraChargesEntity vehicleExtraCharges, Map<String,Double> hourMap,double extraKmAmount){
        if(null != tripSheetVO
                && null != vehicleExtraCharges
                && null != vehicleExtraCharges.getVehicleTypeEntity()
                && null != vehicleExtraCharges.getVehicleTypeEntity().getCostPerBasicKms()
            && null != hourMap
            && null != hourMap.get(ApplicationContants.QUOTIENT_STRING)
            && null != hourMap.get(ApplicationContants.EXTRA_HOURS_AMOUNT)){
            double quotient = hourMap.get(ApplicationContants.QUOTIENT_STRING);
            double extraHourAmount = hourMap.get(ApplicationContants.EXTRA_HOURS_AMOUNT);
            double basicAmount = vehicleExtraCharges.getVehicleTypeEntity().getCostPerBasicKms();
            tripSheetVO.setTotalAmount((quotient*basicAmount)+extraHourAmount+extraKmAmount+tripSheetVO.getParkingFee());
        }
    }
}

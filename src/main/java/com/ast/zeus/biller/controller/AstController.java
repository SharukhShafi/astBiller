package com.ast.zeus.biller.controller;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ast.zeus.biller.constants.ApplicationContants;
import com.ast.zeus.biller.entity.UserEntity;
import com.ast.zeus.biller.exception.ASTBillerException;
import com.ast.zeus.biller.response.ASTBillerReponse;
import com.ast.zeus.biller.service.CompanyService;
import com.ast.zeus.biller.service.DriverService;
import com.ast.zeus.biller.service.TripSheetService;
import com.ast.zeus.biller.service.UserService;
import com.ast.zeus.biller.service.VehicleExtraChargesService;
import com.ast.zeus.biller.service.VehicleService;
import com.ast.zeus.biller.service.VehicleTypeService;
import com.ast.zeus.biller.vo.CompanyVO;
import com.ast.zeus.biller.vo.DriverVO;
import com.ast.zeus.biller.vo.TripSheetVO;
import com.ast.zeus.biller.vo.UserVO;
import com.ast.zeus.biller.vo.VehicleExtraChargesVO;
import com.ast.zeus.biller.vo.VehicleTypeVO;
import com.ast.zeus.biller.vo.VehicleVO;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/astbiller/api")
public class AstController {

	private static final Logger LOG = LoggerFactory.getLogger(AstController.class);

	@Autowired
	UserService userService;

	@Autowired
	VehicleTypeService vehicleTypeService;

	@Autowired
	CompanyService companyService;

	@Autowired
	VehicleService vehicleService;

	@Autowired
	VehicleExtraChargesService vehicleExtraChargesService;

	@Autowired
	TripSheetService tripSheetService;

	@Autowired
	DriverService driverService;

	@PostMapping(path = "/newUser")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK" , content = {@Content(mediaType = "application/json")})})
	public ResponseEntity<ASTBillerReponse> addUser(@RequestBody UserVO user) {
		ASTBillerReponse astBillerReponse = null;
		try {
			userService.addUser(user);
		} catch (ASTBillerException e) {
			LOG.error("Exception while adding user ", e);
			astBillerReponse = new ASTBillerReponse();
			astBillerReponse.setErrorCode("EX-101");
			astBillerReponse.setMessage(ApplicationContants.ERRORMESSAGE);
		}
		return new ResponseEntity<>(astBillerReponse, HttpStatus.OK);
	}

	// @PostMapping(path = "/verifyUser")
	// @ResponseBody
	public boolean verifyUser(@RequestBody UserVO userVO) {
		ASTBillerReponse astBillerReponse = null;
		LOG.info("verifying user");
		UserEntity user;
		try {
			user = userService.verifyUser(userVO);
			return null != user && StringUtils.equalsIgnoreCase(userVO.getUserName(), user.getUserName())
					&& StringUtils.equalsIgnoreCase(userVO.getPassword(), user.getPassword());
		} catch (ASTBillerException e) {
			LOG.error("Exception while adding user ", e);
			astBillerReponse = new ASTBillerReponse();
			astBillerReponse.setErrorCode("EX-102");
			astBillerReponse.setMessage(ApplicationContants.ERRORMESSAGE);
		}
		return false;
	}

	@PostMapping(path = "/addVehicleType")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK" , content = {@Content(mediaType = "application/json")})})
	public ResponseEntity<ASTBillerReponse> addVehicleType(@RequestBody VehicleTypeVO vehicleTypeVO) {
		ASTBillerReponse astBillerReponse = null;
		try {
			vehicleTypeService.addVehicleType(vehicleTypeVO);
		} catch (ASTBillerException e) {
			LOG.error("Exception while addVehicleType  ", e);
			astBillerReponse = new ASTBillerReponse();
			astBillerReponse.setErrorCode("EX-103");
			astBillerReponse.setMessage(ApplicationContants.ERRORMESSAGE);
		}
		return new ResponseEntity<>(astBillerReponse, HttpStatus.OK);
	}

	@PostMapping(path = "/addCompany")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK" , content = {@Content(mediaType = "application/json")})})
	public ResponseEntity<ASTBillerReponse> addCompany(@RequestBody CompanyVO companyVO) {
		ASTBillerReponse astBillerReponse = null;
		try {
			companyService.addCompany(companyVO);
		} catch (ASTBillerException e) {
			LOG.error("Exception while addCompany  ", e);
			astBillerReponse = new ASTBillerReponse();
			astBillerReponse.setErrorCode("EX-104");
			astBillerReponse.setMessage(ApplicationContants.ERRORMESSAGE);
		}
		return new ResponseEntity<>(astBillerReponse, HttpStatus.OK);
	}

	@PostMapping(path = "/addDriver")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK" , content = {@Content(mediaType = "application/json")})})
	public ResponseEntity<ASTBillerReponse> addDriver(@RequestBody DriverVO driverVO) {
		ASTBillerReponse astBillerReponse = null;
		try {
			driverService.addDriver(driverVO);
		} catch (ASTBillerException e) {
			LOG.error("Exception while addDriver  ", e);
			astBillerReponse = new ASTBillerReponse();
			astBillerReponse.setErrorCode("EX-105");
			astBillerReponse.setMessage(ApplicationContants.ERRORMESSAGE);
		}
		return new ResponseEntity<>(astBillerReponse, HttpStatus.OK);
	}

	@PostMapping(path = "/addVehicle")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK" , content = {@Content(mediaType = "application/json")})})
	public ResponseEntity<ASTBillerReponse> addVehicle(@RequestBody VehicleVO vehicleVO) {
		ASTBillerReponse astBillerReponse = null;
		try {
			vehicleService.addVehicle(vehicleVO);
		} catch (ASTBillerException e) {
			LOG.error("Exception while addVehicle  ", e);
			astBillerReponse = new ASTBillerReponse();
			astBillerReponse.setErrorCode("EX-106");
			astBillerReponse.setMessage(ApplicationContants.ERRORMESSAGE);
		}
		return new ResponseEntity<>(astBillerReponse, HttpStatus.OK);
	}

	@PostMapping(path = "/addExtraCosts")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK" , content = {@Content(mediaType = "application/json")})})
	public ResponseEntity<ASTBillerReponse> addExtraCosts(@RequestBody VehicleExtraChargesVO vehicleVO) {
		ASTBillerReponse astBillerReponse = null;
		try {
			vehicleExtraChargesService.addVehicleExtraCharges(vehicleVO);
		} catch (ASTBillerException e) {
			LOG.error("Exception while addExtraCosts  ", e);
			astBillerReponse = new ASTBillerReponse();
			astBillerReponse.setErrorCode("EX-107");
			astBillerReponse.setMessage(ApplicationContants.ERRORMESSAGE);
		}
		return new ResponseEntity<>(astBillerReponse, HttpStatus.OK);
	}

	@PostMapping(path = "/addTripSheet")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK" , content = {@Content(mediaType = "application/json")})})
	public ResponseEntity<ASTBillerReponse> addTripSheet(@RequestBody TripSheetVO tripSheetVO) {
		ASTBillerReponse astBillerReponse = null;
		try {
			tripSheetService.addTripSheet(tripSheetVO);
		} catch (ASTBillerException e) {
			LOG.error("Exception while addTripSheet  ", e);
			astBillerReponse = new ASTBillerReponse();
			astBillerReponse.setErrorCode("EX-108");
			astBillerReponse.setMessage(ApplicationContants.ERRORMESSAGE);
		}
		return new ResponseEntity<>(astBillerReponse, HttpStatus.OK);
	}
}

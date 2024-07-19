package com.farm.collector.controller;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.farm.collector.model.PlantedDTO;
import com.farm.collector.service.PlantedService;

import lombok.RequiredArgsConstructor;


@CrossOrigin
@RestController
@RequiredArgsConstructor
@Api(value = "/planted/", description = "Planted API", produces = "application/json")
@RequestMapping("/planted")
public class PlantedController {

	private final PlantedService plantedService;

	@GetMapping(value = "/{farmName}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(
			value = "Service returns planted details",
			notes = "This service returns all crops and expected product details",
			response = PlantedDTO.class,
			httpMethod = "GET"
	)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved planted details"),
			@ApiResponse(code = 416, message = "List is empty") })
	public ResponseEntity<List<PlantedDTO>> plantedDetails(
			@PathVariable String farmName) {
		return new ResponseEntity<>(plantedService.plantedDetails(farmName),
				HttpStatus.OK);
	}

}

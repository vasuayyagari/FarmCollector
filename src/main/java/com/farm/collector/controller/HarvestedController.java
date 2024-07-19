package com.farm.collector.controller;

import com.farm.collector.model.HarvestedDTO;
import com.farm.collector.model.PlantedDTO;
import com.farm.collector.service.HarvestedService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@Api(value = "/harvested/", description = "Harvested API", produces = "application/json")
@RequestMapping("/harvested")
public class HarvestedController {

	private final HarvestedService harvestedService;

	@GetMapping(value = "/{farmName}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(
			value = "Service returns harvested details",
			notes = "This service returns all crops and harvested product details",
			response = PlantedDTO.class,
			httpMethod = "GET"
	)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved planted details"),
			@ApiResponse(code = 416, message = "List is empty") })
	public ResponseEntity<List<HarvestedDTO>> harvestedDetails(@PathVariable String farmName) {
		return new ResponseEntity<>(harvestedService.harvestedDetails(farmName), HttpStatus.OK);
	}

}

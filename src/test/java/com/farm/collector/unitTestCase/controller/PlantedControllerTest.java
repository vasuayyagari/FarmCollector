package com.farm.collector.unitTestCase.controller;

import com.farm.collector.controller.PlantedController;
import com.farm.collector.model.PlantedDTO;
import com.farm.collector.service.PlantedService;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class PlantedControllerTest {

	@Mock
	private PlantedService plantedService;

	@InjectMocks
	private PlantedController plantedController;

	@Test
	@Tag("Planted Details -Success")
	public void get_planted_details_withSuccess() {
		//Arrange
		PlantedDTO plantedDTO1 = Mockito.mock(PlantedDTO.class);
		when(plantedDTO1.getExpectedProduct()).thenReturn(134.5);
		when(plantedDTO1.getCropName()).thenReturn("corn");

		PlantedDTO plantedDTO2 = Mockito.mock(PlantedDTO.class);
		when(plantedDTO2.getExpectedProduct()).thenReturn(67.0);
		when(plantedDTO2.getCropName()).thenReturn("apple");

		List<PlantedDTO> plantedDTOS = new ArrayList<>();
		plantedDTOS.add(plantedDTO1);
		plantedDTOS.add(plantedDTO2);

		when(plantedService.plantedDetails("testfarm")).thenReturn(plantedDTOS);

		//Act

		ResponseEntity<List<PlantedDTO>> plantedResponeEntity = plantedController.plantedDetails("testfarm");

		//Assert
		assertEquals(plantedResponeEntity.getStatusCode(), HttpStatus.OK);
		assertEquals(plantedResponeEntity.getBody().get(0).getCropName(), plantedDTOS.get(0).getCropName());
		assertEquals(plantedResponeEntity.getBody().get(0).getExpectedProduct(), plantedDTOS.get(0).getExpectedProduct());

		assertEquals(plantedResponeEntity.getBody().get(1).getCropName(), plantedDTOS.get(1).getCropName());
		assertEquals(plantedResponeEntity.getBody().get(1).getExpectedProduct(), plantedDTOS.get(1).getExpectedProduct());
	}

}

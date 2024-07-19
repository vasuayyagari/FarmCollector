package com.farm.collector.unitTestCase.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.farm.collector.controller.HarvestedController;
import com.farm.collector.model.HarvestedDTO;
import com.farm.collector.service.HarvestedService;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@ExtendWith(MockitoExtension.class)
public class HarvestedControllerTest {

	@Mock
	private HarvestedService harvestedService;

	@InjectMocks
	private HarvestedController harvestedController;

	@Test
	@Tag("Harvested Details -Success")
	public void get_harvested_details_withSuccess() {
		//Arrange
		HarvestedDTO harvestedDTO1 = Mockito.mock(HarvestedDTO.class);
		when(harvestedDTO1.getHarvestedProduct()).thenReturn(134.5);
		when(harvestedDTO1.getCropName()).thenReturn("corn");

		HarvestedDTO harvestedDTO2 = Mockito.mock(HarvestedDTO.class);
		when(harvestedDTO2.getHarvestedProduct()).thenReturn(67.0);
		when(harvestedDTO2.getCropName()).thenReturn("apple");

		List<HarvestedDTO> harvestedDTOS = new ArrayList<>();
		harvestedDTOS.add(harvestedDTO1);
		harvestedDTOS.add(harvestedDTO2);

		when(harvestedService.harvestedDetails("testfarm")).thenReturn(harvestedDTOS);

		//Act

		ResponseEntity<List<HarvestedDTO>> harvestedListResponseEntity = harvestedController.harvestedDetails("testfarm");

		//Assert
		assertEquals(harvestedListResponseEntity.getStatusCode(), HttpStatus.OK);
		assertEquals(harvestedListResponseEntity.getBody().get(0).getCropName(), harvestedDTOS.get(0).getCropName());
		assertEquals(harvestedListResponseEntity.getBody().get(0).getHarvestedProduct(), harvestedDTOS.get(0).getHarvestedProduct());

		assertEquals(harvestedListResponseEntity.getBody().get(1).getCropName(), harvestedDTOS.get(1).getCropName());
		assertEquals(harvestedListResponseEntity.getBody().get(1).getHarvestedProduct(), harvestedDTOS.get(1).getHarvestedProduct());
	}

}

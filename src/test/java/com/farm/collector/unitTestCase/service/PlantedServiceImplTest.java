package com.farm.collector.unitTestCase.service;

import com.farm.collector.entity.Planted;
import com.farm.collector.model.PlantedDTO;
import com.farm.collector.repository.PlantedRepository;
import com.farm.collector.service.PlantedService;
import com.farm.collector.service.PlantedServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class PlantedServiceImplTest {

	@Mock
	private PlantedRepository plantedRepository;

	@InjectMocks
	private PlantedServiceImpl plantedService;

	@Test
	@DisplayName("Planted Details -Success")
	public void get_planted_details_withSuccess() {
		//Arrange
		Planted planted1 = Mockito.mock(Planted.class);
		when(planted1.getExpectedProduct()).thenReturn(134.5);
		when(planted1.getCropName()).thenReturn("corn");

		Planted planted2 = Mockito.mock(Planted.class);
		when(planted2.getExpectedProduct()).thenReturn(67.0);
		when(planted2.getCropName()).thenReturn("apple");

		List<Planted> plantedList = new ArrayList<>();
		plantedList.add(planted1);
		plantedList.add(planted2);

		when(plantedRepository.getPlantedDetails("testfarm")).thenReturn(plantedList);

		//Act
		List<PlantedDTO> plantedDTOList = plantedService.plantedDetails("testfarm");

		//Assert
        assertTrue(plantedList.get(0).getExpectedProduct().equals(plantedDTOList.get(0).getExpectedProduct()));
		assertTrue(plantedList.get(0).getCropName().equals(plantedDTOList.get(0).getCropName()));
	}

}

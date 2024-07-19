package com.farm.collector.unitTestCase.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.farm.collector.entity.Harvested;
import com.farm.collector.model.HarvestedDTO;
import com.farm.collector.repository.HarvestedRepository;
import com.farm.collector.service.HarvestedServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class HarvestedServiceImplTest {

	@Mock
	private HarvestedRepository harvestedRepository;

	@InjectMocks
	private HarvestedServiceImpl harvestedService;

	@Test
	@DisplayName("Harvested Details -Success")
	public void get_harvested_details_withSuccess() {
		//Arrange
		Harvested harvested1 = Mockito.mock(Harvested.class);
		when(harvested1.getHarvestedProduct()).thenReturn(134.5);
		when(harvested1.getCropName()).thenReturn("corn");

		Harvested harvested2 = Mockito.mock(Harvested.class);
		when(harvested2.getHarvestedProduct()).thenReturn(67.0);
		when(harvested2.getCropName()).thenReturn("apple");

		List<Harvested> harvestedList = new ArrayList<>();
		harvestedList.add(harvested1);
		harvestedList.add(harvested2);

		when(harvestedRepository.getHarvestedDetails("testfarm")).thenReturn(harvestedList);

		//Act
		List<HarvestedDTO> harvestedDtosList = harvestedService.harvestedDetails("testfarm");

		//Assert
        assertTrue(harvestedList.get(0).getHarvestedProduct().equals(harvestedDtosList.get(0).getHarvestedProduct()));
		assertTrue(harvestedList.get(0).getCropName().equals(harvestedDtosList.get(0).getCropName()));
	}

}

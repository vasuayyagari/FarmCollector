package com.farm.collector.service;

import java.util.List;
import java.util.stream.Collectors;

import com.farm.collector.entity.Planted;
import com.farm.collector.exception.PlantedException;
import com.farm.collector.repository.PlantedRepository;
import com.farm.collector.utility.ApplicationResources;
import org.springframework.stereotype.Service;

import com.farm.collector.model.PlantedDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlantedServiceImpl implements PlantedService {

	private final PlantedRepository plantedRepository;

	/**
	 * A method to create a planted details with the given farmName
	 * @Param farmName
	 * @return List<PlantedDTO>
	 */
	public List<PlantedDTO> plantedDetails(String farmName) {

		if(farmName.isEmpty() || farmName.isBlank()) {
			throw new PlantedException(ApplicationResources.EMPTY_FARM_NAME);
		}

		List<Planted> plantedList = plantedRepository.getPlantedDetails(farmName);

		return plantedList.stream()
				.map(planted ->
						PlantedDTO.builder()
						 .plantingArea(planted.getPlantingArea())
                         .expectedProduct(planted.getExpectedProduct())
						 .cropName(planted.getCropName())
								.farmName(planted.getFarmName()).build())
				.collect(Collectors.toList());
	}

}

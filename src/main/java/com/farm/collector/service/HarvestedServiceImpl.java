package com.farm.collector.service;

import com.farm.collector.entity.Harvested;
import com.farm.collector.exception.PlantedException;
import com.farm.collector.model.HarvestedDTO;
import com.farm.collector.repository.HarvestedRepository;
import com.farm.collector.utility.ApplicationResources;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HarvestedServiceImpl implements HarvestedService {

	private final HarvestedRepository harvestedRepository;

	/**
	 * A method to create a harvested details with the given farmName
	 * @Param farmName
	 * @return List<HarvestedDTO>
	 */
	public List<HarvestedDTO> harvestedDetails(String farmName) {

		if(farmName.isEmpty() || farmName.isBlank()) {
			throw new PlantedException(ApplicationResources.EMPTY_FARM_NAME);
		}

		List<Harvested> harvestedList = harvestedRepository.getHarvestedDetails(farmName);

		return harvestedList.stream()
				.map(planted ->
						HarvestedDTO.builder()
						  .harvestedProduct(planted.getHarvestedProduct())
						 .cropName(planted.getCropName())
								.farmName(planted.getFarmName()).build())
				.collect(Collectors.toList());
	}

}

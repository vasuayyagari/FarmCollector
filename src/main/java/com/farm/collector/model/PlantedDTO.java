package com.farm.collector.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlantedDTO {

	private Double plantingArea;
	private Double expectedProduct;
	private String cropName;
	private String farmName;

}

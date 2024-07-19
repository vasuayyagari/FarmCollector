package com.farm.collector.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HarvestedDTO {

	private Double harvestedProduct;
	private String cropName;
	private String farmName;

}

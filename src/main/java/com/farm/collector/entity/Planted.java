package com.farm.collector.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "PLANTED")
public class Planted {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;

	@Column(name="PLANTING_AREA")
	private Double plantingArea;

	@Column(name="EXPECTED_PRODUCT")
	private Double expectedProduct;

	@Column(name="CROP_NAME")
	private String cropName;

	@Column(name="FARM_NAME")
	private String farmName;
}

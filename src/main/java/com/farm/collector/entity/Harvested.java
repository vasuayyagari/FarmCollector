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
@Table(name = "HARVESTED")
public class Harvested {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;

	@Column(name="HARVESTED_PRODUCT")
	private Double harvestedProduct;

	@Column(name="CROP_NAME")
	private String cropName;

	@Column(name="FARM_NAME")
	private String farmName;
}

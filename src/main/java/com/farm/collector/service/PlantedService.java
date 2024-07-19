package com.farm.collector.service;

import com.farm.collector.model.PlantedDTO;

import java.util.List;

/**
 *
 This Interface contains the method to get details of the planted corp list.
 **/
public interface PlantedService {

    /**
     * A method to get planted corp information
     * @Param plantedDTO
     * @return List<PlantedDTO></PlantedDTO>
     */
    public List<PlantedDTO> plantedDetails(String farmName);

}

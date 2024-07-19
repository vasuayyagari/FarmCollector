package com.farm.collector.service;

import com.farm.collector.model.HarvestedDTO;

import java.util.List;

/**
 *
 This Interface contains the method to get details of the harvested crop list.
 **/
public interface HarvestedService {

    /**
     * A method to get harvested crop information
     * @Param farmName
     * @return List<HarvestedDTO>
     */
    public List<HarvestedDTO> harvestedDetails(String farmName);

}

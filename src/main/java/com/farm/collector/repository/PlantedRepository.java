package com.farm.collector.repository;

import com.farm.collector.entity.Planted;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlantedRepository extends JpaRepository<Planted, Long> {

    @Query(value= "SELECT ID,  FARM_NAME, CROP_NAME, PLANTING_AREA, EXPECTED_PRODUCT from Planted where FARM_NAME=:farmName", nativeQuery = true)
    List<Planted> getPlantedDetails(@Param("farmName") String farmName);
}


package com.farm.collector.repository;

import com.farm.collector.entity.Harvested;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HarvestedRepository extends JpaRepository<Harvested, Long> {

    @Query(value="SELECT ID, FARM_NAME, CROP_NAME, HARVESTED_PRODUCT from Harvested where FARM_NAME=:farmName", nativeQuery = true)
    List<Harvested> getHarvestedDetails(@Param("farmName") String farmName);
}

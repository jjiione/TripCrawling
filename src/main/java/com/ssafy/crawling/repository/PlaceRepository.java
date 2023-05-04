package com.ssafy.crawling.repository;

import com.ssafy.crawling.Entity.PlaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface PlaceRepository extends JpaRepository<PlaceEntity, Integer> {


}

package com.ssafy.crawling.reposiroty;

import com.ssafy.crawling.entity.PlaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface PlaceRepository extends JpaRepository<PlaceEntity, Integer> {

}

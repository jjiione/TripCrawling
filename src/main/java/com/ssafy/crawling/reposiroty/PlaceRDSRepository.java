package com.ssafy.crawling.reposiroty;

import com.ssafy.crawling.entity.PlaceRDSEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRDSRepository extends JpaRepository<PlaceRDSEntity, Integer> {
}

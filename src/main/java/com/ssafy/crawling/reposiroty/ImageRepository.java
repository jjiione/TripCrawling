package com.ssafy.crawling.reposiroty;

import com.ssafy.crawling.entity.PlaceImagesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<PlaceImagesEntity, Integer> {

}

package com.ssafy.crawling.reposiroty.placedetail;

import com.ssafy.crawling.entity.placedetail.AttractionContentType12Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentType12Repository extends JpaRepository<AttractionContentType12Entity, Integer> {
}

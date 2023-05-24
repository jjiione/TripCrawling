package com.ssafy.crawling.reposiroty.placedetail;

import com.ssafy.crawling.entity.placedetail.AccomodationContentType32Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentType32Repository extends JpaRepository<AccomodationContentType32Entity, Integer> {
}

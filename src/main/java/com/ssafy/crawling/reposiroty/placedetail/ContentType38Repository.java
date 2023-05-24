package com.ssafy.crawling.reposiroty.placedetail;

import com.ssafy.crawling.entity.placedetail.ShoppingContentType38Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;

@Repository
public interface ContentType38Repository extends JpaRepository<ShoppingContentType38Entity, Integer> {
}

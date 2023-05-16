package com.ssafy.crawling.reposiroty;

import com.ssafy.crawling.entity.Cat3Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Cat3Repository extends JpaRepository<Cat3Entity, String> {
}

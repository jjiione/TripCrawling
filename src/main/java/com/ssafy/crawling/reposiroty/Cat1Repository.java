package com.ssafy.crawling.reposiroty;

import com.ssafy.crawling.entity.Cat1Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Cat1Repository extends JpaRepository<Cat1Entity, String> {

}

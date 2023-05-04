package com.ssafy.crawling.reposiroty;

import com.ssafy.crawling.entity.CatDto;
import com.ssafy.crawling.entity.CatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatRepository extends JpaRepository<CatEntity, String> {

}

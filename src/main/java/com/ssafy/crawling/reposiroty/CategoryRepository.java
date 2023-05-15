package com.ssafy.crawling.reposiroty;

import com.ssafy.crawling.entity.CategoriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoriesEntity, String> {
}

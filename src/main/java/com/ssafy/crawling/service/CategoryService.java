package com.ssafy.crawling.service;

import com.ssafy.crawling.entity.CategoriesEntity;
import com.ssafy.crawling.reposiroty.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void insertCat(CategoriesEntity entity){
        categoryRepository.save(entity);

    }
}

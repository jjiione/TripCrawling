package com.ssafy.crawling.entity;

import com.ssafy.crawling.dto.OpenApiDto;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="categories")
@Getter
public class CategoriesEntity {
    @Id
    private String categoryId;
    private String categoryName;

    public void postCat(OpenApiDto openApiDto){
        this.categoryId = openApiDto.getCode();
        this.categoryName = openApiDto.getName();
    }

}

package com.ssafy.crawling.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="categories")
@Getter
public class CategoriesEntity {
    @Id
    private String categoryId;
    private String CategoryName;

}

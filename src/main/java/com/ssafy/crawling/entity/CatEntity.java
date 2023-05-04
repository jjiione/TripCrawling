package com.ssafy.crawling.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "cat_view")
@Getter
public class CatEntity {
    @Id
    private String cat3;
}

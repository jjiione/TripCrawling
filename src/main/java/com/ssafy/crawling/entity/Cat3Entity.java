package com.ssafy.crawling.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "cat_view")
@Getter
public class Cat3Entity {
    @Id
    private String cat3;
}

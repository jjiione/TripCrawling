package com.ssafy.crawling.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "cat_view1")
@Getter
public class Cat1Entity {
    @Id
    private String cat1;
}

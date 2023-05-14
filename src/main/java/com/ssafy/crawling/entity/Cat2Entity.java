package com.ssafy.crawling.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "cat2_view")
@Getter
public class Cat2Entity {
    @Id
    private String cat2;
}
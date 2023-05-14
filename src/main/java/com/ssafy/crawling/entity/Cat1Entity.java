package com.ssafy.crawling.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "cat1_view")
@Getter
public class Cat1Entity {
    @Id
    private String cat1;
}

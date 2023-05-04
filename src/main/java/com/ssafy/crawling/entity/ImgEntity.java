package com.ssafy.crawling.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class ImgEntity {
    @Id
    private String id;

}

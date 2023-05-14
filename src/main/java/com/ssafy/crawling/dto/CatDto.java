package com.ssafy.crawling.dto;

import com.ssafy.crawling.entity.Cat3Entity;
import lombok.Data;

@Data
public class CatDto {
    private String code;
    private String name;

    public CatDto(Cat3Entity cat3Entity) {
        this.code = cat3Entity.getCat3();
    }
}

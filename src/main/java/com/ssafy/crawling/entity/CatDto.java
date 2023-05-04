package com.ssafy.crawling.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class CatDto {
    private String code;
    private String name;

    public CatDto(CatEntity catEntity) {
        this.code = catEntity.getCat3();
    }
}

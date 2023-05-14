package com.ssafy.crawling.dto;

import com.ssafy.crawling.entity.PlaceEntity;
import lombok.Getter;

@Getter
public class PlaceDto {
    private int contentId;

    private int sidoCode;

    private int gugunCode;

    private String title;

    private int placeType;

    public PlaceDto(PlaceEntity place) {
        this.contentId = place.getContentId();
        this.sidoCode = place.getSidoCode();
        this.gugunCode = place.getGugunCode();
        this.title = place.getTitle();
        this.placeType = 12;
    }
}

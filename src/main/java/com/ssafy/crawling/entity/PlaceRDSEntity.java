package com.ssafy.crawling.entity;

import javax.persistence.*;

@Entity(name="places")
public class PlaceRDSEntity {
    @Id
    @Column(name = "place_id")
    private int placeId;

    @Column(name="sido_code")
    private int sidoCode;

    @Column(name="gugun_code")
    private int gugunCode;

    private String title;

    private int placeType;

    public void post(PlaceDto placeDto){
        this.placeId = placeDto.getContentId();
        this.sidoCode = placeDto.getSidoCode();
        this.gugunCode = placeDto.getGugunCode();
        this.title = placeDto.getTitle();
        this.placeType = placeDto.getPlaceType();
    }

}

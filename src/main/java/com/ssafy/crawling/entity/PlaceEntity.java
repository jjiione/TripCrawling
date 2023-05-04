package com.ssafy.crawling.entity;


import lombok.Getter;

import javax.persistence.*;


@Entity(name="attraction_info")
@Getter
public class PlaceEntity {
    @Id
    @Column(name="content_id")
    private int contentId;
    @Column(name="content_type_id")
    private int contentTypeId;
    private String title;
    private String addr1;
    private String addr2;
    private String zipcode;
    private String tel;
    @Column(name="first_image")
    private String firstImage;
    @Column(name="first_image2")
    private String firstImage2;
    private int readcount;
    @Column(name="sido_code")
    private int sidoCode;
    @Column(name="gugun_code")
    private int gugunCode;
    private long latitude;
    private long longitude;
    private String mlevel;


}

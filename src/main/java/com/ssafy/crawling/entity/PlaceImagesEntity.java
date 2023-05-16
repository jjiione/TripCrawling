package com.ssafy.crawling.entity;

import com.ssafy.crawling.dto.ImageDto;
import lombok.Getter;

import javax.persistence.*;

@Entity(name = "place_images")
@Getter
public class PlaceImagesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int imageId;

    private int contentId;

    private String mainImg;

    private String imgSrc;

    private String imgName;

    public void postImg(ImageDto imageDto){
        this.contentId = imageDto.getContentId();
        this.mainImg = imageDto.getMainImg();
        this.imgSrc = imageDto.getImgSrc();
        this.imgName = imageDto.getImgName();
    }

}

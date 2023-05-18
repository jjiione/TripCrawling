package com.ssafy.crawling.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "place_content_id_type")
@Getter
public class PlaceContentIdType {
    @Id
    private int contentId;

    private int contentTypeId;
}

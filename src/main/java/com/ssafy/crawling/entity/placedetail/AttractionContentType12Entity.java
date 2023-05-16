package com.ssafy.crawling.entity.placedetail;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "attraction_detail_content_type_12")
public class AttractionContentType12Entity {
    @Id
    String contentid;
    String contenttypeid;
    String heritage1;
    String heritage2;
    String heritage3;
    String infocenter;
    String opendate;
    String restdate;
    String expguide;
    String expagerange;
    String accomcount;
    String useseason;
    String usetime;
    String parking;
    String chkbabycarriage;
    String chkpet;
    String chkcreditcard;
}

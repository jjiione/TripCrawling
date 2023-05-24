package com.ssafy.crawling.entity.placedetail;

import com.ssafy.crawling.dto.placedetail.ContentType12_AttractionDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.criteria.CriteriaBuilder;


@Entity(name = "attraction_detail_content_type_12")
public class AttractionContentType12Entity {
    @Id
    int contentid;
    int contenttypeid;
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


    public void post(ContentType12_AttractionDto dto){
        this.contentid = Integer.parseInt(dto.getContentid());
        this.contenttypeid = Integer.parseInt(dto.getContenttypeid());
        this.heritage1 = dto.getHeritage1();
        this.heritage2 = dto.getHeritage2();
        this.heritage3 = dto.getHeritage3();
        this.infocenter = dto.getInfocenter();
        this.opendate = dto.getOpendate();
        this.restdate = dto.getRestdate();
        this.expguide = dto.getExpguide();
        this.expagerange = dto.getExpagerange();
        this.accomcount = dto.getAccomcount();
        this.useseason = dto.getUseseason();
        this.usetime = dto.getUsetime();
        this.parking = dto.getParking();
        this.chkbabycarriage = dto.getChkbabycarriage();
        this.chkpet = dto.getChkpet();
        this.chkcreditcard = dto.getChkcreditcard();
    }
}

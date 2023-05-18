package com.ssafy.crawling.entity.placedetail;

import com.ssafy.crawling.dto.placedetail.ContentType39_RestaurantDto;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "restaurant_detail_content_type_39")
@Getter
public class RestaurantContentType39Entity {
    @Id
    int contentid;
    int contenttypeid;
    String seat;
    String kidsfacility;
    String firstmenu;
    String treatmenu;
    String smoking;
    String packing;
    String infocenterfood;
    String scalefood;
    String parkingfood;
    String opendatefood;
    String opentimefood;
    String restdatefood;
    String discountinfofood;
    String chkcreditcardfood;
    String reservationfood;
    String lcnsno;

    public void post(ContentType39_RestaurantDto dto){
        this.contentid = Integer.parseInt(dto.getContentid());
        this.contenttypeid = Integer.parseInt(dto.getContenttypeid());
        this.seat = dto.getSeat();
        this.kidsfacility = dto.getKidsfacility();
        this.firstmenu = dto.getFirstmenu();
        this.treatmenu = dto.getTreatmenu();
        this.smoking = dto.getSmoking();
        this.packing = dto.getPacking();
        this.infocenterfood = dto.getInfocenterfood();
        this.scalefood = dto.getScalefood();
        this.parkingfood = dto.getParkingfood();
        this.opendatefood = dto.getOpendatefood();
        this.opentimefood = dto.getOpentimefood();
        this.restdatefood = dto.getRestdatefood();
        this.discountinfofood = dto.getDiscountinfofood();
        this.chkcreditcardfood = dto.getChkcreditcardfood();
        this.reservationfood = dto.getReservationfood();
        this.lcnsno = dto.getLcnsno();
    }
}

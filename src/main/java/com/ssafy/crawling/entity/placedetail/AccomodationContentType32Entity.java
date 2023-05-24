

package com.ssafy.crawling.entity.placedetail;


import com.ssafy.crawling.dto.placedetail.ContentType14_CultureInfraDto;
import com.ssafy.crawling.dto.placedetail.ContentType32_AccomodationDto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "accomodation_detail_content_type_32")
public class AccomodationContentType32Entity {
    @Id
    int contentid;
    int contenttypeid;
    String goodstay;
    String benikia;
    String hanok;
    String roomcount;
    String roomtype;
    String refundregulation;
    String checkintime;
    String checkouttime;
    String chkcooking;
    String seminar;
    String sports;
    String sauna;
    String beauty;
    String beverage;
    String karaoke;
    String barbecue;
    String campfire;
    String bicycle;
    String fitness;
    String publicpc;
    String publicbath;
    String subfacility;
    String foodplace;
    String reservationurl;
    String pickup;
    String infocenterlodging;
    String parkinglodging;
    String reservationlodging;
    String scalelodging;
    String accomcountlodging;

    public void post(ContentType32_AccomodationDto dto) {
        this.contentid = Integer.parseInt(dto.getContentid());
        this.contenttypeid = Integer.parseInt(dto.getContenttypeid());
        this.goodstay = dto.getGoodstay();
        this.benikia =  dto.getBenikia();
        this.hanok =  dto.getHanok();
        this.roomcount =  dto.getRoomcount();
        this.roomtype =  dto.getRoomtype();
        this.refundregulation =  dto.getRefundregulation();
        this.checkintime =  dto.getCheckintime();
        this.checkouttime =  dto.getCheckouttime();
        this.chkcooking =  dto.getChkcooking();
        this.seminar =  dto.getSeminar();
        this.sports =  dto.getSports();
        this.sauna =  dto.getSauna();
        this.beauty =  dto.getBeauty();
        this.karaoke =  dto.getKaraoke();
        this.barbecue =  dto.getBarbecue();
        this.campfire =  dto.getCampfire();
        this.bicycle =  dto.getBicycle();
        this.fitness =  dto.getFitness();
        this.publicpc =  dto.getPublicpc();
        this.publicbath =  dto.getPublicbath();
        this.subfacility =  dto.getSubfacility();
        this.foodplace =  dto.getFoodplace();
        this.reservationurl =  dto.getReservationurl();
        this.pickup =  dto.getPickup();
        this.infocenterlodging =  dto.getInfocenterlodging();
        this.parkinglodging =  dto.getParkinglodging();
        this.reservationlodging =  dto.getReservationlodging();
        this.scalelodging =  dto.getScalelodging();
        this.accomcountlodging =  dto.getAccomcountlodging();
    }
}


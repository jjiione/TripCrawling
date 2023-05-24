package com.ssafy.crawling.entity.placedetail;

import com.ssafy.crawling.dto.placedetail.ContentType14_CultureInfraDto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "attraction_detail_content_type_14")
public class CultureInfraContentType14Entity {
    @Id
    int contentid;
    int contenttypeid;
    String scale;
    String usefee;
    String discountinfo;
    String spendtime;
    String parkingfee;
    String infocenterculture;
    String accomcountculture;
    String usetimeculture;
    String restdateculture;
    String parkingculture;
    String chkbabycarriageculture;
    String chkpetculture;
    String chkcreditcardculture;

    public void post(ContentType14_CultureInfraDto dto){
        this.contentid = Integer.parseInt(dto.getContentid());
        this.contenttypeid = Integer.parseInt(dto.getContenttypeid());
        this.scale = dto.getScale();
        this.usefee = dto.getUsefee();
        this.discountinfo =  dto.getDiscountinfo();
        this.spendtime =  dto.getScale();
        this.parkingfee =  dto.getSpendtime();
        this.infocenterculture =  dto.getInfocenterculture();
        this.accomcountculture =  dto.getAccomcountculture();
        this.usetimeculture =  dto.getUsetimeculture();
        this.restdateculture = dto.getRestdateculture();
        this.parkingculture = dto.getParkingculture();
        this.chkbabycarriageculture = dto.getChkbabycarriageculture();
        this.chkpetculture = dto.getChkpetculture();
        this.chkcreditcardculture = dto.getChkcreditcardculture();

    }
}

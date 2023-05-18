package com.ssafy.crawling.entity.placedetail;

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
}

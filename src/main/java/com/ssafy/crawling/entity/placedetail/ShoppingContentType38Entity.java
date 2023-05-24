package com.ssafy.crawling.entity.placedetail;


import com.ssafy.crawling.dto.placedetail.ContentType38_ShoppingDto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "shopping_detail_content_type_38")
public class ShoppingContentType38Entity {
    @Id
    int contentid;
    int contenttypeid;
    String saleitem;
    String saleitemcost;
    String fairday;
    String opendateshopping;
    String shopguide;
    String culturecenter;
    String restroom;
    String infocentershopping;
    String scaleshopping;
    String restdateshopping;
    String parkingshopping;
    String chkbabycarriageshopping;
    String chkpetshopping;
    String chkcreditcardshopping;
    String opentime;

    public void post(ContentType38_ShoppingDto dto) {
        this.contentid = Integer.parseInt(dto.getContentid());
        this.contenttypeid = Integer.parseInt(dto.getContenttypeid());

        this.saleitem = dto.getSaleitem();
        this.saleitemcost = dto.getSaleitemcost();
        this.fairday = dto.getFairday();
        this.opendateshopping = dto.getOpendateshopping();
        this.shopguide = dto.getShopguide();
        this.culturecenter = dto.getCulturecenter();
        this.restroom = dto.getRestroom();
        this.infocentershopping = dto.getInfocentershopping();
        this.scaleshopping = dto.getScaleshopping();
        this.restdateshopping = dto.getRestdateshopping();
        this.parkingshopping = dto.getParkingshopping();
        this.chkbabycarriageshopping = dto.getChkbabycarriageshopping();
        this.chkpetshopping = dto.getChkpetshopping();
        this.chkcreditcardshopping = dto.getChkcreditcardshopping();
        this.opentime = dto.getOpentime();

    }
}


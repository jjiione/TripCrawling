package com.ssafy.crawling.apimanager;

import com.ssafy.crawling.dto.placedetail.*;
import com.ssafy.crawling.entity.placedetail.*;
import com.ssafy.crawling.service.placedetail.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Component
public class PlaceDetailOpenApiManager {
//    private ImageService imageService;

    @Value("${key6}")
    private String serviceKey;
    private final ContentType12Service contentType12Service;
    private final ContentType39Service contentType39Service;
    private final ContentType14Service contentType14Service;
    private final ContentType32Service contentType32Service;
    private final ContentType38Service contentType38Service;

    @Autowired
    public PlaceDetailOpenApiManager(ContentType12Service contentType12Service,
                                     ContentType39Service contentType39Service,
                                     ContentType14Service contentType14Service,
                                     ContentType32Service contentType32Service,
                                     ContentType38Service contentType38Service) {
        this.contentType12Service = contentType12Service;
        this.contentType39Service = contentType39Service;
        this.contentType14Service = contentType14Service;
        this.contentType32Service = contentType32Service;
        this.contentType38Service = contentType38Service;

    }

    private URI makeUrl(int contentId, int contentTypeId) throws URISyntaxException {

        return new URI( "http://apis.data.go.kr/B551011/KorService1/detailIntro1?" +
                "MobileOS=ETC&" +
                "MobileApp=AppTest&" +
                "_type=json&" +
                "contentId=" + contentId + "&" +
                "contentTypeId=" + contentTypeId + "&" +
                "numOfRows=10&" +
                "pageNo=1&" +
                "serviceKey=" + serviceKey
        );
    }


    public void fetch(int contentId, int contentTypeId) throws ParseException {

        RestTemplate restTemplate = new RestTemplate();

        String jsonString = null;   // 이게 문제일지도...?
        try {
            jsonString = restTemplate.getForObject(makeUrl(contentId, contentTypeId), String.class);

            System.out.println("출력" + jsonString);
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = null;

            jsonObject = (JSONObject) jsonParser.parse(jsonString);

            // 가장 큰 JSON 객체 response 가져오기
            JSONObject jsonResponse = (JSONObject) jsonObject.get("response");

            // 그 다음 body 부분 파싱
            JSONObject jsonBody = (JSONObject) jsonResponse.get("body");

            // 그 다음 위치 정보를 배열로 담은 items 파싱

            JSONObject jsonItems = (JSONObject) jsonBody.get("items");
            JSONArray jsonItemList = (JSONArray) jsonItems.get("item");


            if(contentTypeId == 12){
                List<ContentType12_AttractionDto> result = new ArrayList<>();


                for (Object o : jsonItemList) {
                    JSONObject item = (JSONObject) o;
                    result.add(makeType12Dto(item));
                }

                for(ContentType12_AttractionDto dto: result){
                    AttractionContentType12Entity entity = new AttractionContentType12Entity();
                    entity.post(dto);
                    contentType12Service.save(entity);

                }
            }else if(contentTypeId == 39){
                List<ContentType39_RestaurantDto> result = new ArrayList<>();


                for (Object o : jsonItemList) {
                    JSONObject item = (JSONObject) o;
                    result.add(makeType39Dto(item));
                }

                for(ContentType39_RestaurantDto dto : result){
                    RestaurantContentType39Entity entity = new RestaurantContentType39Entity();
                    entity.post(dto);
                    contentType39Service.save(entity);

                }

            }else if(contentTypeId == 14){
                List<ContentType14_CultureInfraDto> result = new ArrayList<>();


                for (Object o : jsonItemList) {
                    JSONObject item = (JSONObject) o;
                    result.add(makeType14Dto(item));
                }

                for(ContentType14_CultureInfraDto dto : result){
                    CultureInfraContentType14Entity entity = new CultureInfraContentType14Entity();
                    entity.post(dto);
                    contentType14Service.save(entity);

                }

            }

            else if(contentTypeId == 32){
                List<ContentType32_AccomodationDto> result = new ArrayList<>();


                for (Object o : jsonItemList) {
                    JSONObject item = (JSONObject) o;
                    result.add(makeType32Dto(item));
                }

                for(ContentType32_AccomodationDto dto : result){
                    AccomodationContentType32Entity entity = new AccomodationContentType32Entity();
                    entity.post(dto);
                    contentType32Service.save(entity);

                }

            }

            else if(contentTypeId == 38){
                List<ContentType38_ShoppingDto> result = new ArrayList<>();


                for (Object o : jsonItemList) {
                    JSONObject item = (JSONObject) o;
                    result.add(makeType38Dto(item));
                }

                for(ContentType38_ShoppingDto dto : result){
                    ShoppingContentType38Entity entity = new ShoppingContentType38Entity();
                    entity.post(dto);
                    contentType38Service.save(entity);

                }

            }


//            System.out.println(result);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private ContentType39_RestaurantDto makeType39Dto(JSONObject item) {
        ContentType39_RestaurantDto dto = new ContentType39_RestaurantDto();
        dto.setContentid((String) item.get("contentid"));
        dto.setContenttypeid((String) item.get("contenttypeid"));
        dto.setSeat((String) item.get("seat"));
        dto.setKidsfacility((String) item.get("kidsfacility"));
        dto.setFirstmenu((String) item.get("firstmenu"));
        dto.setTreatmenu((String) item.get("treatmenu"));
        dto.setSmoking((String) item.get("smoking"));
        dto.setPacking((String) item.get("packing"));
        dto.setInfocenterfood((String) item.get("infocenterfood"));
        dto.setScalefood((String) item.get("scalefood"));
        dto.setParkingfood((String) item.get("parkingfood"));
        dto.setOpendatefood((String) item.get("opendatefood"));
        dto.setOpentimefood((String) item.get("opentimefood"));
        dto.setRestdatefood((String) item.get("restdatefood"));
        dto.setDiscountinfofood((String) item.get("discountinfofood"));
        dto.setChkcreditcardfood((String) item.get("chkcreditcardfood"));
        dto.setReservationfood((String) item.get("reservationfood"));
        dto.setLcnsno((String) item.get("lcnsno"));

        return dto;
    }

    private ContentType12_AttractionDto makeType12Dto(JSONObject item) {
        ContentType12_AttractionDto dto = new ContentType12_AttractionDto();
        dto.setContentid((String) item.get("contentid"));
        dto.setContenttypeid((String) item.get("contenttypeid"));
        dto.setHeritage1((String) item.get("heritage1"));
        dto.setHeritage2((String) item.get("heritage2"));
        dto.setHeritage3((String) item.get("heritage1"));
        dto.setInfocenter((String) item.get("infocenter"));
        dto.setOpendate((String) item.get("opendate"));
        dto.setRestdate((String) item.get("restdate"));
        dto.setExpguide((String) item.get("expguide"));
        dto.setExpagerange((String) item.get("expagerange"));
        dto.setAccomcount((String) item.get("accomcount"));
        dto.setUseseason((String) item.get("useseason"));
        dto.setUsetime((String) item.get("usetime"));
        dto.setParking((String) item.get("parking"));
        dto.setChkbabycarriage((String) item.get("chkbabycarriage"));
        dto.setChkpet((String) item.get("chkpet"));
        dto.setChkcreditcard((String) item.get("chkcreditcard"));
        return dto;
    }

    private ContentType14_CultureInfraDto makeType14Dto(JSONObject item) {
        ContentType14_CultureInfraDto dto = new ContentType14_CultureInfraDto();
        dto.setContentid((String) item.get("contentid"));
        dto.setContenttypeid((String) item.get("contenttypeid"));
        dto.setScale((String) item.get("scale"));
        dto.setUsefee((String) item.get("usefee"));
        dto.setDiscountinfo((String) item.get("discountinfo"));
        dto.setSpendtime((String) item.get("spendtime"));
        dto.setParkingfee((String) item.get("parkingfee"));
        dto.setInfocenterculture((String) item.get("infocenterculture"));
        dto.setAccomcountculture((String) item.get("cccomcountculture"));
        dto.setUsetimeculture((String) item.get("usetimeculture"));
        dto.setRestdateculture((String) item.get("restdateculture"));
        dto.setParkingculture((String) item.get("parkingculture"));
        dto.setChkbabycarriageculture((String) item.get("chkbabycarriageculture"));
        dto.setChkpetculture((String) item.get("chkpetculture"));
        dto.setChkcreditcardculture((String) item.get("chkcreditcardculture"));
        return dto;

    }

    private ContentType32_AccomodationDto makeType32Dto(JSONObject item) {
        ContentType32_AccomodationDto dto = new ContentType32_AccomodationDto();
        dto.setContentid((String) item.get("contentid"));
        dto.setContenttypeid((String) item.get("contenttypeid"));
        dto.setGoodstay((String) item.get("goodstay"));
        dto.setBenikia((String) item.get("benikia"));
        dto.setHanok((String) item.get("hanok"));
        dto.setRoomcount((String) item.get("roomcount"));
        dto.setRoomtype((String) item.get("roomtype"));
        dto.setRefundregulation((String) item.get("refundregulation"));
        dto.setCheckintime((String) item.get("checkintime"));
        dto.setCheckouttime((String) item.get("checkouttime"));
        dto.setChkcooking((String) item.get("chkcooking"));
        dto.setSeminar((String) item.get("seminar"));
        dto.setSports((String) item.get("sports"));
        dto.setSauna((String) item.get("sauna"));
        dto.setBeauty((String) item.get("beauty"));
        dto.setBeverage((String) item.get("beverage"));
        dto.setKaraoke((String) item.get("karaoke"));
        dto.setBarbecue((String) item.get("barbecue"));
        dto.setCampfire((String) item.get("campfire"));
        dto.setBicycle((String) item.get("bicycle"));
        dto.setFitness((String) item.get("fitness"));
        dto.setPublicpc((String) item.get("publicpc"));
        dto.setPublicbath((String) item.get("publicbath"));
        dto.setSubfacility((String) item.get("subfacility"));
        dto.setFoodplace((String) item.get("foodplace"));
        dto.setReservationurl((String) item.get("reservationurl"));
        dto.setPickup((String) item.get("pickup"));
        dto.setInfocenterlodging((String) item.get("infocenterlodging"));
        dto.setParkinglodging((String) item.get("parkinglodging"));
        dto.setReservationlodging((String) item.get("reservationlodging"));
        dto.setScalelodging((String) item.get("scalelodging"));
        dto.setAccomcountlodging((String) item.get("accomcountlodging"));
        return dto;
    }

    private ContentType38_ShoppingDto makeType38Dto(JSONObject item) {
        ContentType38_ShoppingDto dto = new ContentType38_ShoppingDto();
        dto.setContentid((String) item.get("contentid"));
        dto.setContenttypeid((String) item.get("contenttypeid"));
        dto.setSaleitem((String) item.get("saleitem"));
        dto.setSaleitemcost((String) item.get("saleitemcost"));
        dto.setFairday((String) item.get("fairday"));
        dto.setOpendateshopping((String) item.get("opendateshopping"));
        dto.setShopguide((String) item.get("shopguide"));
        dto.setCulturecenter((String) item.get("culturecenter"));
        dto.setRestroom((String) item.get("restroom"));
        dto.setInfocentershopping((String) item.get("infocentershopping"));
        dto.setScaleshopping((String) item.get("scaleshopping"));
        dto.setRestdateshopping((String) item.get("restdateshopping"));
        dto.setParkingshopping((String) item.get("parkingshopping"));
        dto.setChkbabycarriageshopping((String) item.get("chkbabycarriageshopping"));
        dto.setChkpetshopping((String) item.get("chkpetshopping"));
        dto.setChkcreditcardshopping((String) item.get("chkcreditcardshopping"));
        dto.setOpentime((String) item.get("opentime"));
        return dto;
    }


}



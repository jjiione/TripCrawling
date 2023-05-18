package com.ssafy.crawling.apimanager;

import com.ssafy.crawling.dto.ImageDto;
import com.ssafy.crawling.dto.placedetail.ContentType12_AttractionDto;
import com.ssafy.crawling.entity.PlaceImagesEntity;
import com.ssafy.crawling.entity.placedetail.AttractionContentType12Entity;
import com.ssafy.crawling.service.ImageService;
import com.ssafy.crawling.service.placedetail.ContentType12Service;
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

    @Value("${key5}")
    private String serviceKey;
    private final ContentType12Service contentType12Service;

    @Autowired
    public PlaceDetailOpenApiManager(ContentType12Service contentType12Service) {
        this.contentType12Service = contentType12Service;
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
            }


//            System.out.println(result);

        } catch (Exception e) {
            e.printStackTrace();
        }

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

}

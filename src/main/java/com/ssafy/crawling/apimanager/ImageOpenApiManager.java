package com.ssafy.crawling.apimanager;

import com.ssafy.crawling.dto.ImageDto;
import com.ssafy.crawling.dto.OpenApiDto;
import com.ssafy.crawling.entity.CategoriesEntity;
import com.ssafy.crawling.entity.PlaceImagesEntity;
import com.ssafy.crawling.service.ImageService;
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
public class ImageOpenApiManager {

    private ImageService imageService;

    @Value("${key3}")
    private String serviceKey;

    @Autowired
    public ImageOpenApiManager(ImageService imageService) {
        this.imageService = imageService;
    }

    private URI makeUrl(int placeId) throws URISyntaxException {

        return new URI( "http://apis.data.go.kr/B551011/KorService1/detailImage1?" +
                "MobileOS=ETC&" +
                "MobileApp=AppTest&" +
                "_type=json&" +
                "contentId=" + placeId + "&" +
                "imageYN=Y&" +
                "subImageYN=Y&" +
                "numOfRows=100&" +
                "pageNo=1&" +
                "serviceKey=" + serviceKey + "&"
                );
    }


    public void fetch(int placeId) throws ParseException {

        RestTemplate restTemplate = new RestTemplate();

        String jsonString = null;   // 이게 문제일지도...?
        try {
            jsonString = restTemplate.getForObject(makeUrl(placeId), String.class);

            System.out.println("출력" + jsonString);
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = null;

            jsonObject = (JSONObject) jsonParser.parse(jsonString);

            // 가장 큰 JSON 객체 response 가져오기
            JSONObject jsonResponse = (JSONObject) jsonObject.get("response");

            // 그 다음 body 부분 파싱
            JSONObject jsonBody = (JSONObject) jsonResponse.get("body");

            // 그 다음 위치 정보를 배열로 담은 items 파싱
            List<ImageDto> result = new ArrayList<>();

            JSONObject jsonItems = (JSONObject) jsonBody.get("items");
            JSONArray jsonItemList = (JSONArray) jsonItems.get("item");


            for (Object o : jsonItemList) {
                JSONObject item = (JSONObject) o;
                result.add(makeImageDto(item));
            }

            for(ImageDto apiDto : result){
                PlaceImagesEntity placeImagesEntity = new PlaceImagesEntity();
                placeImagesEntity.postImg(apiDto);
                imageService.postImg(placeImagesEntity);

            }

//            System.out.println(result);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private ImageDto makeImageDto(JSONObject item) {
        ImageDto imageDto = new ImageDto();
        imageDto.setContentId(Integer.parseInt((String) item.get("contentid")));
        imageDto.setImgName((String) item.get("imgname"));
        imageDto.setImgSrc((String) item.get("originimgurl"));
        imageDto.setMainImg("N");
        return imageDto;
    }

}

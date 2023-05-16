package com.ssafy.crawling.apimanager;

import com.ssafy.crawling.dto.OpenApiDto;
import com.ssafy.crawling.entity.CategoriesEntity;
import com.ssafy.crawling.service.CategoryService;
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
public class CatOpenApiManager {

    private CategoryService categoryService;

    private String [] contentTypeId = {"12", "14", "15", "25", "28", "32", "38", "39"};
//    private String serviceKey = "z3vgw8Qjex43dubAYmTKS%2BYTCarK5JjMqfW6Da3cYCNTdA2FqJThjd15mnJY6lqmPFSCIehjR2Jex%2F71IGfBvw%3D%3D";
    @Value("${key4}")
    private String serviceKey;
    @Autowired
    public CatOpenApiManager(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    private URI makeUrl(String cat1) throws URISyntaxException {

       return new URI( "http://apis.data.go.kr/B551011/KorService1/categoryCode1?" +
                "serviceKey=" + serviceKey + "&" +
                "numOfRows=1000&" +
                "pageNo=1&" +
                "MobileOS=ETC&" +
                "MobileApp=AppTest&" +
                "contentTypeId=39&" +
                "cat1=" + cat1 + "&" +
                "_type=json");
    }

    private URI makeUrl0() throws URISyntaxException {

        return new URI( "http://apis.data.go.kr/B551011/KorService1/categoryCode1?" +
                "serviceKey=" + serviceKey + "&" +
                "numOfRows=1000&" +
                "pageNo=1&" +
                "MobileOS=ETC&" +
                "MobileApp=AppTest&" +
                "contentTypeId=39&" +
                "_type=json");
    }


    private URI makeUrlCat2(String cat2) throws URISyntaxException {

        return new URI( "http://apis.data.go.kr/B551011/KorService1/categoryCode1?" +
                "serviceKey=" + serviceKey + "&" +
                "numOfRows=200&" +
                "pageNo=1&" +
                "MobileOS=ETC&" +
                "MobileApp=AppTest&" +
                "contentTypeId=39&" +
                "cat1=" + cat2.substring(0, 3) + "&" +
                "cat2=" + cat2 + "&" +
                "_type=json");
    }

    private URI makeUrlCat3(String cat3) throws URISyntaxException {


        return new URI( "http://apis.data.go.kr/B551011/KorService1/categoryCode1?" +
                "serviceKey=" + serviceKey + "&" +
                "numOfRows=100&" +
                "pageNo=1&" +
                "MobileOS=ETC&" +
                "MobileApp=AppTest&" +
                "contentTypeId=14&" +
                "cat1=" + cat3.substring(0, 3) + "&" +
                "cat2=" + cat3.substring(0, 5) + "&" +
                "cat3=" + cat3 + "&" +
                "_type=json");
    }



    public void fetch(String cat) throws ParseException {

        RestTemplate restTemplate = new RestTemplate();

        String jsonString = null;   // 이게 문제일지도...?
        try {
            if(cat.length() == 3){
                jsonString = restTemplate.getForObject(makeUrl(cat), String.class);
            }else if(cat.length() == 5){
                jsonString = restTemplate.getForObject(makeUrlCat2(cat), String.class);
            }else if(cat.length() == 0){
                System.out.println("cat0 fetch ");
                jsonString = restTemplate.getForObject(makeUrl0(), String.class);
            } else{
                jsonString = restTemplate.getForObject(makeUrlCat3(cat), String.class);
            }

            System.out.println("출력" + jsonString);
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = null;

            jsonObject = (JSONObject) jsonParser.parse(jsonString);

            // 가장 큰 JSON 객체 response 가져오기
            JSONObject jsonResponse = (JSONObject) jsonObject.get("response");

            // 그 다음 body 부분 파싱
            JSONObject jsonBody = (JSONObject) jsonResponse.get("body");

            // 그 다음 위치 정보를 배열로 담은 items 파싱
            List<OpenApiDto> result = new ArrayList<>();

            JSONObject jsonItems = (JSONObject) jsonBody.get("items");
            JSONArray jsonItemList = (JSONArray) jsonItems.get("item");


            for (Object o : jsonItemList) {
                JSONObject item = (JSONObject) o;
                result.add(makeLocationDto(item));
            }

            for(OpenApiDto apiDto : result){
                CategoriesEntity categoriesEntity = new CategoriesEntity();
                categoriesEntity.postCat(apiDto);
                categoryService.insertCat(categoriesEntity);
            }

            System.out.println(result);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private OpenApiDto makeLocationDto(JSONObject item) {
        OpenApiDto dto = new OpenApiDto();
        dto.setCode((String) item.get("code"));
        dto.setName((String) item.get("name"));
        return dto;
    }
}

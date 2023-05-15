package com.ssafy.crawling.apimanager;

import com.ssafy.crawling.dto.OpenApiDto;
import com.ssafy.crawling.entity.CategoriesEntity;
import com.ssafy.crawling.service.CategoryService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class OpenApiManager {

    private CategoryService categoryService;

    @Autowired
    public OpenApiManager(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    private URI makeUrl(String cat1) throws URISyntaxException {
        String serviceKey = "ItKuQSxKLd76EK5vnch0CVWfvLJ%2BXlM6%2FKpDipWck41TMJhrL8pvFUdtSiDlJMydRvJtkC1%2Ftqd9WRVcNw3S1w%3D%3D";
//        String serviceKey = "z3vgw8Qjex43dubAYmTKS+YTCarK5JjMqfW6Da3cYCNTdA2FqJThjd15mnJY6lqmPFSCIehjR2Jex/71IGfBvw==";
//        try {
//            serviceKey = URLEncoder.encode(serviceKey, "utf-8");
//        } catch (UnsupportedEncodingException e) {
//            throw new RuntimeException(e);
//        }
       return new URI( "http://apis.data.go.kr/B551011/KorService1/categoryCode1?" +
                "serviceKey=" + serviceKey + "&" +
                "numOfRows=10&" +
                "pageNo=1&" +
                "MobileOS=ETC&" +
                "MobileApp=AppTest&" +
                "contentTypeId=12&" +
                "cat1=" + cat1 + "&" +
                "_type=json");
    }

    public void fetch(String cat1) throws ParseException {

        RestTemplate restTemplate = new RestTemplate();
//        HttpEntity<?> entity = new HttpEntity<>(new HttpHeaders());
//        ResponseEntity<Map> resultMap = restTemplate.exchange(makeUrl(), HttpMethod.GET, entity, Map.class);
//        System.out.println(resultMap.getBody());
//        return resultMap;
//        String url = null;
//        try {
//            url = makeUrl(cat1);
//        } catch (URISyntaxException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println(url);
        String jsonString = null;   // 이게 문제일지도...?
        try {
            jsonString = restTemplate.getForObject(makeUrl(cat1), String.class);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
//        try {
//            restTemplate.getForObject(new URI(url), String.class);
//        } catch (URISyntaxException e) {
//            throw new RuntimeException(e);
//        }
//        ResponseEntity<String> jsonString = restTemplate.getForEntity(url, String.class);   // 이게 문제일지도...?
        System.out.println("출력" + jsonString);
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = null;
        try {
            jsonObject = (JSONObject) jsonParser.parse(jsonString);
        } catch (org.json.simple.parser.ParseException e) {
            throw new RuntimeException(e);
        }
        // 가장 큰 JSON 객체 response 가져오기
        JSONObject jsonResponse = (JSONObject) jsonObject.get("response");

        // 그 다음 body 부분 파싱
        JSONObject jsonBody = (JSONObject) jsonResponse.get("body");

        // 그 다음 위치 정보를 배열로 담은 items 파싱
        List<OpenApiDto> result = new ArrayList<>();
       try{
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



       }catch(Exception e){
           return;
        }

        // items는 JSON임, 이제 그걸 또 배열로 가져온다



//        return result;

    }

    private OpenApiDto makeLocationDto(JSONObject item) {
        OpenApiDto dto = new OpenApiDto();
        dto.setCode((String) item.get("code"));
        dto.setName((String) item.get("name"));
        return dto;
    }
}

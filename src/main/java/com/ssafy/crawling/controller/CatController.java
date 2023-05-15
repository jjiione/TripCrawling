package com.ssafy.crawling.controller;

import com.ssafy.crawling.apimanager.OpenApiManager;
import com.ssafy.crawling.dto.CatDto;
import com.ssafy.crawling.service.Cat1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController("/api")
public class CatController {
    private final Cat1Service cat1Service;
    private final OpenApiManager openApiManager;

    @Autowired
    public CatController(Cat1Service cat1Service, OpenApiManager openApiManager) {
        this.cat1Service = cat1Service;
        this.openApiManager = openApiManager;
    }

    @GetMapping("/cat/cat1/list")
    public void getCatApi (){
        List<CatDto> catDtos = new ArrayList<>();
        catDtos = cat1Service.catList();
        System.out.println(catDtos.size());
        System.out.println(catDtos);

        for(CatDto catDto : catDtos){

            String cat1 = catDto.getCode();
            if(!cat1.equals("") || !cat1.equals(" ")){
                try {
                    System.out.println("start");
                    openApiManager.fetch(cat1);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
//
            }


//            String apiUrl = "http://apis.data.go.kr/B551011/KorService1/categoryCode1?" +
//                    "serviceKey=z3vgw8Qjex43dubAYmTKS+YTCarK5JjMqfW6Da3cYCNTdA2FqJThjd15mnJY6lqmPFSCIehjR2Jex/71IGfBvw==&" +
//                    "numOfRows=10&" +
//                    "pageNo=1&" +
//                    "MobileOS=ETC&" +
//                    "MobileApp=AppTest&" +
//                    "contentTypeId=12&" +
//                    "cat1=" + cat1 + "&" +
//                    "_type=json";
//
////                URL url = new URL(apiUrl);
//            RestTemplate restTemplate = new RestTemplate();
//            HttpEntity<?> entity = new HttpEntity<>(new HttpHeaders());
//            ResponseEntity<Map> resultMap = restTemplate.exchange(apiUrl, HttpMethod.GET, entity, Map.class);
//            System.out.println(resultMap.getBody());

        }



//        return catDtos;
    }




}

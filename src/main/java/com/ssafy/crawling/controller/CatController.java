package com.ssafy.crawling.controller;

import com.ssafy.crawling.apimanager.OpenApiManager;
import com.ssafy.crawling.dto.CatDto;
import com.ssafy.crawling.service.Cat1Service;
import com.ssafy.crawling.service.Cat2Service;
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

    private final OpenApiManager openApiManager;
    private final Cat1Service cat1Service;
    private final Cat2Service cat2Service;

    @Autowired
    public CatController(Cat1Service cat1Service, OpenApiManager openApiManager, Cat2Service cat2Service) {
        this.cat1Service = cat1Service;
        this.openApiManager = openApiManager;
        this.cat2Service = cat2Service;
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

            }

        }
    }

    @GetMapping("/cat/cat2/list")
    public void getCat2Api (){
        List<CatDto> catDtos = new ArrayList<>();
        System.out.println("cat2 정보 불러오기");
        catDtos = cat2Service.catList();
        System.out.println(catDtos.size());
        System.out.println(catDtos);

        for(CatDto catDto : catDtos){

            String cat2 = catDto.getCode();
            if(!cat2.equals("") || !cat2.equals(" ")){

                try {
                    System.out.println("start");
                    openApiManager.fetch(cat2);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }

            }

        }
    }





}

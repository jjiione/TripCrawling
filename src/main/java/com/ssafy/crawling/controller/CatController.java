package com.ssafy.crawling.controller;

import com.ssafy.crawling.dto.CatDto;
import com.ssafy.crawling.service.Cat1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController("/api")
public class CatController {
    private final Cat1Service cat1Service;

    @Autowired
    public CatController(Cat1Service cat1Service) {
        this.cat1Service = cat1Service;
    }

    @GetMapping("/cat/list")
    public List<CatDto> getCatApi (){
        List<CatDto> catDtos = new ArrayList<>();
        catDtos = cat1Service.catList();
        String apiUrl = "http://apis.data.go.kr/B551011/KorService1/categoryCode1?" +
                "serviceKey=z3vgw8Qjex43dubAYmTKS+YTCarK5JjMqfW6Da3cYCNTdA2FqJThjd15mnJY6lqmPFSCIehjR2Jex/71IGfBvw==&" +
                "numOfRows=10&" +
                "pageNo=1&" +
                "MobileOS=ETC&" +
                "MobileApp=AppTest&" +
                "contentTypeId=12&" +
                "cat1=A01&" +
                "cat2=A0101&" +
                "cat3=A01010100&" +
                "_type=json";

        return catDtos;
    }




}

package com.ssafy.crawling.controller;

import com.ssafy.crawling.entity.CatDto;
import com.ssafy.crawling.service.CatService;
import com.ssafy.crawling.service.PlaceRDSService;
import com.ssafy.crawling.service.PlaceService;
import com.ssafy.crawling.entity.PlaceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {
    private final PlaceService placeService;
    private final PlaceRDSService placeRDSService;
    private final CatService catService;
    private List<PlaceDto> placeDtoList = new ArrayList<>();
    private List<CatDto> catDtos = null;

    @Autowired
    public Controller(PlaceService placeService, PlaceRDSService placeRDSService, CatService catService){
        this.placeService = placeService;
        this.placeRDSService = placeRDSService;
        this.catService = catService;
    }

    @GetMapping("/place/list")
    public List<PlaceDto> placeList(){
        placeDtoList = placeService.placeList();
        System.out.println(placeDtoList.size());

//        placeRDSService.insert(placeDtoList);

        return placeDtoList;
    }

    @GetMapping("place/cat/list")
    public List<CatDto> catList(){
        catDtos = new ArrayList<>();
        catDtos = catService.catList();

        List<String> urlList = new List<String>();

        for (CatDto catDto: catDtos) {
            String url = "apis.data.go.kr/B551011/KorService1 "+ param;
            urlList.add(url);

        }

        urlResponse = GetResponse(callAPIUrl);
        // urlResponse Business Logic


        return catDtos;
    }

    @PostMapping("place/get/find")
    public void test(@RequestParam("param")){
        System.out.println("test");
    }


}

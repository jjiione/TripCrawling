package com.ssafy.crawling.controller;

import com.ssafy.crawling.service.PlaceRDSService;
import com.ssafy.crawling.service.PlaceService;
import com.ssafy.crawling.model.PlaceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {
    private final PlaceService placeService;
    private final PlaceRDSService placeRDSService;
    private List<PlaceDto> placeDtoList = new ArrayList<>();

    @Autowired
    public Controller(PlaceService placeService, PlaceRDSService placeRDSService){
        this.placeService = placeService;
        this.placeRDSService = placeRDSService;
    }

    @GetMapping("/place/list")
    public List<PlaceDto> placeList(){
        placeDtoList = placeService.placeList();
        System.out.println(placeDtoList.size());

        return placeDtoList;
    }


}

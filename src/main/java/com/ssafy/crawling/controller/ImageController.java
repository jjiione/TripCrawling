package com.ssafy.crawling.controller;

import com.ssafy.crawling.apimanager.ImageOpenApiManager;
import com.ssafy.crawling.service.ImageService;
import com.ssafy.crawling.service.PlaceRDSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api/image")
public class ImageController {
    private ImageOpenApiManager imageOpenApiManager;
    private PlaceRDSService placeRDSService;
    @Autowired
    public ImageController(ImageOpenApiManager imageOpenApiManager, PlaceRDSService placeRDSService) {
        this.imageOpenApiManager = imageOpenApiManager;
        this.placeRDSService = placeRDSService;
    }



    @GetMapping("/list")
    public void imageRegist(){
        List<Integer> list = placeRDSService.list();

        for(int i=0; i<1000; i++){
            int placeId = list.get(i);
            try {
                imageOpenApiManager.fetch(placeId);
            } catch (ParseException e) {

            }
        }

    }
}

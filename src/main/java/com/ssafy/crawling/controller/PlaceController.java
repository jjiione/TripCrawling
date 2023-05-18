package com.ssafy.crawling.controller;

import com.ssafy.crawling.apimanager.PlaceDetailOpenApiManager;
import com.ssafy.crawling.entity.PlaceContentIdType;
import com.ssafy.crawling.service.PlaceContentIdTypeService;
import com.ssafy.crawling.service.PlaceRDSService;
import com.ssafy.crawling.service.PlaceService;
import com.ssafy.crawling.dto.PlaceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PlaceController {
    private final PlaceService placeService;
    private final PlaceRDSService placeRDSService;
    private final PlaceContentIdTypeService placeContentIdTypeService;
    private final PlaceDetailOpenApiManager placeDetailOpenApiManager;

    private List<PlaceDto> placeDtoList = new ArrayList<>();


    @Autowired
    public PlaceController(PlaceService placeService, PlaceRDSService placeRDSService, PlaceContentIdTypeService placeContentIdTypeService, PlaceDetailOpenApiManager placeDetailOpenApiManager){
        this.placeService = placeService;
        this.placeRDSService = placeRDSService;
        this.placeContentIdTypeService = placeContentIdTypeService;
        this.placeDetailOpenApiManager = placeDetailOpenApiManager;
    }

    @GetMapping("/place/list")
    public List<PlaceDto> placeList(){
        placeDtoList = placeService.placeList();
        System.out.println(placeDtoList.size());

        placeRDSService.insert(placeDtoList);

        return placeDtoList;
    }


    // place detail 가져오는 메서드
    @GetMapping("/place/{content_type_id}/detail")
    public List<PlaceContentIdType> placeDetail(@PathVariable int content_type_id){
        List<PlaceContentIdType> list = null;
        if(content_type_id == 12){
            list = placeContentIdTypeService.select12();
        }else if(content_type_id == 14){
            list = placeContentIdTypeService.select14();
        }else if(content_type_id == 15){
            list = placeContentIdTypeService.select15();
        }else if(content_type_id == 25){
            list = placeContentIdTypeService.select25();
        }else if(content_type_id == 28){
            list = placeContentIdTypeService.select28();
        }else if(content_type_id == 32){
            list = placeContentIdTypeService.select32();
        }else if(content_type_id == 38){
            list = placeContentIdTypeService.select38();
        }else if(content_type_id == 39){
            list = placeContentIdTypeService.select39();
        }

        for(int i=10900; i<11729; i++){
            try {
                placeDetailOpenApiManager.fetch(list.get(i).getContentId(), list.get(i).getContentTypeId());
                Thread.sleep(1500); //1.5초 대기
            } catch (ParseException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }






        return list;
    }




}

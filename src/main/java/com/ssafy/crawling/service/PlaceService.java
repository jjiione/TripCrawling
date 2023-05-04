package com.ssafy.crawling.service;

import com.ssafy.crawling.Entity.PlaceRDSEntity;
import com.ssafy.crawling.repository.PlaceRepository;
import com.ssafy.crawling.Entity.PlaceEntity;
import com.ssafy.crawling.model.PlaceDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class PlaceService {
    private PlaceRepository placeRepository;

    @Autowired
    public PlaceService(PlaceRepository placeRepository){
        this.placeRepository = placeRepository;
    }
    public List<PlaceDto> placeList(){
        List<PlaceEntity> places = placeRepository.findAll();
        List<PlaceDto> placeDtos = new ArrayList<>();
        for (PlaceEntity place : places) {
            PlaceDto placeDto = new PlaceDto(place);
            placeDtos.add(placeDto);
        }
        return placeDtos;
    }


}

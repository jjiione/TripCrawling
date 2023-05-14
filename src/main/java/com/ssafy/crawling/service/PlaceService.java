package com.ssafy.crawling.service;

import com.ssafy.crawling.reposiroty.PlaceRepository;
import com.ssafy.crawling.entity.PlaceEntity;
import com.ssafy.crawling.dto.PlaceDto;
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

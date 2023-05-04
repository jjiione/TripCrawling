package com.ssafy.crawling.service;

import com.ssafy.crawling.Entity.PlaceRDSEntity;
import com.ssafy.crawling.model.PlaceDto;
import com.ssafy.crawling.repository.PlaceRDSRepository;
import com.ssafy.crawling.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PlaceRDSService {
    private PlaceRDSRepository placeRDSRepository;

    @Autowired
    public PlaceRDSService(PlaceRDSRepository placeRDSRepository) {
        this.placeRDSRepository = placeRDSRepository;
    }

    @Transactional
    public void insert(List<PlaceDto> list){
        for (PlaceDto placeDto : list) {
            PlaceRDSEntity placeEntity = new PlaceRDSEntity();
            placeEntity.post(placeDto);
            placeRDSRepository.save(placeEntity);
        }


    }
}

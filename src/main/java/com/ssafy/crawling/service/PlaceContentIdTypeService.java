package com.ssafy.crawling.service;

import com.ssafy.crawling.entity.PlaceContentIdType;
import com.ssafy.crawling.reposiroty.PlaceContentIdTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceContentIdTypeService {

    private PlaceContentIdTypeRepository placeContentIdTypeRepository;

    @Autowired
    public PlaceContentIdTypeService(PlaceContentIdTypeRepository placeContentIdTypeRepository) {
        this.placeContentIdTypeRepository = placeContentIdTypeRepository;
    }

    public List<PlaceContentIdType> select12(){
        return placeContentIdTypeRepository.select12();

    }

    public List<PlaceContentIdType> select14(){
        return placeContentIdTypeRepository.select14();
    }


    public List<PlaceContentIdType> select15(){
        return placeContentIdTypeRepository.select15();
    }

    public List<PlaceContentIdType> select25(){
        return placeContentIdTypeRepository.select25();
    }

    public List<PlaceContentIdType> select28(){
        return placeContentIdTypeRepository.select28();
    }

    public List<PlaceContentIdType> select32(){
        return placeContentIdTypeRepository.select32();
    }

    public List<PlaceContentIdType> select38(){
        return placeContentIdTypeRepository.select38();
    }

    public List<PlaceContentIdType> select39(){
        return placeContentIdTypeRepository.select39();
    }
}

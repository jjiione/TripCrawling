package com.ssafy.crawling.service;

import com.ssafy.crawling.entity.CatDto;
import com.ssafy.crawling.entity.CatEntity;
import com.ssafy.crawling.reposiroty.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CatService {
    private final CatRepository catRepository;

    @Autowired
    public CatService(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    public List<CatDto> catList(){
        List<CatDto> catDtos = new ArrayList<>();
        List<CatEntity> catEntities = catRepository.findAll();
        for (CatEntity catEntity : catEntities) {
            CatDto catDto = new CatDto(catEntity);
            catDtos.add(catDto);
        }
        return catDtos;
    }
}

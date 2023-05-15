package com.ssafy.crawling.service;

import com.ssafy.crawling.dto.CatDto;
import com.ssafy.crawling.entity.Cat1Entity;
import com.ssafy.crawling.entity.Cat3Entity;
import com.ssafy.crawling.reposiroty.Cat1Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Cat1Service {
    private final Cat1Repository catRepository;

    @Autowired
    public Cat1Service(Cat1Repository catRepository) {
        this.catRepository = catRepository;
    }

    public List<CatDto> catList(){
        List<CatDto> catDtos = new ArrayList<>();
        List<Cat1Entity> catEntities = catRepository.findAll();
        for (Cat1Entity cat1Entity : catEntities) {
            CatDto catDto = new CatDto();
            catDto.setCode(cat1Entity.getCat1());
            catDtos.add(catDto);
        }
        return catDtos;
    }
}

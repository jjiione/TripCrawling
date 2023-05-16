package com.ssafy.crawling.service;

import com.ssafy.crawling.dto.CatDto;
import com.ssafy.crawling.entity.Cat3Entity;
import com.ssafy.crawling.reposiroty.Cat3Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Cat3Service {
    private final Cat3Repository catRepository;

    @Autowired
    public Cat3Service(Cat3Repository catRepository) {
        this.catRepository = catRepository;
    }

    public List<CatDto> catList(){
        List<CatDto> catDtos = new ArrayList<>();
        List<Cat3Entity> catEntities = catRepository.findAll();
        for (Cat3Entity cat3Entity : catEntities) {
            CatDto catDto = new CatDto();
            catDto.setCode(cat3Entity.getCat3());
            catDtos.add(catDto);
        }
        return catDtos;
    }
}

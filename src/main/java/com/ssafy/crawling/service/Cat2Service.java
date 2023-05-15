package com.ssafy.crawling.service;

import com.ssafy.crawling.dto.CatDto;
import com.ssafy.crawling.entity.Cat1Entity;
import com.ssafy.crawling.entity.Cat2Entity;
import com.ssafy.crawling.reposiroty.Cat1Repository;
import com.ssafy.crawling.reposiroty.Cat2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Cat2Service {

    private final Cat2Repository catRepository;

    @Autowired
    public Cat2Service(Cat2Repository catRepository) {
        this.catRepository = catRepository;
    }

    public List<CatDto> catList(){
        List<CatDto> catDtos = new ArrayList<>();
        List<Cat2Entity> catEntities = catRepository.findAll();
        for (Cat2Entity cat2Entity : catEntities) {
            CatDto catDto = new CatDto();
            catDto.setCode(cat2Entity.getCat2());
            catDtos.add(catDto);
        }
        return catDtos;
    }
}

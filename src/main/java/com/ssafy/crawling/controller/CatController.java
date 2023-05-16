package com.ssafy.crawling.controller;

import com.ssafy.crawling.apimanager.OpenApiManager;
import com.ssafy.crawling.dto.CatDto;
import com.ssafy.crawling.service.Cat1Service;
import com.ssafy.crawling.service.Cat3Service;
import com.ssafy.crawling.service.Cat2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CatController {

    private final OpenApiManager openApiManager;
    private final Cat3Service cat3Service;
    private final Cat2Service cat2Service;
    private final Cat1Service cat1Service;

    @Autowired
    public CatController(Cat3Service cat3Service, Cat2Service cat2Service, Cat1Service cat1Service, OpenApiManager openApiManager) {
        this.cat3Service = cat3Service;
        this.cat2Service = cat2Service;
        this.cat1Service = cat1Service;
        this.openApiManager = openApiManager;
    }

    @GetMapping("/cat/cat3/list")
    public void get3CatApi (){
        List<CatDto>catDtos = cat3Service.catList();
        System.out.println(catDtos.size());
        System.out.println(catDtos);

        for(CatDto catDto : catDtos){

            String cat = catDto.getCode();
            if(!cat.equals("") || !cat.equals(" ")){
                try {
                    System.out.println("start");
                    openApiManager.fetch(cat);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }

            }

        }
    }

    @GetMapping("/cat/cat2/list")
    public void getCat2Api (){
        List<CatDto> catDtos = new ArrayList<>();
        System.out.println("cat2 정보 불러오기");
        catDtos = cat2Service.catList();
        System.out.println(catDtos.size());
        System.out.println(catDtos);

        for(CatDto catDto : catDtos){

            String cat2 = catDto.getCode();
            if(!cat2.equals("") || !cat2.equals(" ")){

                try {
                    System.out.println("start");
                    openApiManager.fetch(cat2);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }

    @GetMapping("/cat/cat1/list")
    public void getCat1Api (){

        List<CatDto> catDtos = cat1Service.catList();
        System.out.println(catDtos.size());
        System.out.println(catDtos);

        for(CatDto catDto : catDtos){

            String cat = catDto.getCode();
            if(!cat.equals("") || !cat.equals(" ")){
                try {
                    System.out.println("start");
                    openApiManager.fetch(cat);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }



    @GetMapping("/cat/cat0/list")
    public void getCat0Api () {
        List<CatDto> catDtos = new ArrayList<>();
        System.out.println("cat0 정보 불러오기");

        try{
            openApiManager.fetch("");
        }catch (Exception e){

        }
    }





}

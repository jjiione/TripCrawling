package com.ssafy.crawling.service;

import com.ssafy.crawling.entity.PlaceImagesEntity;
import com.ssafy.crawling.reposiroty.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {
    private ImageRepository imageRepository;

    @Autowired
    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public void postImg(PlaceImagesEntity placeImagesEntity){
        imageRepository.save(placeImagesEntity);
    }
}

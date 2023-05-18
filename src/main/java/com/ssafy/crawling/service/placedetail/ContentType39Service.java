package com.ssafy.crawling.service.placedetail;

import com.ssafy.crawling.entity.placedetail.RestaurantContentType39Entity;
import com.ssafy.crawling.reposiroty.placedetail.ContentType39Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContentType39Service {
    private final ContentType39Repository contentType39Repository;

    @Autowired
    public ContentType39Service(ContentType39Repository contentType39Repository) {
        this.contentType39Repository = contentType39Repository;
    }



    public void save(RestaurantContentType39Entity entity){
        contentType39Repository.save(entity);
    }
}

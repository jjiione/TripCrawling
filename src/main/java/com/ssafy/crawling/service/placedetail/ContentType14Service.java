package com.ssafy.crawling.service.placedetail;

import com.ssafy.crawling.entity.placedetail.CultureInfraContentType14Entity;
import com.ssafy.crawling.entity.placedetail.RestaurantContentType39Entity;
import com.ssafy.crawling.reposiroty.placedetail.ContentType14Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContentType14Service {
    private final ContentType14Repository contentType14Repository;

    @Autowired
    public ContentType14Service(ContentType14Repository contentType14Repository) {
        this.contentType14Repository = contentType14Repository;
    }

    public void save(CultureInfraContentType14Entity entity){
        contentType14Repository.save(entity);
    }
}

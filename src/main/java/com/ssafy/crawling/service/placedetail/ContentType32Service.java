package com.ssafy.crawling.service.placedetail;


import com.ssafy.crawling.entity.placedetail.AccomodationContentType32Entity;
import com.ssafy.crawling.reposiroty.placedetail.ContentType32Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContentType32Service {
    private final ContentType32Repository contentType32Repository;

    @Autowired
    public ContentType32Service(ContentType32Repository contentType32Repository) {
        this.contentType32Repository = contentType32Repository;
    }

    public void save(AccomodationContentType32Entity entity){
        contentType32Repository.save(entity);
    }
}

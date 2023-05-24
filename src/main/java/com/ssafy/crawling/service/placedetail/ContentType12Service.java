package com.ssafy.crawling.service.placedetail;

import com.ssafy.crawling.entity.placedetail.AttractionContentType12Entity;
import com.ssafy.crawling.reposiroty.placedetail.ContentType12Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContentType12Service {

    private final ContentType12Repository contentType12Repository;

    @Autowired
    public ContentType12Service(ContentType12Repository contentType12Repository) {
        this.contentType12Repository = contentType12Repository;
    }

    public void save(AttractionContentType12Entity entity){
        contentType12Repository.save(entity);
    }


}

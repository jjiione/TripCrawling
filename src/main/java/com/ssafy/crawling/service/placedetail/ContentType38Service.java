package com.ssafy.crawling.service.placedetail;

import com.ssafy.crawling.entity.placedetail.ShoppingContentType38Entity;
import com.ssafy.crawling.reposiroty.placedetail.ContentType38Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContentType38Service {
    private final ContentType38Repository contentType38Repository;

    @Autowired
    public ContentType38Service(ContentType38Repository contentType38Repository) {
        this.contentType38Repository = contentType38Repository;
    }

    public void save(ShoppingContentType38Entity entity){
        contentType38Repository.save(entity);
    }
}

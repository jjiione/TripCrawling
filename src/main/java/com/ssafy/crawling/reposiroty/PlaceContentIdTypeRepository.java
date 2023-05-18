package com.ssafy.crawling.reposiroty;

import com.ssafy.crawling.entity.PlaceContentIdType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceContentIdTypeRepository extends JpaRepository<PlaceContentIdType, Integer> {

    @Query(value = "select content_id, content_type_id from place_content_id_type where content_type_id = 12", nativeQuery = true)
    public List<PlaceContentIdType> select12();

    @Query(value = "select content_id, content_type_id from place_content_id_type where content_type_id = 14", nativeQuery = true)
    public List<PlaceContentIdType> select14();

    @Query(value = "select content_id, content_type_id from place_content_id_type where content_type_id = 15", nativeQuery = true)
    public List<PlaceContentIdType> select15();

    @Query(value = "select content_id, content_type_id from place_content_id_type where content_type_id = 25", nativeQuery = true)
    public List<PlaceContentIdType> select25();

    @Query(value = "select content_id, content_type_id from place_content_id_type where content_type_id = 28", nativeQuery = true)
    public List<PlaceContentIdType> select28();

    @Query(value = "select content_id, content_type_id from place_content_id_type where content_type_id = 32", nativeQuery = true)
    public List<PlaceContentIdType> select32();
    @Query(value = "select content_id, content_type_id from place_content_id_type where content_type_id = 38", nativeQuery = true)
    public List<PlaceContentIdType> select38();
    @Query(value = "select content_id, content_type_id from place_content_id_type where content_type_id = 39", nativeQuery = true)
    public List<PlaceContentIdType> select39();
}

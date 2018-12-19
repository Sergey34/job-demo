package com.example.demo.repositories;

import com.example.demo.domains.Album;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "albums", path = "albums")
public interface AlbumRepository extends CrudRepository<Album, Long>, PagingAndSortingRepository<Album, Long> {
    @RestResource(path = "/title")
    List<Album> findAllByTitleLike(@Param("title") String title);

    @RestResource(path = "/singerId")
    List<Album> findAllBySinger_Id(@Param("singerId") Long singerId);

    @RestResource(path = "/songId")
    List<Album> findAllBySongsContains(@Param("songId") Long songId);

}

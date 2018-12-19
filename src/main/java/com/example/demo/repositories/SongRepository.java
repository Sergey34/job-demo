package com.example.demo.repositories;

import com.example.demo.domains.Song;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(collectionResourceRel = "song", path = "song")
public interface SongRepository extends CrudRepository<Song, Long> , PagingAndSortingRepository<Song, Long> {
}

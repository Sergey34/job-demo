package com.example.demo.repositories;

import com.example.demo.domains.Singer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "singers", path = "singers")
public interface SingerRepository extends CrudRepository<Singer, Long>, PagingAndSortingRepository<Singer, Long> {
    @RestResource(path = "/alias")
    List<Singer> findAllByAliasLike(@Param("alias") String alias);

}

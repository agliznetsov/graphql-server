package com.example.graphql.dao;

import com.example.graphql.model.Episode;
import com.example.graphql.model.FilmCharacter;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface CharacterRepository extends CrudRepository<FilmCharacter, Long> {

    List<FilmCharacter> findByIdIsIn(Set<Long> ids);

    @Query("select character from FilmCharacter character where ?1 member of character.appearsIn")
    List<FilmCharacter> findByEpisode(Episode episode);

}

package com.example.graphql.service;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.graphql.api.schema.Character;
import com.example.graphql.api.schema.CharacterType;
import com.example.graphql.api.schema.Episode;
import com.example.graphql.dao.CharacterRepository;
import com.example.graphql.model.FilmCharacter;

import graphql.schema.DataFetchingEnvironment;

@Component
public class CharacterImpl implements Character {

	@Autowired
	CharacterRepository repository;

	@Override
	public String getId(DataFetchingEnvironment e) {
		return character(e).getId().toString();
	}

	@Override
	public CharacterType getCharacterType(DataFetchingEnvironment e) {
		return CharacterType.valueOf(character(e).getCharacterType().name());
	}

	@Override
	public String getName(DataFetchingEnvironment e) {
		return character(e).getName();
	}

	@Override
	public Collection getFriends(DataFetchingEnvironment e, Integer limit, Integer offset) {
		long skip = offset == null ? 0 : offset;
		long max = limit == null ? Integer.MAX_VALUE : limit;
		return repository.findByIdIsIn(character(e).getFriendsIds()).stream()
				.skip(skip).limit(max).collect(Collectors.toList());
	}

	@Override
	public Collection getAppearsIn(DataFetchingEnvironment e) {
		return character(e).getAppearsIn().stream().map(it -> Episode.valueOf(it.name())).collect(Collectors.toList());
	}

	@Override
	public String getHomePlanet(DataFetchingEnvironment e) {
		return character(e).getHomePlanet();
	}


	private FilmCharacter character(DataFetchingEnvironment e) {
		return e.getSource();
	}

}

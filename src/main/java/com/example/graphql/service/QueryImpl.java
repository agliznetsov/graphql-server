package com.example.graphql.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.graphql.api.schema.Character;
import com.example.graphql.api.schema.FindCharactersRequest;
import com.example.graphql.api.schema.Query;
import com.example.graphql.dao.CharacterRepository;
import com.example.graphql.model.FilmCharacter;

import graphql.schema.DataFetchingEnvironment;

@Component
public class QueryImpl implements Query {

	@Autowired
	CharacterRepository repository;


	@Override
	public Collection getCharacters(DataFetchingEnvironment e, FindCharactersRequest request) {
		List list = new ArrayList();
		repository.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public Object getCharacter(DataFetchingEnvironment e, String id) {
		return repository.findById(Long.parseLong(id)).get();
	}

}

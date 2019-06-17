package com.example.graphql.api.wiring;

import com.example.graphql.api.schema.Character;

import graphql.schema.DataFetchingEnvironment;

public class CharacterDataFetcher {
	private Character instance;

	public CharacterDataFetcher(Character instance) {
		this.instance = instance;
	}

	public Object getId(DataFetchingEnvironment e) {
		return instance.getId(e);
	}

	public Object getCharacterType(DataFetchingEnvironment e) {
		return instance.getCharacterType(e);
	}

	public Object getName(DataFetchingEnvironment e) {
		return instance.getName(e);
	}

	public Object getFriends(DataFetchingEnvironment e) {
		Integer limit = e.getArgument("limit");
		Integer offset = e.getArgument("offset");
		return instance.getFriends(e, limit, offset);
	}

	public Object getAppearsIn(DataFetchingEnvironment e) {
		return instance.getAppearsIn(e);
	}

	public Object getHomePlanet(DataFetchingEnvironment e) {
		return instance.getHomePlanet(e);
	}
}

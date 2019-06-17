package com.example.graphql.api.wiring;

import com.example.graphql.api.schema.FindCharactersRequest;
import com.example.graphql.api.schema.Query;

import graphql.schema.DataFetchingEnvironment;

public class QueryDataFetcher {
	Query query;

	public QueryDataFetcher(Query query) {
		this.query = query;
	}

	public Object getCharacters(DataFetchingEnvironment e) {
		FindCharactersRequest request = e.getArgument("request");
		return query.getCharacters(e, request);
	}

	public Object getCharacter(DataFetchingEnvironment e) {
		String id = e.getArgument("id");
		return query.getCharacter(e, id);
	}
}

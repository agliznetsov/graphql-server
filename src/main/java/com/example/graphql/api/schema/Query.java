package com.example.graphql.api.schema;

import java.util.Collection;

import graphql.schema.DataFetchingEnvironment;

public interface Query {

	Collection getCharacters(DataFetchingEnvironment e, FindCharactersRequest request);

	Object getCharacter(DataFetchingEnvironment e, String id);

}

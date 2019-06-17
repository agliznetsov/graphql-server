package com.example.graphql.api.schema;

import java.util.Collection;
import java.util.List;

import graphql.schema.DataFetchingEnvironment;

public interface Character {

	String getId(DataFetchingEnvironment e);

	CharacterType getCharacterType(DataFetchingEnvironment e);

	String getName(DataFetchingEnvironment e);

	Collection getFriends(DataFetchingEnvironment e, Integer limit, Integer offset);

	Collection getAppearsIn(DataFetchingEnvironment e);

	String getHomePlanet(DataFetchingEnvironment e);

}

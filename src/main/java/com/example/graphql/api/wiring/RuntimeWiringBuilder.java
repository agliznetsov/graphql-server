package com.example.graphql.api.wiring;

import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

import com.example.graphql.api.schema.Character;
import com.example.graphql.api.schema.CharacterType;
import com.example.graphql.api.schema.Episode;
import com.example.graphql.api.schema.Query;

import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.TypeRuntimeWiring;

public abstract class RuntimeWiringBuilder {
	protected RuntimeWiring.Builder builder;

	public RuntimeWiringBuilder() {
		builder = RuntimeWiring.newRuntimeWiring();
	}

	public RuntimeWiring build() {
		builder.type(typeQuery());
//		builder.type(typeMutation());
		builder.type(typeCharacter());
		builder.type(typeEpisode());
		builder.type(typeCharacterType());
		return builder.build();
	}

	protected TypeRuntimeWiring.Builder typeQuery() {
		Query query = resolveSchemaType(Query.class);
		QueryDataFetcher dataFetcher = new QueryDataFetcher(query);
		return newTypeWiring("Query")
				.dataFetcher("characters", dataFetcher::getCharacters)
				.dataFetcher("character", dataFetcher::getCharacter);
	}

//	protected TypeRuntimeWiring typeMutation() {
//		Mutation instance = resolveSchemaType(Mutation.class);
//		MutationDataFetcher dataFetcher = new MutationDataFetcher(instance);
//		return newTypeWiring("Mutation")
//				.dataFetcher("addCharacter", dataFetcher::addCharacter)
//				.dataFetcher("removeCharacter", dataFetcher::removeCharacter)
//				.dataFetcher("changeCharacter", dataFetcher::changeCharacter)
//				.dataFetcher("addFriend", dataFetcher::addFriend)
//				.dataFetcher("removeFriend", dataFetcher::removeFriend)
//				.build();
//	}

	protected TypeRuntimeWiring typeCharacter() {
		Character instance = resolveSchemaType(Character.class);
		CharacterDataFetcher dataFetcher = new CharacterDataFetcher(instance);
		return newTypeWiring("Character")
				.dataFetcher("id", dataFetcher::getId)
				.dataFetcher("characterType", dataFetcher::getCharacterType)
				.dataFetcher("name", dataFetcher::getName)
				.dataFetcher("homePlanet", dataFetcher::getHomePlanet)
				.dataFetcher("appearsIn", dataFetcher::getAppearsIn)
				.dataFetcher("friends", dataFetcher::getFriends)
				.build();
	}

	protected TypeRuntimeWiring.Builder typeEpisode() {
		return newTypeWiring("Episode").enumValues(Episode::valueOf);
	}

	protected TypeRuntimeWiring.Builder typeCharacterType() {
		return newTypeWiring("CharacterType").enumValues(CharacterType::valueOf);
	}

	protected abstract <T> T resolveSchemaType(Class<T> type);

}

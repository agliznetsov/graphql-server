package com.example.graphql.api.schema;

import java.util.List;

import lombok.Data;

@Data
public class ChangeCharacterRequest {
	String id;
	CharacterType characterType;
	String name;
	List<Episode> appearsIn;
	String homePlanet;
}

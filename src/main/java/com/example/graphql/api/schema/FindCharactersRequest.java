package com.example.graphql.api.schema;

import lombok.Data;

@Data
public class FindCharactersRequest {
	CharacterType characterType;
	Episode episode;
	Integer limit;
	Integer offset;
}

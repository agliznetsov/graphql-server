//package com.example.graphql.api.wiring;
//
//import com.example.graphql.api.schema.ChangeCharacterRequest;
//import com.example.graphql.api.schema.Mutation;
//
//import graphql.schema.DataFetchingEnvironment;
//
//public class MutationDataFetcher {
//	Mutation instance;
//
//	public MutationDataFetcher(Mutation instance) {
//		this.instance = instance;
//	}
//
//	public Object addCharacter(DataFetchingEnvironment e) {
//		ChangeCharacterRequest request = e.getArgument("request");
//		return instance.addCharacter(request);
//	}
//
//	public Object removeCharacter(DataFetchingEnvironment e) {
//		String characterId = e.getArgument("characterId");
//		return instance.removeCharacter(characterId);
//	}
//
//	public Object changeCharacter(DataFetchingEnvironment e) {
//		ChangeCharacterRequest request = e.getArgument("request");
//		return instance.changeCharacter(request);
//	}
//
//	public Object addFriend(DataFetchingEnvironment e) {
//		String characterId = e.getArgument("characterId");
//		String friendId = e.getArgument("friendId");
//		return instance.addFriend(characterId, friendId);
//	}
//
//	public Object removeFriend(DataFetchingEnvironment e) {
//		String characterId = e.getArgument("characterId");
//		String friendId = e.getArgument("friendId");
//		return instance.removeFriend(characterId, friendId);
//	}
//}

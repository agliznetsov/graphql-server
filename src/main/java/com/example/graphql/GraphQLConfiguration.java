package com.example.graphql;

import java.net.URL;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.graphql.api.wiring.RuntimeWiringBuilder;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import lombok.SneakyThrows;

@Configuration
public class GraphQLConfiguration {

	@Bean
	@SneakyThrows
	public GraphQL graphQL(RuntimeWiringBuilder wiringBuilder) {
		URL url = Resources.getResource("starwars.graphqls");
		String sdl = Resources.toString(url, Charsets.UTF_8);
		GraphQLSchema graphQLSchema = buildSchema(sdl, wiringBuilder);
		return GraphQL.newGraphQL(graphQLSchema).build();
	}

	private GraphQLSchema buildSchema(String sdl, RuntimeWiringBuilder wiringBuilder) {
		TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(sdl);
		RuntimeWiring runtimeWiring = wiringBuilder.build();
		SchemaGenerator schemaGenerator = new SchemaGenerator();
		return schemaGenerator.makeExecutableSchema(typeRegistry, runtimeWiring);
	}

}

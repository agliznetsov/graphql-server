package com.example.graphql.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WebTest {

	private static final String ENDPOINT = "/graphql";

	@Autowired
	private MockMvc mvc;

	@Test
	public void queryById() throws Exception {
		mvc.perform(post(ENDPOINT).content("{\"query\":\"{ human(id: 1000) { name }}\"}").contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().json("{'data': {'human':{'name':'Luke Skywalker'}}}", true));
	}

	@Test
	public void getSchema() throws Exception {
		mvc.perform(post(ENDPOINT).content("{\"query\":\"{ __schema { queryType { name } } } \"}").contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().json("{'data': {'__schema':{'queryType': {'name': 'Query'}}}}", true));
	}

}

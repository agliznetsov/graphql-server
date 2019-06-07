package com.example.graphql.web;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.apple.eawt.Application;

@RunWith(SpringRunner.class)
@SpringBootTest//(SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class WebTest {

	private static final String ENDPOINT = "/graphql";

	@Autowired
	private MockMvc mvc;

	@Test
	public void queryById() throws Exception {
		MvcResult response = mvc.perform(post(ENDPOINT).content("{\"query\":\"{ human(id: 1000) { name }}\"}").contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk()).andReturn();
//				.andExpect();  jsonPath("$[0].name", equals("bob0"))
	}

}

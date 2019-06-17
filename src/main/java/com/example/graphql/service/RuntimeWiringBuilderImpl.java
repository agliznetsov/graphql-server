package com.example.graphql.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.example.graphql.api.wiring.RuntimeWiringBuilder;

@Component
public class RuntimeWiringBuilderImpl extends RuntimeWiringBuilder {

	@Autowired
	ApplicationContext applicationContext;

	@Override
	protected <T> T resolveSchemaType(Class<T> type) {
		return applicationContext.getBean(type);
	}

}

package org.canal.test.cucumber;


import java.lang.reflect.Type;

import org.springframework.beans.factory.annotation.Configurable;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.cucumber.java.DefaultDataTableCellTransformer;
import io.cucumber.java.DefaultDataTableEntryTransformer;
import io.cucumber.java.DefaultParameterTransformer;


@Configurable
public class CucumberConfiguration {
	
	private final ObjectMapper objectMapper;
	
	public CucumberConfiguration() {
		objectMapper = new ObjectMapper();
	}
	
    @DefaultDataTableCellTransformer
	@DefaultDataTableEntryTransformer
	@DefaultParameterTransformer
	public Object transform(final Object from, final Type to) {
		return objectMapper.convertValue(from, objectMapper.constructType(to));
	}
	

}

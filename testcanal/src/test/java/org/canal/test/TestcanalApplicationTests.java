package org.canal.test;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@SpringBootTest
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
				 plugin = {"pretty"},
				 extraGlue = "org.canal.test.controllers")
class TestcanalApplicationTests{
	
	
	@Test
	void contextLoads() {
	}

}

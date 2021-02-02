package org.canal.test.cucumber;

import org.canal.test.TestcanalApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;



@RunWith(Cucumber.class)
@SpringBootTest(classes = {TestcanalApplication.class,
		                   CucumberIT.class},
                           webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@CucumberContextConfiguration
@CucumberOptions(plugin = {"pretty"}, tags="", features="src/test/resources/features")
public class CucumberIT {

}

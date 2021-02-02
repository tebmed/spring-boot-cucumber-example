package org.canal.test.glue;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Assertions;
import org.assertj.core.util.Arrays;
import org.canal.test.entities.SubscriberEntity;
import org.canal.test.repository.SubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.testng.asserts.Assertion;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class SubscriberSteps {
	
	
	@Autowired
	private TestRestTemplate testRestTemplate;
	
	@Autowired
	private SubscriberRepository susbcriberRepository;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	
	private List<SubscriberEntity> expectedSubscribers;
	
	private List<SubscriberEntity> actualSubscribers;
	
	@Before
	public void setup() {
		expectedSubscribers = new ArrayList<>();
		actualSubscribers   = new ArrayList<>();
		susbcriberRepository.deleteAll();
	}
	
	@Given("^the following subscribers$")
	public void givenTheFollowingSubscribers(List<SubscriberEntity> subscribers) {
		
         expectedSubscribers.addAll(subscribers);
         susbcriberRepository.saveAll(subscribers);
	}
	
	@When("^the user requests all the subscribers$")
	public void whenTheUserRequestAllTheSubcribers() throws JsonProcessingException{
	  List subscribers = Arrays.asList(objectMapper.readValue(testRestTemplate.getForEntity("/api/subscriber/subscribers", String.class).getBody(), SubscriberEntity[].class));
      actualSubscribers.addAll(subscribers);	
	}
	
	@Then("^all the subscribers are returned$")
	public void thenAllTheSubscriberAreReturned() {
		validateSusbcribers();
		
	}

	private void validateSusbcribers() {
       Assertions.assertEquals(expectedSubscribers.size(), actualSubscribers.size());
       IntStream.range(0, actualSubscribers.size())
                .forEach(index -> validateSusbcriber((SubscriberEntity)expectedSubscribers.get(index), (SubscriberEntity)actualSubscribers.get(index)));
	}

	private void validateSusbcriber(SubscriberEntity expected, SubscriberEntity actual) {
		assertEquals(expected.getFirstName(), actual.getFirstName());
	    assertEquals(expected.getLastName(), actual.getLastName());
	    assertEquals(expected.getAddress(), actual.getAddress());
	}
	

}

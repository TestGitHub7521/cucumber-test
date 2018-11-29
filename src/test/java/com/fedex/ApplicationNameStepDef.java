package com.fedex;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ApplicationNameStepDef extends CucumberRoot {
	
	private ResponseEntity<String> response;
	
	@When("^the client calls /api/config/name$")
	public void the_client_calls_api_config_name() throws Throwable {
		response = template.getForEntity("/api/config/name", String.class);
	    
	}

	@Then("^the client gets response status code of (\\d+)$")
	public void the_client_gets_response_status_code_of(int statusCode) throws Throwable {
		HttpStatus currentStatusCode = response.getStatusCode();
        assertThat("status code is incorrect : " +
                response.getBody(), currentStatusCode.value(), is(statusCode));

	}

	
	@And("^the client receives application name of \"([^\"]*)\"$")
	public void the_client_receives_application_name_of(String applicationName) throws Throwable {
		assertThat(response.getBody(), is(applicationName));
	}

}

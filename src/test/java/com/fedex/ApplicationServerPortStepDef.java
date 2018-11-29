package com.fedex;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ApplicationServerPortStepDef extends CucumberRoot{
	
	private ResponseEntity<String> response;
	
	@When("^the client calls /api/config/port$")
	public void the_client_calls_api_config_port() throws Throwable {
		 response = template.getForEntity("/api/config/port", String.class);
	    
	}

	@Then("^the client receives status code of (\\d+)$")
	public void the_client_receives_status_code_of(int statusCode) throws Throwable {
		HttpStatus currentStatusCode = response.getStatusCode();
        assertThat("status code is incorrect : " +
                response.getBody(), currentStatusCode.value(), is(statusCode));
	    
	}

	@And("^the client receives server port of (\\d+)$")
	public void the_client_receives_server_version(String serverPort) throws Throwable {
		assertThat(response.getBody(), is(serverPort));
	    
	}

}

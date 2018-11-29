package com.fedex;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EmployeeStepDef extends CucumberRoot{
	
	private ResponseEntity<String> response;
	
	@When("^the client calls /api/employees$")
	public void the_client_calls_api_employees() throws Throwable {
		response = template.getForEntity("http://localhost:9090/api/employees", String.class);
	    
	}
	
	@Then("^the client gets status code of (\\d+)$")
    public void the_client_receives_status_code_of(int statusCode) throws Throwable {
        HttpStatus currentStatusCode = response.getStatusCode();
        assertThat("status code is incorrect : " +
                response.getBody(), currentStatusCode.value(), is(statusCode));
    }

	@And("^the client receives employee details$")
	public void the_client_receives_employee_details() throws Throwable {
		assertTrue(response.getBody(), !response.getBody().equalsIgnoreCase("[]"));
	    
	}

}

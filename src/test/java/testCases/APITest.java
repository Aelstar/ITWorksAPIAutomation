package testCases;


import static org.testng.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class APITest {
	
	
	
	private String apiUrl="https://www.boredapi.com/api/activity";
    private Response response ;

    @When("I send a GET request to the API")
    public void i_send_a_get_request_to_the_api() {
        response = RestAssured.get(apiUrl);
    }

    @Then("the response code should be {int}")
    public void the_response_code_should_be(int expectedStatusCode) {
        assertEquals(expectedStatusCode, response.getStatusCode());
    }

    @Then("the response body should match the expected body")
    public void the_response_body_should_match_the_expected_body() {
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("activity_schema.json"));
    }

    @Given("the API endpoint {string}")
    public void the_api_endpoint(String apiUrl) {
        this.apiUrl = apiUrl;
    }
	
     
   

}

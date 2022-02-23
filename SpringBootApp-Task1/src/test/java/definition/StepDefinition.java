package definition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {
	@Given("I Set POST user service api endpoint")
	public void i_set_post_user_service_api_endpoint() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Employee is setting post service to the endpoint!!");
	    
	}

	@When("Send a POST HTTP request")
	public void send_a_post_http_request() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Employee sending post http request!!");
	}

	@Then("I receive valid Response")
	public void i_receive_valid_response() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Employee received valid response!!");
	    
	}
}

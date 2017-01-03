package webservices_testing.steps;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

import net.thucydides.core.annotations.Steps;
import webservices_testing.essentials.MessangerGetSinglePostEssential;

public class MessangerGetSinglePostStepDefinition {
	
	@Steps
	MessangerGetSinglePostEssential messangerGetSinglePostEssential;
	
	@When("I call getSinglePost API")
	public void whenIcallGetSinglePostApi() throws Exception{
		messangerGetSinglePostEssential.getSinglePostApi();
	}
	
	@Then("Verify the response contains $responseInfo")
	public void thenVerifyResponse(ExamplesTable responseInfo){
		messangerGetSinglePostEssential.verifyResponse(responseInfo);
	}

}

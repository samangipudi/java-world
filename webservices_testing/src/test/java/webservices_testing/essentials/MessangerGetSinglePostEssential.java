package webservices_testing.essentials;

import java.util.Map;

import org.jbehave.core.model.ExamplesTable;
import org.junit.Assert;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.thucydides.core.annotations.Step;
import webservices_testing.dto.MessangerGetSinglePostDto;
import webservices_testing.utils.WebServiceClient;

public class MessangerGetSinglePostEssential {
	
	public static String SERVICE_URL = "http://jsonplaceholder.typicode.com/posts/1";
	WebServiceClient client;
	ObjectMapper objectMapper;
	MessangerGetSinglePostDto response;
	
	
	@Step
	public void getSinglePostApi() throws Exception {
		client.sendGetRequest(SERVICE_URL);
		response = objectMapper.readValue(client.getResponse(), MessangerGetSinglePostDto.class);
	}


	@Step
	public void verifyResponse(ExamplesTable responseInfo) {
		
		for(Map<String, String> row: responseInfo.getRows()){
			
			String userId = row.get("UserId");
			String id = row.get("Id");
			String title = row.get("Title");
			String body = row.get("Body");
			
			Assert.assertEquals("Assertion for UserId failed",userId, response.getUserId());
			Assert.assertEquals("Assertion for Id failed",id, response.getId());
			Assert.assertEquals("Assertion for Title failed",title, response.getTitle());
			Assert.assertEquals("Assertion for Body failed",body, response.getBody());
			
		}
		
	}

}

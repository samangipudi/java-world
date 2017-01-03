package webservices_testing.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;

import com.fasterxml.jackson.core.JsonParser;

public class WebServiceClient {
	
	private HttpResponse response;
	private HttpClient httpClient = HttpClientBuilder.create().build();
	private String jsonResponse;
	
	public boolean sendGetRequest(String serviceUrl){
		HttpGet getRequest = null;
		response = null;
		jsonResponse = "";
		String output;
		
		try{
		getRequest = new HttpGet(serviceUrl);
		getRequest.addHeader("content-type","application/json");
		getRequest.addHeader("accept","application/json");
		
			response = httpClient.execute(getRequest);
			
			if((response.getStatusLine().getStatusCode() !=200)
					&&(response.getStatusLine().getStatusCode()!=202)){
				System.out.println("Http response :"+response.getStatusLine());
				System.out.println("HttpResponse if not 200 = "
						+ response.getStatusLine().getStatusCode()
						+" "
						+ response.getStatusLine().getReasonPhrase());
				
				return false;
			}
			
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(response.getEntity().getContent()));
			
			while((output = reader.readLine())!= null){
				jsonResponse+=output;
			}
			
			System.out.println("Response : "+ jsonResponse);
			reader.close();
			return true;
			
		} catch (Exception e) {
			Assert.fail("GET request failed for URL "+serviceUrl
					+"Exception Found "+ e.getMessage());
			
			e.printStackTrace();
		}finally{
			getRequest.releaseConnection();
		}
		return false;
		
	}

	public String getResponse() {
		return jsonResponse;
	}

	
}

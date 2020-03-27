package as.re;
import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class TestApi 
{
	@Test(priority=1)
    public void get_Test()
    {
		Response r =get("http://dummy.restapiexample.com/api/v1/employees");
		System.out.println(r.asString());
		System.out.println("______________________________________"+r.statusCode());
		assertEquals(r.statusCode(), 200);
    }
	@Test(priority=2)
	public void post_test() throws ClientProtocolException, IOException
	{
		 String payload = "data={" +
	                "\"name\": \"Mohit\", " +
	                "\"salary\": \"10000\", " +
	                "\"age\": \"22\"" +
	                "}";
	        StringEntity entity = new StringEntity(payload);

	        HttpClient httpClient = HttpClientBuilder.create().build();
	        HttpPost request = new HttpPost("http://dummy.restapiexample.com/api/v1/create");
	        request.setEntity(entity);

	        HttpResponse response = httpClient.execute(request);
	        System.out.println(response.getStatusLine().getStatusCode());		
	}
  	
	@Test(priority=3)
	public void delete_Test()
	{
		Response res=delete("http://dummy.restapiexample.com/api/v1/delete/2");
		System.out.println("------------------------------------"+res.statusCode());
		assertEquals(res.statusCode(),200);
	}
	@Test(priority=4)
	public void put_Test() throws ClientProtocolException, IOException
	{
		String payload = "data={" +
                "\"name\": \"Rohit\", " +
                "\"salary\": \"10000\", " +
                "\"age\": \"22\"" +
                "}";
        StringEntity entity = new StringEntity(payload);

        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPut request = new HttpPut("http://dummy.restapiexample.com/api/v1/update/21");
        request.setEntity(entity);

        HttpResponse response = httpClient.execute(request);
        System.out.println(response.getStatusLine().getStatusCode());	
	}
}



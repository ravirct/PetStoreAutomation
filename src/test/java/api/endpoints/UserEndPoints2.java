package api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.response.Response;

//UserEndPoints.java
//Created for perform Create, Read, Update, Delete requests to the user API

public class UserEndPoints2 {
	
	public static ResourceBundle getURL()
	{
		ResourceBundle routes=ResourceBundle.getBundle("routes");// routes is the properties file in resource folder
		return routes;
	}
	
	public static Response createUser(User payload)
	{
		String post_url=getURL().getString("post_url");
		
		Response res=given()
						.accept("application/json")
						.contentType("application/json")
						.body(payload)		
					.when()
						.post(post_url);
		
					return res;		
	}
	
	public static Response readUser(String userName)
	
	{
		String get_url=getURL().getString("get_url");
		
		Response res=given()
						.pathParam("username", userName)		
					 .when()
							.get(get_url);		
					 return res;
	}
	
public static Response updateUser(User payload, String userName)	
	{
		String update_url=getURL().getString("update_url");
		
		Response res=given()
						.accept("application/json")
						.contentType("application/json")
						.pathParam("username",userName)
						.body(payload)		
					.when()
						.put(update_url);		
					return res;		
	}

public static Response deleteUser(String userName)
{
	String delete_url=getURL().getString("delete_url");
	
	Response res=given()
					.pathParam("username", userName)	
				 .when()
						.delete(delete_url);	
				 return res;
	
}

}

package api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payload.User;
import io.restassured.response.Response;

//UserEndPoints.java
//Created for perform Create, Read, Update, Delete requests to the user API

public class UserEndPoints {
	
	public static Response createUser(User payload)
	
	{
		Response res=given()
						.accept("application/json")
						.contentType("application/json")
						.body(payload)		
					.when()
						.post(Routes.post_url);		
					return res;		
	}
	
	public static Response readUser(String userName)
	
	{
		Response res=given()
						.pathParam("username", userName)		
					 .when()
							.get(Routes.get_url);		
					 return res;
	}
	
public static Response updateUser(User payload, String userName)
	
	{
		Response res=given()
						.accept("application/json")
						.contentType("application/json")
						.pathParam("username",userName)
						.body(payload)		
					.when()
						.put(Routes.update_url);		
					return res;		
	}

public static Response deleteUser(String userName)

{
	Response res=given()
					.pathParam("username", userName)	
				 .when()
						.delete(Routes.delete_url);	
				 return res;
	
}

}

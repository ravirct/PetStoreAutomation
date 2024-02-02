package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.async.AsyncLogger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints2;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests {
	
	Faker faker;
	User userPayload;
	
	public Logger logger; // for logs
	
	@BeforeClass
	public void setupData() {
		
		faker= new Faker();
		userPayload=new User();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().emailAddress());
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		userPayload.setUserStatus(0);	
		
		// logs
		logger=LogManager.getLogger(this.getClass());
		
	}
	
	@Test(priority=1)
	public void testPostUser()
	{
		logger.info("*******************Creating User ************************");
		Response res=UserEndPoints2.createUser(userPayload);		
		res.then().log().all();
		res.then().statusCode(200);
		
		Assert.assertEquals(res.getStatusCode(), 200);
		logger.info("*******************User is created ************************");
	}
	
	@Test(priority=2)
	public void testGetUserByName() {
		logger.info("*******************Reading user info ************************");
		Response res=UserEndPoints2.readUser(this.userPayload.getUsername());		
		res.then().log().all();		
		Assert.assertEquals(res.getStatusCode(), 200);
		logger.info("******************* User info is displayed********************");
	}
	
	@Test(priority=3)
	public void testUpdateUserByName()
	{
		logger.info("*******************Updating user info ************************");
		userPayload.setEmail(faker.internet().emailAddress());
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		Response res=UserEndPoints2.updateUser(userPayload, this.userPayload.getUsername());
		res.then().log().all();
		
		Assert.assertEquals(res.getStatusCode(), 200);
		
		logger.info("*******************User info is updated ************************");
		
	}
		
	@Test(priority=4)
	public void testDeleteUserByName()
	{
		logger.info("*******************Deleting user info ************************");
		Response res=UserEndPoints2.deleteUser(this.userPayload.getUsername());
		Assert.assertEquals(res.getStatusCode(), 200);
		logger.info("******************* User info is deleted ************************");
	}

}


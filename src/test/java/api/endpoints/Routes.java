package api.endpoints;

/*
 * Swagger URI ----> https://petstore.swagger.io/v2
 * Create user ----> https://petstore.swagger.io/v2/user
 * Get User ----> https://petstore.swagger.io/v2/user/{username}
 * Update user ----> https://petstore.swagger.io/v2/user/{username}
 * Delete user ----> https:// petstore.swagger.io/v2/user/{username} 
 */

public class Routes {
	public static String base_url="https://petstore.swagger.io/v2";
	
	//user module
	
	public static String post_url=base_url+"/user";
	public static String get_url=base_url+"/user/{username}";
	public static String update_url=base_url+"/user/{username}";
	public static String delete_url=base_url+"/user/{username}";
	
	//Store module
	
		//Here you will create Store module URL's	
	
	//Pet module
	
		// Here you will create Pet module URL's

}

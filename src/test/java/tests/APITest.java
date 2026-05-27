package tests;

import config.ConfigReader;

import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class APITest {

	private static String token;

	@Test(priority = 1)

	public void testRegisterUserAndExtractToken() {

		String requestBody = "{\n" + "   \"email\": \"" + ConfigReader.getRegisterEmail() + "\",\n" +

				"   \"password\": \"" + ConfigReader.getRegisterPassword() + "\"\n" +

				"}";

		Response response =

				given()

						.header("Content-Type", "application/json")

						.header("x-api-key", ConfigReader.getApiKey())

						.body(requestBody)

						.when()

						.post(ConfigReader.getApiBaseUrl() + ConfigReader.getRegisterEndpoint());

		response.then().statusCode(200);

		token = response.jsonPath().getString("token");

		Assert.assertNotNull(token, "Token should not be null");

		Assert.assertFalse(token.isEmpty(), "Token should not be empty");
	}

	@Test(priority = 2, dependsOnMethods = "testRegisterUserAndExtractToken")

	public void testGetUserDetails() {

		Response response =

				given()

						.header("Authorization", "Bearer " + token)

						.header("x-api-key", ConfigReader.getApiKey())

						.when()

						.get(ConfigReader.getApiBaseUrl() + ConfigReader.getUserEndpoint());

		response.then().statusCode(200);

		int userId = response.jsonPath().getInt("data.id");

		String email = response.jsonPath().getString("data.email");

		Assert.assertEquals(userId, 2, "User ID mismatch");

		Assert.assertTrue(email.contains("reqres.in"), "Email validation failed");
	}
}
package com.bhagya.junit;
import org.junit.Test;
import io.restassured.RestAssured;

public class assignment4 {

	@Test
	public void authvalid() {
		RestAssured.baseURI="https://realogy.atlassian.net";
		RestAssured.given()
		.auth().basic("bhagyashree.khandetod@gmail.com", "Bh@10")
		  .when()
		  .get()
		  .then()
		  .assertThat()
		  .statusCode(200);
	}
	@Test
	public void authinvalid() {
		RestAssured.baseURI="https://realogy.atlassian.net";
		RestAssured.given()
		.auth().basic("1", "@")
		  .when()
		  .get()
		  .then()
		  .assertThat()
		  .statusCode(200);
	}
}

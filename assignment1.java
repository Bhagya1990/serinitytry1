package com.bhagya.junit;
import org.junit.Assert;
import org.junit.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
public class assignment1 {	
	
	//jenkin password: a2a281c76b5f4c0b83bd54294f5dfaed
	@Test
	public void getcountry200() {
		RestAssured.baseURI="http://restcountries.eu/rest/v1/name/India";
		RestAssured.given().when().get().then().log().all().statusCode(200);
	}
	
	@Test
	public void getAltName() {
		RestAssured.baseURI="http://restcountries.eu/rest/v1/name/India";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get();
		 ResponseBody body = response.getBody();
		 String bodyAsString = body.asString();		 
		 Assert.assertEquals(bodyAsString.contains("Republic of India"), true);
		 System.out.println("Republic of India is present in the response");
	}

	@Test
	public void IncorectCountryName() {
		RestAssured.baseURI="http://restcountries.eu/rest/v1/name/xyz";
		RestAssured.given().when().get().then().log().all().statusCode(404);
	}
}

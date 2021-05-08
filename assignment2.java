package com.bhagya.junit;
import java.util.HashMap;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;

public class assignment2 {
	
	@Test
	public void getCapital() {
		RestAssured.baseURI="http://restcountries.eu/rest/v1/name/norway";
		String p1="findAll{it.capital=='";
		String p2="'}.get(0)";
		String capital="Oslo";
		HashMap<String,Object> value= RestAssured.given().when()
				.get().then().log().all().statusCode(200)
				.extract().path(p1+capital+p2);
		System.out.println("values is"+value);		
		assertThat(value,hasValue(capital));
	}
}

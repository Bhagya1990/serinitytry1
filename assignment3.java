package com.bhagya.junit;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.bhagya.model.customerClass;
import com.bhagya.testbase.TestBase;
import io.restassured.http.ContentType;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;

@RunWith(SerenityRunner.class)
public class assignment3 extends TestBase{

	static String firstname="firstname1";
	static String lastname="lastname1";
	static String username="username1";
	static String password="password1";
	static String email="firstname1.lastname1@email.com";
	
	@Test
	public void createCust1() {
		customerClass customer= new customerClass();
		customer.setFirstname(firstname);
		customer.setLastname(lastname);
		customer.setUsername(username);
		customer.setPassword(password);
		customer.setEmail(email);
		
		SerenityRest.given().contentType(ContentType.JSON).log().all()
		.when().body(customer).post()
		.then().log().all().statusCode(201);
	}
	
	@Test
	public void craeteCust2() {
		customerClass customer= new customerClass();
		customer.setFirstname(firstname);
		customer.setLastname(lastname);
		customer.setUsername(username);
		customer.setPassword(password);
		customer.setEmail(email);
		SerenityRest.given().contentType(ContentType.JSON).log().all()
		.when().body(customer).post()
		.then().log().all().statusCode(200);
	}
}

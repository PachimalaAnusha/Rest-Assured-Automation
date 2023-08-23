package pack1;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;



public class SchemaValidation {

	@Test
	public void schema()
	{
		baseURI="https://reqres.in/api";
		given()
			.contentType(ContentType.JSON)
		.when()
			.get("/users?page=2")
		.then()
			.assertThat()
			.body(matchesJsonSchemaInClasspath("schema.json"))
			.statusCode(200);
		
		
	}
	
}

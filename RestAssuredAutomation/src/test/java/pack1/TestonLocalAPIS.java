package pack1;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class TestonLocalAPIS {

//	@Test
	public void get() {
		baseURI = "http://localhost:3000";
		given()
		.when()
			.get("/users")
		.then()
			.statusCode(200).log().all();
	}
//	@Test
	public void post() {
		baseURI="http://localhost:3000";
		JSONObject obj = new JSONObject();
		obj.put("firstName", "Thomas");
		obj.put("lastName", "Edison");
		obj.put("subjectId", 1);
		
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(obj.toJSONString())
		.when()
			.post("/users")
		.then()
			.statusCode(201)
			.log().all();
		}

	//@Test
	public void put() {
		baseURI="http://localhost:3000";
		JSONObject obj = new JSONObject();
		obj.put("firstName", "Albert");
		obj.put("lastName", "Einstein");
		obj.put("subjectId", 1);
		
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(obj.toJSONString())
		.when()
			.put("/users/4")
		.then()
			.statusCode(200);
	}
//	@Test
	public void patch() {
		baseURI="http://localhost:3000";
		JSONObject obj =  new JSONObject();
		obj.put("lastName", "Doe");
		
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(obj.toJSONString())
		.when()
			.patch("/users/8")
		.then()
			.statusCode(200);
	}
	
	@Test
	public void delete() {
		baseURI="http://localhost:3000";
		given()
			.contentType(ContentType.JSON)
		.when()
			.delete("/users/8")
		.then()
			.statusCode(200);
	}


}

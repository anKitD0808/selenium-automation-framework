package com.ankit.qa.api;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class APITest {

    @Test
    public void getUsersTest() {

        System.out.println("Running GET API test...");

        RestAssured.baseURI = "https://reqres.in";

        given()
        .when()
            .get("/api/users?page=2")
        .then()
            .statusCode(200)
            .body("page", equalTo(2));

        System.out.println("GET API test passed");
    }

    @Test
    public void createUserTest() {

        System.out.println("Running POST API test...");

        RestAssured.baseURI = "https://reqres.in";

        String requestBody = "{ \"name\": \"Ankit\", \"job\": \"QA\" }";

        given()
            .header("Content-Type", "application/json")
            .body(requestBody)
        .when()
            .post("/api/users")
        .then()
            .statusCode(201)
            .body("name", equalTo("Ankit"));

        System.out.println("POST API test passed");
    }

    @Test
    public void updateUserTest() {

        System.out.println("Running PUT API test...");

        RestAssured.baseURI = "https://reqres.in";

        String requestBody = "{ \"name\": \"Ankit Updated\", \"job\": \"Senior QA\" }";

        given()
            .header("Content-Type", "application/json")
            .body(requestBody)
        .when()
            .put("/api/users/2")
        .then()
            .statusCode(200)
            .body("name", equalTo("Ankit Updated"));

        System.out.println("PUT API test passed");
    }

    @Test
    public void deleteUserTest() {

        System.out.println("Running DELETE API test...");

        RestAssured.baseURI = "https://reqres.in";

        given()
        .when()
            .delete("/api/users/2")
        .then()
            .statusCode(204);

        System.out.println("DELETE API test passed");
    }
}
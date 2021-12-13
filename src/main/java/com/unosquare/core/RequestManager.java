package com.unosquare.core;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


public class RequestManager {
    public static Response get(String endpoint) {
        return given()
                .log().all()
                .when().log().all()
                .get(endpoint)
                .then().extract().response();
    }
}

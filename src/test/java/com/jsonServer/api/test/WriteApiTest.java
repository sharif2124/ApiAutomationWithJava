package com.jsonServer.api.test;

import com.thedeanda.lorem.LoremIpsum;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class WriteApiTest extends BaseTest{
    @Test
    public void createPostShouldSuccess(){
        String json = "{\n" +
                "  \"title\": \"json-server2\",\n" +
                "  \"author\": \"typicode2\"\n" +
                "}";
        given()
                .header("Content-Type","application/json")
                .body(json)
                .log().uri()
                .log().body()
                .when()
                .post("/posts")
                .then()
                .statusCode(201)
                .log().body();
    }
    @Test
    public void createPostWithHashmapShouldSuccess(){
        HashMap<String,Object> jsHashMap = new HashMap<>();
        jsHashMap.put("title", LoremIpsum.getInstance().getTitle(3));
        jsHashMap.put("author",LoremIpsum.getInstance().getName());

        given()
                .header("Content-Type","application/json")
                .body(jsHashMap)
                .log().uri()
                .log().body()
                .when()
                .post("/posts")
                .then()
                .statusCode(201)
                .log().body();
    }
}

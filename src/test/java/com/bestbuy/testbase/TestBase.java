package com.bestbuy.testbase;

import io.restassured.RestAssured;
import org.junit.BeforeClass;

import static io.restassured.RestAssured.given;

public class TestBase {
    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI= "http://localhost";
        RestAssured.port = 3030;



    }
}

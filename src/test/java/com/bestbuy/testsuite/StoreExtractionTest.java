package com.bestbuy.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import jdk.nashorn.internal.objects.annotations.Where;
import org.junit.BeforeClass;
import org.junit.Test;
import sun.plugin2.os.windows.Windows;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class StoreExtractionTest {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/stores")
                .then().statusCode(200);

    }
    //   1. Extract the limit
    @Test
    public void test001(){
        int limit = response.extract().path("limit");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + limit);
        System.out.println("------------------End of Test---------------------------");
    }
    //2. Extract the total
    @Test
    public void test002(){
        int total = response.extract().path("total");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The total are : " + total);
        System.out.println("------------------End of Test---------------------------");

    }
    //3. Extract the name of 5th store
    @Test
    public void test003(){
        String name  = response.extract().path("data[4].name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The name of 5th store : " + name);
        System.out.println("------------------End of Test---------------------------");

    }
    //4. Extract the names of all the store
    @Test
    public void test004(){
        List<String>name   = response.extract().path("data.name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The names of the all store : " + name);
        System.out.println("------------------End of Test---------------------------");

    }
    //5. Extract the storeId of all the store
    @Test
    public void test005(){
        List<Integer>ListOfId   = response.extract().path("data.services.storeservices.storeId");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The names of the all store : " + ListOfId);
        System.out.println("------------------End of Test---------------------------");

    }

    //6. Print the size of the data list
    @Test
    public void test006(){
        List<Integer>sizeOfdata   = response.extract().path("data");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The size of the data : " + sizeOfdata.size());
        System.out.println("------------------End of Test---------------------------");

    }

    //7. Get all the value of the store where store name = St Cloud
    @Test
    public void test007(){
        List<HashMap<String,?>>value   = response.extract().path("data.findAll{it.name=='St Cloud'}");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("all the value of the store " + value);
        System.out.println("------------------End of Test---------------------------");

    }
    //8. Get the address of the store where store name = Rochester
    @Test
    public void test008(){
        List<HashMap<String,?>>address   = response.extract().path("data.findAll{it.name=='Rochester'}.address");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("all the value of the store " + address);
        System.out.println("------------------End of Test---------------------------");

    }
    //9. Get all the services of 8th store
    @Test
    public void test009(){
        List<HashMap<String,?>>service   = response.extract().path("data[7].services");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("all the services of 8th store" + service);
        System.out.println("------------------End of Test---------------------------");

    }

    //10. Get store services of the store where service name = Windows Store
    @Test
    public void test010(){
      List<HashMap<String,?>>storeService   = response.extract().path("data.service*.find{it.name=='Windows Store'}.storeservices");
     //  List<HashMap<String,?>>storeService     = response.extract().path("data[8].services[5].storeservices");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("store services of the store where service name = Windows Store" +storeService);
        System.out.println("------------------End of Test---------------------------");

    }
    //11. Get all the storeId of all the store
    @Test
    public void test011(){
        List<Integer>storeId   = response.extract().path("data.services.storeservices.storeId");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All the storeId of all the store" +storeId);
        System.out.println("------------------End of Test---------------------------");

    }
    // 12. Get id of all the store
    @Test
    public void test012(){
        List<Integer>Id   = response.extract().path("data.id");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All the Id of all the store" +Id);
        System.out.println("------------------End of Test---------------------------");

    }
    //13. Find the store names Where state = ND
    @Test
    public void test013(){
        List<HashMap<String,?>>storeName  = response.extract().path("data.findAll{it.state=='ND'}.name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The store names Where state = ND" +storeName);
        System.out.println("------------------End of Test---------------------------");

    }
    //14. Find the Total number of services for the store where store name = Rochester
    @Test
    public void test014(){
       int noOfServices  = response.extract().path("data.find{it.name=='Rochester'}.services.size");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Total number of services for the store where store name = Rochester" +noOfServices);
        System.out.println("------------------End of Test---------------------------");

    }
    //15. Find the createdAt for all services whose store name Windows Store”
    @Test
    public void test015(){
        List<HashMap<String,?>>noOfServices  = response.extract().path("data.services*.findAll{it.name=='Windows Store'}.createdAt");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The createdAt for all services whose store name Windows Store" +noOfServices);
        System.out.println("------------------End of Test---------------------------");

    }

    //  16. Find the name of all services Where store name = “Fargo”
    @Test
    public void test016(){
        List<HashMap<String,?>>nameOfServices  = response.extract().path("data.findAll{it.name=='Fargo'}.services.name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("the name of all services Where store name = “Fargo”" +nameOfServices);
        System.out.println("------------------End of Test---------------------------");

    }
    //   17. Find the zip of all the store
    @Test
    public void test017(){
        List<HashMap<String,?>>zipCode  = response.extract().path("data.zip");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The zip of all the store" +zipCode);
        System.out.println("------------------End of Test---------------------------");

    }
    //18. Find the zip of store name = Roseville
    @Test
    public void test018(){
        List<HashMap<String,?>>zipCodeName  = response.extract().path("data.findAll{it.name=='Roseville'}.zip");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println(" The zip of store name = Roseville" +zipCodeName);
        System.out.println("------------------End of Test---------------------------");

    }
    //19. Find the storeservices details of the service name = Magnolia Home Theater
    @Test
    public void test019(){
        List<HashMap<String,?>>storeService  = response.extract().path("data.services*.findAll{it.name=='Magnolia Home Theater'}.storeservices");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println(" The zip of store name = Roseville" +storeService);
        System.out.println("------------------End of Test---------------------------");

    }
    //20. Find the lat of all the stores
    @Test
    public void test020(){
        List<?>latName  = response.extract().path("data.lat");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println(" The zip of store name = Roseville" +latName);
        System.out.println("------------------End of Test---------------------------");

    }
}

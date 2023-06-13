import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class a1_GetReqResUser_1 {


    @Test
    public void test1() {
        given().
                get("https://reqres.in/api/users?page=2").
                then().
                statusCode(200).
                body("data[0].email", equalTo("michael.lawson@reqres.in"));
        //equalTo method is part of static org.hamcrest.Matchers.* package
    }

    @Test
    public void test2() {
        baseURI = "https://reqres.in/api";

        given().
                get("/users?page=2")
                .then()
                .statusCode(200)
                .body("data[0].id", equalTo(7));
        //equalTo method is part of static org.hamcrest.Matchers.* package
    }

}

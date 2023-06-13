import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class a1_GetReqResUser_2 {

    @Test
    public void test() {
        baseURI = "https://reqres.in/api";
        given().
                get("/users?page=2")
                .then()
                .statusCode(200)
                .body("data[0].id", equalTo(7)).
                body("data.last_name", hasItem("Lawson")).
                body("data.last_name", hasItems("Howell", "Fields"));
        //equalTo method is part of static org.hamcrest.Matchers.* package
    }

}

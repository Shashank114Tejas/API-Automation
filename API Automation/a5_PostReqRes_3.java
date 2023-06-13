import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class a5_PostReqRes_3 {


    @Test
    public void postResponseBody() {
        RestAssured.baseURI = "https://reqres.in";
        RequestSpecification httpRequest = RestAssured.given();

        // Setting content type to specify format in which request payload will be sent.
        httpRequest.contentType(ContentType.JSON);

    // We are going to serialize here means converting Java objects to JSON Objects
        Map<String,String> payload = new HashMap<String,String>();
        payload.put("name", "Rajesh");
        payload.put("job", "Manager");

        // Adding body as string
        httpRequest.body(payload);

        // Calling POST method
        Response response = httpRequest.post("/api/users");

        System.out.println("Response Body => " + response.asString());

        // Print response body.
        String responseString = response.prettyPrint();

    }

}

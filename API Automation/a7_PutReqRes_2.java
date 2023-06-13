import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class a7_PutReqRes_2 {


    @Test
    public void putResponseBody() {
        RestAssured.baseURI = "https://reqres.in";
        RequestSpecification httpRequest = RestAssured.given();

        // Setting content type to specify format in which request payload will be sent.
        httpRequest.contentType(ContentType.JSON);

        // We are going to serialize here means converting Java objects to JSON Objects
        Map<String,String> payload = new HashMap<String,String>();
        payload.put("name", "Sachin");
        payload.put("job", "Cricketer");


        // Adding body as string
        httpRequest.body(payload);

        // Calling PUT method
        Response response = httpRequest.put("/api/users/2");


        // Print response body.
        String responseString = response.prettyPrint();

        System.out.println("Pretty Response Body => " + responseString);

        JsonPath jsonPathEvaluator = response.jsonPath();

        System.out.println("Name in Response is : "+ jsonPathEvaluator.get("name"));
        System.out.println("Name in Response is : "+ jsonPathEvaluator.get("job"));
        System.out.println("Name in Response is : "+ jsonPathEvaluator.get("updatedAt"));



    }

}

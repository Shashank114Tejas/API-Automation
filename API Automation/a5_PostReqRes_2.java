import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class a5_PostReqRes_2 {


    @Test
    public void postResponseBody() {
        RestAssured.baseURI = "https://reqres.in";
        RequestSpecification httpRequest = RestAssured.given();

        // Setting content type to specify format in which request payload will be sent.
        httpRequest.contentType(ContentType.JSON);

        String jsonString = "{\n" +
                "    \"name\": \"kumar\",\n" +
                "    \"job\": \"gaurav\"\n" +
                "}";


        // Adding body as string
        httpRequest.body(jsonString);

        // Calling POST method
        Response response = httpRequest.post("/api/users");

        System.out.println("Response Body => " + response.asString());

        // Print response body.
        String responseString = response.prettyPrint();

        System.out.println("Pretty Response Body => " + responseString);

    }

}

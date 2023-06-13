import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class a7_PutReqRes_1 {


    @Test
    public void putResponseBody() {
        RestAssured.baseURI = "https://reqres.in";
        RequestSpecification httpRequest = RestAssured.given();

        // Setting content type to specify format in which request payload will be sent.
        httpRequest.contentType(ContentType.JSON);

        String jsonString = "{\n" +
                "    \"name\": \"Palash\",\n" +
                "    \"job\": \"Guitarist\"\n" +
                "}";


        // Adding body as string
        httpRequest.body(jsonString);

        // Calling PUT method
        Response response = httpRequest.put("/api/users/2");

        System.out.println("Response Body => " + response.asString());

        // Print response body.
        String responseString = response.prettyPrint();

        System.out.println("Pretty Response Body => " + responseString);

    }

}

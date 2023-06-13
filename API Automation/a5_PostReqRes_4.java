import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import postrequestpojos.UserClass;

public class a5_PostReqRes_4 {


    @Test
    public void postResponseBody() {
        RestAssured.baseURI = "https://reqres.in";
        RequestSpecification httpRequest = RestAssured.given();

        // Setting content type to specify format in which request payload will be sent.
        httpRequest.contentType(ContentType.JSON);

//        String jsonString = "{\n" +
//                "    \"name\": \"kumar\",\n" +
//                "    \"job\": \"gaurav\"\n" +
//                "}";

        UserClass requestBody = new UserClass();  // Add jackson databind maven package --resolve can't serialize issue

        requestBody.setName("Kumar");
        requestBody.setJob("Accountant");


        // Adding body as string
        httpRequest.body(requestBody);

        // Calling POST method
        Response response = httpRequest.post("/api/users");

        System.out.println("Response Body => " + response.asString());

        // Print response body.
        String responseString = response.prettyPrint();

        System.out.println("Pretty Response Body => " + responseString);

    }

}

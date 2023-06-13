import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class a5_PostReqRes_1 {


    @Test
    public void postResponseStatus() {
        RestAssured.baseURI = "https://reqres.in";
        RequestSpecification httpRequest = RestAssured.given();

        // Setting content type to specify format in which request payload will be sent.
        httpRequest.contentType(ContentType.JSON);

        String jsonString ="{\n" +
                " \"name\": \"Rakesh Pradhan\",\n" +
                " \"job\": \"Automation Engineer\"\n" +
                "}";
        // Adding body as string
        httpRequest.body(jsonString);

        // Calling POST method
        Response response = httpRequest.post("/api/users");

        System.out.println("Status received => " + response.getStatusLine()); //Print the status response
        System.out.println("Status Code received => " + response.statusCode()); //Print the status response

        Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 201 Created", "Status Line is not correct");
        Assert.assertEquals(response.getStatusCode(), 201, "Status Code is not correct");


    }

}

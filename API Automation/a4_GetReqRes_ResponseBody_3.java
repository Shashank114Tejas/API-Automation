import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class a4_GetReqRes_ResponseBody_3 {

    @Test
    public void GetResponseBody() {
        RestAssured.baseURI = "https://reqres.in";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/api/unknown");

        ResponseBody body = response.getBody(); //Get the response body
        System.out.println("Response Body is: " + body.asString());
        // By using this we can have the response as string

        // First get the JsonPath object instance from the Response interface
        JsonPath jsonPathEvaluator = response.jsonPath();
        // Then simply query the JsonPath object to get a String value of the node
        String lastName = jsonPathEvaluator.get("data[1].name");

        System.out.println("Name received from Response: " + lastName);
        // Validate the response
        Assert.assertEquals(lastName, "fuchsia rose", "Incorrect Last name received in the Response");
    }


}

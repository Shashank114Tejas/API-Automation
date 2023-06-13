import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class a4_GetReqRes_ResponseBody_4 {

    @Test
    public void GetResponseBody() {
        RestAssured.baseURI = "https://reqres.in";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/api/unknown/2");

        ResponseBody body = response.getBody(); //Get the response body

        JsonPath jsonPathEvaluator = response.jsonPath();

        System.out.println("id received from Response: " + jsonPathEvaluator.get("data.id"));
        System.out.println("name received from Response: " + jsonPathEvaluator.get("data.name"));
        System.out.println("year received from Response: " + jsonPathEvaluator.get("data.year"));
        System.out.println("color received from Response: " + jsonPathEvaluator.get("data.color"));
        System.out.println("pantone_value received from Response: " + jsonPathEvaluator.get("data.pantone_value"));
        // Validate the response
        Assert.assertEquals(jsonPathEvaluator.get("data.name"), "fuchsia rose", "Incorrect Last name received in the Response");
        Assert.assertEquals(jsonPathEvaluator.get("support.url"), "https://reqres.in/#support-heading");
    }


}

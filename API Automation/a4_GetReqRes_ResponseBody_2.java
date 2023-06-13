import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class a4_GetReqRes_ResponseBody_2 {

    @Test 
    public void GetResponseBody() {
        RestAssured.baseURI = "https://reqres.in/api/unknown";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, "");

        ResponseBody body = response.getBody(); //Get the response body
        System.out.println("Response Body is: " + body.asString());
        // By using this we can have the response as string

        Assert.assertEquals(body.asString().contains("cerulean") /*Expected value*/, true /*Actual Value*/, "Response body does not contain cerulean");
        Assert.assertEquals(body.asString().contains("name") /*Expected value*/, true /*Actual Value*/, "Response body does not contain cerulean");

    }




}

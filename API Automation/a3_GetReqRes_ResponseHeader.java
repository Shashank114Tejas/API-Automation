import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class a3_GetReqRes_ResponseHeader {

    @Test
    public void GetStatus() {
        RestAssured.baseURI = "https://reqres.in/api/unknown";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, "");


        String contentType = response.header("Content-Type"); // Access header with a given name. Header = Content-Type
        System.out.println("Content Type Header => " + contentType);
        Assert.assertEquals(contentType, "application/json; charset=utf-8" );
        // Access header with a given name. Header = Server
        String serverType = response.header("Server");
        System.out.println("Server Type Header => " + serverType);
        Assert.assertEquals(serverType /* actual value */, "cloudflare" /* expected value */);

        response.header("Connection");

        Assert.assertEquals(response.header("Connection"), "keep-alive", "Connection value is not correct");

    }




}

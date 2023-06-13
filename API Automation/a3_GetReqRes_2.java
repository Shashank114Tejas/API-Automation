import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class a3_GetReqRes_2 {


    @Test //This annotation will mark this as test at compile time
    public void GetStatus() {
        RestAssured.baseURI = "https://reqres.in/api/unknown/wrong"; // Set the wrong base URL.
        RequestSpecification httpRequest = RestAssured.given();
        //Use RequestSpecification object to get the specifications of the request to be sent to server

        Response response = httpRequest.request(Method.GET, "");
        //Mention the method type here, As it is a GET Request so no parameters

        System.out.println("Status received => " + response.getStatusLine()); //Print the status response
        System.out.println("Status Code received => " + response.statusCode()); //Print the status response

        Assert.assertEquals(response.statusCode(), 200, "Status Code is not correct");
    }



}

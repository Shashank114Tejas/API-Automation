import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class a8_DeleteReqRes_1 {

    @Test
    public void deleteStatus() {
        RestAssured.baseURI = "https://reqres.in";
        RequestSpecification httpRequest = RestAssured.given();


        Response response = httpRequest.delete("/api/users/2");


        System.out.println("Status received => " + response.getStatusLine()); //Print the status response
        System.out.println("Status Code received => " + response.statusCode()); //Print the status response

        Assert.assertEquals(response.statusCode(), 204, "Status Code is not correct");
    }




}

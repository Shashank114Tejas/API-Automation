import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class a8_DeleteReqRes_2 {

    @Test
    public void deleteStatus() {
        RestAssured.baseURI = "https://reqres.in";
        RequestSpecification httpRequest = RestAssured.given();


        Response response = httpRequest.delete("/api/users/2");

        System.out.println("Status Code received => " + response.statusCode()); //Print the status response

        response.prettyPrint();
    }




}

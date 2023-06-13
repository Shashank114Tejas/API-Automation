import getresponsepojo.Example;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import putrequestpojos.UsersRequest;
import putresponsepojos.UsersResponse;

public class a7_PutReqRes_4_Pojo_RequestAndResponse {


    @Test
    public void putResponseBody() {
        RestAssured.baseURI = "https://reqres.in";
        RequestSpecification httpRequest = RestAssured.given();

        // Setting content type to specify format in which request payload will be sent.
        httpRequest.contentType(ContentType.JSON);

        UsersRequest usersRequest = new UsersRequest("Rahul", "Batsman");


        // Adding body as string
        httpRequest.body(usersRequest);

        // Calling PUT method
        Response response = httpRequest.put("/api/users/2");


        // Print response body.
        String responseString = response.prettyPrint();

        System.out.println("Pretty Response Body => " + responseString);

//        JsonPath jsonPathEvaluator = response.jsonPath();
//
//        System.out.println("Name in Response is : "+ jsonPathEvaluator.get("name"));
//        System.out.println("Name in Response is : "+ jsonPathEvaluator.get("job"));
//        System.out.println("Name in Response is : "+ jsonPathEvaluator.get("updatedAt"));

        ResponseBody output = response.getBody();

        UsersResponse myData = output.as(UsersResponse.class);

        System.out.println("Response is : \n"+ myData.toString());



    }

}

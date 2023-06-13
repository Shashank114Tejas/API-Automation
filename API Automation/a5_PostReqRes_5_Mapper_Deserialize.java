import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import postrequestpojos.UserClass;
import postresponsepojos.UserClassResponse;

public class a5_PostReqRes_5_Mapper_Deserialize {

private static final ObjectMapper myMapper= new ObjectMapper();
    @Test
    public void postResponseBody() throws JsonProcessingException {
        RestAssured.baseURI = "https://reqres.in";
        RequestSpecification httpRequest = RestAssured.given();

        httpRequest.contentType(ContentType.JSON);

        UserClass requestBody = new UserClass();  // Add jackson databind maven package --resolve can't serialize issue

        requestBody.setName("Kumar");
        requestBody.setJob("Accountant");

        String inJson = myMapper.writeValueAsString(requestBody);
        // Adding body as string
        httpRequest.body(inJson);

        // Calling POST method
        Response response = httpRequest.post("/api/users");

        ResponseBody myResponseBodyJson = response.getBody();

        UserClassResponse myResponseBodyJavaObject = myResponseBodyJson.as(UserClassResponse.class);

        System.out.println("Response Body in Java Object => \n" + myResponseBodyJavaObject);

        System.out.println("Response Body in Java Object => \n" + myResponseBodyJavaObject.toString());


        System.out.println(myResponseBodyJavaObject.getId());
        System.out.println(myResponseBodyJavaObject.getJob());
        System.out.println(myResponseBodyJavaObject.getName());
        System.out.println(myResponseBodyJavaObject.getCreatedAt());

        Assert.assertEquals(myResponseBodyJavaObject.getName(), "Kumar", "Response Name is not correct");

    }

}

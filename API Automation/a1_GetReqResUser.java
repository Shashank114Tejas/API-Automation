import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;



public class a1_GetReqResUser {


    @Test
    public void test() {
        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
        System.out.println("Status Code: " + response.statusCode());
        System.out.println("Whole Response: " + response.asString());
        System.out.println("Response Body: " + response.getBody().asString());
        System.out.println("Status Line: " + response.statusLine());
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200, "Status Code is not correct");

        Assert.assertTrue(response.statusLine().contains("OK"), "Status line doesn't contain OK with it");

        boolean flag= response.statusLine().contains("OK");
        Assert.assertTrue(flag, "Status line doesn't contain OK with it");

        int flag1= response.statusLine().compareToIgnoreCase("ok");
        Assert.assertEquals(flag1, -7, "Status line doesn't contain OK with it");

    }

}

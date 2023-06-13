import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class a3_GetReqRes_ResponseHeaders {

    @Test
    public void GetStatus() {
        RestAssured.baseURI = "https://reqres.in";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/api/unknown");

        // Get all the headers and then iterate over allHeaders to print each header
        Headers allHeaders = response.headers();
        // Iterate over all the Headers
        for (Header header : allHeaders) {
            System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
            if (header.getName().equalsIgnoreCase("Content-Type")) {
                Assert.assertEquals(header.getValue(), "application/json; charset=utf-8");
            }
            if (header.getName().equalsIgnoreCase("Server")) {
                Assert.assertEquals(header.getValue(), "cloudflare");
            }
            if (header.getName().equalsIgnoreCase("Connection")) {
                Assert.assertEquals(header.getValue(), "keep-alive");
            }

        }


    }

}

package baseurl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static utilities.Authentication.generateToken;

public class MedunnaBaseUrl {


    public static RequestSpecification spec;

    public static void setUp(){
        spec = new RequestSpecBuilder()
                .setBaseUri("https://medunna.com")
                .setContentType(ContentType.JSON)
                .addHeader("Authorization","Bearer "+ generateToken())
                .build();
    }

}

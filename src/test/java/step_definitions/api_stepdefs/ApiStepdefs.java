package step_definitions.api_stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import pojos.RoomPojo;

import java.util.List;

import static baseurl.MedunnaBaseUrl.spec;
import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;
import static step_definitions.ui_stepdefs.MedunnaRoomStepDefs.roomNumber;

public class ApiStepdefs {
    int roomId;
    @Given("Oda ID bilgisi alinir")
    public void odaIDBilgisiAlinir() {
    spec.pathParams("first","api","second","rooms")
            .queryParam("sort","createdDate,desc");

    Response response = given(spec).when().get("{first}/{second}");
    List<Integer> roomIdList = response.jsonPath().getList("findAll{it.roomNumber=="+roomNumber+"}.id");
    roomId = roomIdList.get(0);
        System.out.println("roomIdList = " + roomIdList);

    }

    RoomPojo ecpectedData;
    Response response;
    @When("Get request gonderilir")
    public void getRequestGonderilir() {
    spec.pathParams("first","api","second","rooms","third",roomId);

    ecpectedData = new RoomPojo(roomNumber,"SUITE",true,123.00,"End To End Test icin olusturulmustur");

    response = given(spec).when().get("{first}/{second}/{third}");

    }

    @Then("Veriler dogrulanir")
    public void verilerDogrulanir() {
    RoomPojo actualData = response.as(RoomPojo.class);

    assertEquals(200,response.statusCode());
    assertEquals(ecpectedData.getRoomNumber(),actualData.getRoomNumber());
    assertEquals(ecpectedData.isStatus(),actualData.isStatus());
    assertEquals(ecpectedData.getPrice(),actualData.getPrice());
    assertEquals(ecpectedData.getDescription(),actualData.getDescription());
    }
}

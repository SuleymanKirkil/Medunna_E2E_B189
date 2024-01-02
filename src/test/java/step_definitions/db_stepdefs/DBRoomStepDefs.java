package step_definitions.db_stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.sql.*;

import static junit.framework.TestCase.assertEquals;
import static step_definitions.api_stepdefs.ApiRoomStepdefs.expectedData;
import static step_definitions.ui_stepdefs.MedunnaRoomStepDefs.roomNumber;

public class DBRoomStepDefs {
    Connection connection;
    Statement statement;
    ResultSet resultSet;
    @Given("Admin Connect to the Data Base")
    public void adminConnectToTheDataBase() throws SQLException {
       connection = DriverManager.getConnection("jdbc:postgresql://medunna.com:5432/medunna_db_v2","select_user","Medunna_pass_@6");

    }

    @When("send query for created room")
    public void sendQueryForCreatedRoom() throws SQLException {
        statement = connection.createStatement();
        resultSet = statement.executeQuery("SELECT * FROM room WHERE room_number = "+ roomNumber);
    }

    @Then("validates created room from result set")
    public void validatesCreatedRoomFromResultSet() throws SQLException {

        resultSet.next();
        assertEquals(expectedData.getRoomNumber(),resultSet.getInt("room_number"));
        assertEquals(expectedData.getRoomType(),resultSet.getString("room_type"));
        assertEquals(expectedData.getDescription(),resultSet.getString("description"));
        assertEquals(expectedData.getPrice(),Double.valueOf(resultSet.getString("price")));
        assertEquals(expectedData.getPrice() + "0",resultSet.getString("price"));

    }
}

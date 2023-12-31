package step_definitions.ui_stepdefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.Select;
import pages.MedunnaHomePage;
import pages.MedunnaRoomPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class MedunnaRoomStepDefs {
    MedunnaHomePage medunnaHomePage = new MedunnaHomePage();
    MedunnaRoomPage medunnaRoomPage = new MedunnaRoomPage();
    public static int roomNumber;
    public static String roomId;

    @When("Items&Titles secenegine tiklanir")
    public void ıtems_titles_secenegine_tiklanir() {
        medunnaHomePage.itemsdAndTitles.click();
    }

    @When("Room secenegine tiklanir")
    public void room_secenegine_tiklanir() {
        medunnaHomePage.roomOption.click();
    }

    @When("Create a new Room butonuna tiklanir")
    public void create_a_new_room_butonuna_tiklanir() {
        medunnaRoomPage.createANewRoomButton.click();
    }

    @When("Room Number kutusuna bir oda_no girilir")
    public void room_number_kutusuna_bir_girilir() {
        roomNumber = Faker.instance().number().numberBetween(100000, 1000000);
        medunnaRoomPage.roomNumberInput.sendKeys(roomNumber + "");
    }

    @When("Room Type menusunden SUITE secenegi secilir")
    public void room_type_menusunden_suıte_secenegi_secilir() {
        new Select(medunnaRoomPage.roomTypeDropDown).selectByIndex(3);
    }

    @When("Status kontrol kutusuna tiklanir")
    public void status_kontrol_kutusuna_tiklanir() {
        medunnaRoomPage.statusCheckbox.click();
    }

    @When("Price kutusuna {string} degeri girilir")
    public void price_kutusuna_degeri_girilir(String fiyat) {
        medunnaRoomPage.priceInput.sendKeys(fiyat);
    }

    @When("Description kutusuna bir {string} girilir")
    public void description_kutusuna_bir_girilir(String aciklama) {
        medunnaRoomPage.descriptionInput.sendKeys(aciklama);
    }

    @When("Save butonuna tiklanir")
    public void save_butonuna_tiklanir() throws InterruptedException {
        ReusableMethods.click(medunnaRoomPage.saveSubmitButton);
        ReusableMethods.visibleWait(medunnaRoomPage.alert, 5);
        roomId = medunnaRoomPage.alert.getText().replaceAll("[^0-9]", "");
    }

    @When("Uygulama kapatilir")
    public void uygulama_kapatilir() {
        Driver.closeDriver();
    }
}

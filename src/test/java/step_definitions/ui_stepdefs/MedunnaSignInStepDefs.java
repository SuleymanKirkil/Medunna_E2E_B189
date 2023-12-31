package step_definitions.ui_stepdefs;

import io.cucumber.java.en.*;
import pages.MedunnaHomePage;
import pages.MedunnaLoginPage;
import utilities.ConfigReader;
import utilities.Driver;

public class MedunnaSignInStepDefs {
    MedunnaHomePage medunnaHomePage = new MedunnaHomePage();
    MedunnaLoginPage medunnaLoginPage = new MedunnaLoginPage();

    @Given("Medunna web sitesine gidilir")
    public void medunnaWebSitesineGidilir() {
        Driver.getDriver().get(ConfigReader.getProperty("baseUrl"));
    }

    @When("User simgesine tiklanir")
    public void user_simgesine_tiklanir() {
        medunnaHomePage.userIcon.click();
    }

    @When("Sign in secenegine tiklanir")
    public void sign_in_secenegine_tiklanir() {
        medunnaHomePage.signInOption.click();
    }

    @When("Username kutusuna kullanici adi girilir")
    public void username_kutusuna_kullanici_adi_girilir() {
        medunnaLoginPage.usernameInput.sendKeys(ConfigReader.getProperty("medunna_username"));
    }

    @When("Password kutusuna password girilir")
    public void password_kutusuna_password_girilir() {
        medunnaLoginPage.passwordInput.sendKeys(ConfigReader.getProperty("medunna_password"));
    }

    @When("Sign in butonuna tiklanir")
    public void sign_in_butonuna_tiklanir() {
        medunnaLoginPage.signInSubmitButton.click();
    }


}

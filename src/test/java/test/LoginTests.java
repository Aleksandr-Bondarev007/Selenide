package test;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.AfterTest;
import pages.LoginPage;
import browser.SelenideConfiguration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ProjectPage;

import java.util.Optional;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class LoginTests {

    LoginPage loginPage;
    ProjectPage projectPage;

    @BeforeMethod
    public void setUp() {

        String browser = Optional.ofNullable(System.getProperty("browser")).orElse("chrome");
        SelenideConfiguration.configureBrowser(browser);

        open("login");
        loginPage = new LoginPage();
        projectPage = new ProjectPage();
    }

    @Test
    public void loginUnSuccessful() {

        String errorMessage = "These credentials do not match our records.";
        String email = "a.bondarev@qualitica.ru";
        String password = "qwerty";

        loginPage.login(email, password);
        loginPage.errorMessage.shouldBe(visible).shouldHave(exactText(errorMessage));
    }

    @Test
    public void loginSuccessful(){

        String email = "a.bondarev@qualitica.ru";
        String password = "Q65YhII0077";

        loginPage.login(email, password);
        Selenide.closeWebDriver();
    }
}
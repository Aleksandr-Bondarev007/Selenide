package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

    public SelenideElement emailInput = $("#inputEmail");
    public SelenideElement passwordInput = $x("//input[@type='password']");
    public SelenideElement loginButton = $(By.id("btnLogin"));
    public SelenideElement errorMessage = $x("//div[contains(@class,'error')]/div");

    String titleText = "Projects";
    ProjectPage projectPage = new ProjectPage();

    public void login(String email, String password) {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        loginButton.click();
        projectPage.titleText.shouldBe(visible).shouldHave(exactText(titleText));
    }
}

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideConfig;
import com.codeborne.selenide.selector.ByText;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;


public class Selenide {

    @BeforeMethod
    public void setUp(){
    }

    @Test
    public void firstTest(){

        String titleText = "Projects";

        open("login");
        $("#inputEmail").sendKeys("a.bondarev@qualitica.ru");
        $("#inputPassword").sendKeys("Q65YhII0077");

        $("#btnLogin").click();
        $x("//h1").shouldBe(visible).shouldHave(text(titleText));
        $("#createButton").shouldBe(visible);

    }
}

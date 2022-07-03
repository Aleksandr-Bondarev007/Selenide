package pages;

import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ProjectPage {

    public SelenideElement titleText =  $x("//h1");
    public SelenideElement createButton =  $("#createButton");
    public SelenideElement titleNewProject =  $x("//h1");

    public void clickCreateButton(){
        createButton.click();
    }



}


package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ProjectRepositoryPage {

    public SelenideElement titleNameProjectText = $x("//div[@class='sqabXr']");
    public SelenideElement createSuiteButton = $("#create-suite-button");
    public SelenideElement suiteName = $("#name");
    public SelenideElement successMessage = $x("//span[@class='OL6rtE']");
    public SelenideElement saveSuiteButton = $("#save-suite-button");
    public SelenideElement settingsButton =  $x("//span[@class='nbWgel'][contains(text(),'Settings')]");
    public SelenideElement createCaseButton =  $("#create-case-button");



}

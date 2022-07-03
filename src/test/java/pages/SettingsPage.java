package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SettingsPage {

    public SelenideElement deleteProjectButton =  $x("//a[@class='btn btn-cancel']");
    public SelenideElement confirmDeleteProjectButton =  $x("//button[@class='btn btn-cancel']");
    ProjectRepositoryPage projectRepositoryPage;
    SettingsPage settingsPage;

    public void deleteProject(){
        projectRepositoryPage = new ProjectRepositoryPage();
        settingsPage = new SettingsPage();

        projectRepositoryPage.settingsButton.click();
        settingsPage.deleteProjectButton.click();
        settingsPage.confirmDeleteProjectButton.click();
    }
}

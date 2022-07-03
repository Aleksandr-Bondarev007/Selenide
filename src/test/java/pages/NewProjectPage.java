package pages;

import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class NewProjectPage {

    public SelenideElement titleNewProject =  $x("//h1");
    public SelenideElement fieldName =  $("#inputTitle");
    public SelenideElement fieldCode =  $("#inputCode");
    public SelenideElement fieldDescription =  $("#inputDescription");
    public SelenideElement privateAccessTypeCheckbox =  $("#private-access-type");
    public SelenideElement createProjectButton =  $x("//button[@type='submit']");

    NewProjectPage newProjectPage;
    ProjectRepositoryPage projectRepositoryPage;



    public void clickCreateNewProjectButton(){
        createProjectButton.click();
    }
    public void createNewProject(){

        newProjectPage = new NewProjectPage();
        projectRepositoryPage = new ProjectRepositoryPage();
        Faker faker = new Faker();

        String titleNewProject = "New Project";
        String projectName = faker.name().fullName();
        String projectCode = faker.code().asin();
        String description = "This is a test project created with selenide";

        newProjectPage.titleNewProject.shouldBe(visible).shouldHave(exactText(titleNewProject));
        newProjectPage.fieldName.sendKeys(projectName);
        newProjectPage.fieldCode.sendKeys(projectCode);
        newProjectPage.fieldDescription.sendKeys(description);
        newProjectPage.privateAccessTypeCheckbox.isSelected();
        newProjectPage.clickCreateNewProjectButton();
        projectRepositoryPage.titleNameProjectText.shouldBe(visible).shouldBe(exactText(projectName));
    }
}

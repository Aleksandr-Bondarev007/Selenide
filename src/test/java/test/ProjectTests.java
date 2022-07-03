package test;

import browser.SelenideConfiguration;
import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import java.util.Optional;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;

public class ProjectTests {

        LoginPage loginPage;
        ProjectPage projectPage;
        NewProjectPage newProjectPage;
        ProjectRepositoryPage projectRepositoryPage;
        SettingsPage settingsPage;
        CasePage casePage;
        Faker faker = new Faker();
        String email = "a.bondarev@qualitica.ru";
        String password = "Q65YhII0077";
        String titleNewProject = "New Project";

        @BeforeMethod
        public void setUp() {

            String browser = Optional.ofNullable(System.getProperty("browser")).orElse("chrome");
            SelenideConfiguration.configureBrowser(browser);

            open("login");
            loginPage = new LoginPage();
            projectPage = new ProjectPage();
            newProjectPage = new NewProjectPage();
            projectRepositoryPage = new ProjectRepositoryPage();
            settingsPage = new SettingsPage();
            casePage = new CasePage();

        }
        @Test
        public void createProject(){

            String projectName = faker.name().fullName();
            String projectCode = faker.code().asin();
            String description = "This is a test project created with selenide";

            loginPage.login(email, password);
            projectPage.clickCreateButton();
            newProjectPage.titleNewProject.shouldBe(visible).shouldHave(exactText(titleNewProject));
            newProjectPage.fieldName.sendKeys(projectName);
            newProjectPage.fieldCode.sendKeys(projectCode);
            newProjectPage.fieldDescription.sendKeys(description);
            newProjectPage.privateAccessTypeCheckbox.isSelected();
            newProjectPage.clickCreateNewProjectButton();
            projectRepositoryPage.titleNameProjectText.shouldBe(visible).shouldBe(exactText(projectName));
            settingsPage.deleteProject();
            Selenide.closeWebDriver();
        }

        @Test
        public void createProjectWithSuite(){

            String suiteName = faker.name().name();
            String successMessageText = "Suite was successfully created.";

            loginPage.login(email, password);
            projectPage.clickCreateButton();
            newProjectPage.titleNewProject.shouldBe(visible).shouldHave(exactText(titleNewProject));
            newProjectPage.createNewProject();
            projectRepositoryPage.createSuiteButton.click();
            projectRepositoryPage.suiteName.sendKeys(suiteName);
            projectRepositoryPage.saveSuiteButton.click();
            projectRepositoryPage.successMessage.shouldBe(visible).shouldHave(exactText(successMessageText));
            settingsPage.deleteProject();
            Selenide.closeWebDriver();
        }
        @Test
        public void createProjectWithSuiteAndCase(){

            String suiteName = faker.name().name();
            String successMessageText = "Suite was successfully created.";
            String titleCase = faker.color().name();
            String successCaseText = "Test case was created successfully!";

            loginPage.login(email, password);
            projectPage.clickCreateButton();
            newProjectPage.titleNewProject.shouldBe(visible).shouldHave(exactText(titleNewProject));
            newProjectPage.createNewProject();
            projectRepositoryPage.createSuiteButton.click();
            projectRepositoryPage.suiteName.sendKeys(suiteName);
            projectRepositoryPage.saveSuiteButton.click();
            projectRepositoryPage.successMessage.shouldBe(visible).shouldHave(exactText(successMessageText));
            projectRepositoryPage.createCaseButton.click();
            casePage.titleField.sendKeys(titleCase);
            casePage.saveCase.click();
            projectRepositoryPage.successMessage.shouldBe(visible).shouldHave(exactText(successCaseText));
            settingsPage.deleteProject();
            Selenide.closeWebDriver();
        }

}



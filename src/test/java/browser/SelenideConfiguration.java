package browser;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;

import java.util.Optional;

import static com.codeborne.selenide.Browsers.*;
import static com.codeborne.selenide.Selenide.open;

public class SelenideConfiguration {

    public static void configureBrowser(String browser) {
        setUpBasicConfigure();

        switch (browser) {
            case "edge":
                Configuration.browser = EDGE;
                break;
            case "opera":
                Configuration.browser = OPERA;
                break;
            default:
                Configuration.browser = CHROME;
                break;
        }
    }

    public static void setUpBasicConfigure() {
        Configuration.baseUrl = "https://qase.io/";
        Configuration.headless = false;
        Configuration.timeout = 10000;
        Configuration.screenshots = true;
    }


}
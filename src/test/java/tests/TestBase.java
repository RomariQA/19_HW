package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import config.TestsConfiguration;
import config.helpers.ConfigReader;
import config.helpers.WebConfig;
import helpers.Attach;

import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Selenide.closeWebDriver;


public class TestBase {

    private static final WebConfig webConfig = ConfigReader.Instance.read();

    @BeforeAll
    static void beforeAll(){

        Configuration.pageLoadStrategy = "eager";

        TestsConfiguration testsConfiguration = new TestsConfiguration(webConfig);
        testsConfiguration.apiConfig();
        testsConfiguration.webConfig();

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        if (!Configuration.browser.equals("firefox")) {
            Attach.pageSource();
            Attach.browserConsoleLogs();
        }
        Attach.addVideo();
        closeWebDriver();
    }
}

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;
import steps.MyDiarySteps;
import steps.RateYourHappinessSteps;

public class BaseTest {

    LoginPage loginPage;
    FeedPage feedPage;
    MoodUpdatedModalPage moodUpdatedModalPage;
    MyDiaryPage myDiaryPage;
    RateYourHappinessModalPage rateYourHappinessModalPage;
    HomePage homePage;
    RateYourHappinessSteps rateYourHappinessSteps;
    MyDiarySteps myDiarySteps;

    @BeforeMethod
    public void init() {
        Configuration.browser = "chrome";
        Configuration.timeout = 15000;
        Configuration.holdBrowserOpen = true;
        Configuration.headless = false;
        loginPage = new LoginPage();
        feedPage = new FeedPage();
        moodUpdatedModalPage = new MoodUpdatedModalPage();
        myDiaryPage = new MyDiaryPage();
        rateYourHappinessModalPage = new RateYourHappinessModalPage();
        homePage = new HomePage();
        rateYourHappinessSteps = new RateYourHappinessSteps();
        myDiarySteps = new MyDiarySteps();
    }


    @AfterMethod
    public void closeBrowser() {
        WebDriverRunner.getWebDriver().quit();
    }
}

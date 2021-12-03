package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class FeedPage {

    public static final String UPDATE_MOOD_BTN_CSS = "#LinkUpdate";
    public static final By ACCOUNT_DROP_DOWN = By.xpath("//a[@class='dropdown-toggle']//descendant::span[contains(text(), 'Account')]");
    public static final By LOGOUT_BTN = By.xpath("//*[@id='Settings']//*[text()='Logout']");

    public FeedPage waitForMoodBtnVisible() {
        $(UPDATE_MOOD_BTN_CSS).shouldBe(Condition.visible, Duration.ofSeconds(10));
        return this;
    }

    public RateYourHappinessModalPage clickUpdateBtn() {
        $(UPDATE_MOOD_BTN_CSS).click();
        return new RateYourHappinessModalPage();
    }

    public HomePage clickLogoutBtn() {
        $(ACCOUNT_DROP_DOWN).click();
        $(LOGOUT_BTN).click();
        return new HomePage();
    }
}

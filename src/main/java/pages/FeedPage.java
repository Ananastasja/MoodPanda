package pages;

import com.codeborne.selenide.Condition;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class FeedPage {

    public static final String UPDATE_MOOD_BTN_CSS = "#LinkUpdate";

    public FeedPage waitForMoodBtnVisible() {
        $(UPDATE_MOOD_BTN_CSS).shouldBe(Condition.visible, Duration.ofSeconds(10));
        return this;
    }

    public RateYourHappinessModalPage clickUpdateBtn() {
        $(UPDATE_MOOD_BTN_CSS).click();
        return new RateYourHappinessModalPage();
    }
}

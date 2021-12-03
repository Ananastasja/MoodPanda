package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class RateYourHappinessModalPage {

    public static final String SLIDER_CSS = ".ui-slider-handle";
    public static final String UPDATE_MOOD_BTN = ".btn-primary.ButtonUpdate";
    public static final By CALENDER_ICON = By.xpath("//*[@class='ui-datepicker-trigger']");
    public static final By MONTH_DROP_DOWN = By.xpath("//*[@class='ui-datepicker-month']");
    public static final By YEAR_DROP_DOWN = By.xpath("//*[@class='ui-datepicker-year']");
    public static final String DAY_OF_MONTH = "//tbody//a[contains(text(), '%s')]";


    public RateYourHappinessModalPage updateMood(int moodValue) {
        $(SLIDER_CSS).click();
        int defaultMoodValue = 5;
        Keys direction = null;
        if (moodValue > defaultMoodValue) {
            direction = Keys.ARROW_RIGHT;
        } else if (moodValue < defaultMoodValue) {
            direction = Keys.ARROW_LEFT;
        }
        if (moodValue!=defaultMoodValue) {
            for (int i = 0; i < Math.abs(moodValue - defaultMoodValue); i++) {
                $(SLIDER_CSS).sendKeys(direction);
            }
        }
        return this;
    }

    public MoodUpdatedModalPage clickUpdateMoodBtn() {
        $(UPDATE_MOOD_BTN).click();
        return new MoodUpdatedModalPage();
    }

    public RateYourHappinessModalPage selectDateFromCalender(String month, String year, String day) {
        $(CALENDER_ICON).click();
        $(MONTH_DROP_DOWN).click();
        $(MONTH_DROP_DOWN).selectOptionContainingText(month);
        $(YEAR_DROP_DOWN).click();
        $(YEAR_DROP_DOWN).selectOptionByValue(year);
        $(By.xpath(String.format(DAY_OF_MONTH, day))).click();
        return this;
    }
}

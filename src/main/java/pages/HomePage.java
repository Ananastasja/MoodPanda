package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    public static final By START_BTN = By.xpath("//*[contains(@class, 'brand-name-subtext')]//*[contains(text(), 'Start')]");

    public boolean isStartBtnVisible() {
        return $(START_BTN).isDisplayed();
    }
}

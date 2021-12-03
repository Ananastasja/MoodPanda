package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MyDiaryPage {

    public static final By BADGE_MOOD = By.xpath("//*[contains(@class, 'm1 ')]//h5//span[contains(@class,'pull-right')]");
    public static final String REPLY_FIELD = "#mcr1";
    public static final By REPLY_BTN = By.xpath("(//a[contains(text(),'Reply')])[1]");
    public static final By REPLY_MESSAGE = By.xpath("//*[@class='media-body-comment-tag ']/p");
    public static final By SEND_HUG_BTN = By.xpath("//*[contains(@class, 'btnhugs1 ')]");
    public static final By HUG_SENT_MESSAGE = By.xpath("//*[@id='media-comment0']//a");
    public static final By DATE_TEXT = By.xpath("//*[contains(@class, 'm1 ')]//*[contains(@class, 'xs-8')]");

    public String getBadgeMoodNumber() {
        return $(BADGE_MOOD).getText();
    }

    public MyDiaryPage enterReplyIntoField(String message) {
        $(REPLY_FIELD).sendKeys(message);
        $(REPLY_BTN).click();
        return this;
    }

    public String getReplyMessage() {
        return $(REPLY_MESSAGE).getText();
    }

    public MyDiaryPage clickSendHugBtn() {
        $(SEND_HUG_BTN).click();
        return this;
    }

    public boolean isHugSendMessageDisplayed() {
        return $(HUG_SENT_MESSAGE).isDisplayed();
    }

    public String getDateText() {
        return $(DATE_TEXT).getText();
    }
}

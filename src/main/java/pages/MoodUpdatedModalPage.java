package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MoodUpdatedModalPage {

    public static final String GO_TO_DIARY_BTN = ".btn-ssm";
    public static final By UPDATED_MOOD_SUCCESS_TEXT = By.xpath("//*[@class='modal-body']/p");
    //TODO: when i write public static final String UPDATED_MOOD_SUCCESS_TEXT = "//*[@class='modal-body']/p" the first "/" marked as unexpected token
    public static final By MOOD_UPDATED_TEXT = By.xpath("//*[contains(text(), 'Mood Updated')]");

    public String getSuccessfullyUpdatedMoodText() {
        return $(MOOD_UPDATED_TEXT).innerText().trim();
    }

    public MyDiaryPage clickGoToDiaryBtn() {
        $(GO_TO_DIARY_BTN).click();
        return new MyDiaryPage();
    }
}

import org.testng.Assert;
import org.testng.annotations.Test;

public class MoodPandaTest extends BaseTest {

    private static final String EXPECTED_UPDATED_MOOD_TEXT = "Mood Updated";
    private static final String MOOD_BADGE = "1";
    private static final String REPLY_MESSAGE = "Hola";

    @Test(description = "Login and updating mood via Update Mood btn > verifying message about successful update")
    public void loginAndVerifyMoodUpdatedTest() {
        myDiarySteps.loginAndUpdateMood("tms_qa08onl_3@mailinator.com", "123456", 1);
        Assert.assertEquals(moodUpdatedModalPage.getSuccessfullyUpdatedMoodText(), EXPECTED_UPDATED_MOOD_TEXT);
    }

    @Test(description = "verifying updated mood badge with the last one displayed on My Diary page")
    public void verifyMoodUpdatedBadgeTest() {
        myDiarySteps.loginAndUpdateMood("tms_qa08onl_3@mailinator.com", "123456", 1);
        Assert.assertEquals(myDiaryPage.getBadgeMoodNumber(), MOOD_BADGE);
    }

    @Test(description = "entering reply message and verifying that expected message is displayed")
    public void verifyReplyTest() {
        myDiarySteps.loginAndUpdateMood("tms_qa08onl_3@mailinator.com", "123456", 1);
        myDiaryPage.enterReplyIntoField(REPLY_MESSAGE);
        Assert.assertEquals(myDiaryPage.getReplyMessage(), REPLY_MESSAGE);
    }

    @Test(description = "sending a hug to a user and verifying that it is sent")
    public void sendHugAndVerifyTest() {
        myDiarySteps.loginAndUpdateMood("tms_qa08onl_3@mailinator.com", "123456", 1);
        myDiaryPage.clickSendHugBtn();
        Assert.assertTrue(myDiaryPage.isHugSendMessageDisplayed());
    }

    @Test(description = "Selecting a date from calender and verifying it on Diary page")
    public void setDateFromCalenderAndVerifyTest() {
        rateYourHappinessSteps.loginAndUpdateMood("tms_qa08onl_3@mailinator.com", "123456", 1);
        rateYourHappinessModalPage.selectDateFromCalender("Nov", "2021", "26")
                .clickUpdateMoodBtn()
                .clickGoToDiaryBtn();
        Assert.assertEquals(myDiaryPage.getDateText(), "4 days ago");
    }

    @Test(description = "Logging in and out")
    public void logOut() {
        loginPage.openPage()
                .login("tms_qa08onl_3@mailinator.com", "123456")
                .waitForMoodBtnVisible()
                .clickLogoutBtn();
        Assert.assertTrue(homePage.isStartBtnVisible());
    }
}

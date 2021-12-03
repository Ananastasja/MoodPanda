package steps;

import pages.FeedPage;
import pages.LoginPage;
import pages.MoodUpdatedModalPage;
import pages.RateYourHappinessModalPage;

public class MyDiarySteps {

    LoginPage loginPage;
    FeedPage feedPage;
    RateYourHappinessModalPage rateYourHappinessModalPage;
    MoodUpdatedModalPage moodUpdatedModalPage;

    public MyDiarySteps() {
        loginPage = new LoginPage();
        feedPage = new FeedPage();
        rateYourHappinessModalPage = new RateYourHappinessModalPage();
        moodUpdatedModalPage = new MoodUpdatedModalPage();
    }

    public MyDiarySteps loginAndUpdateMood (String email, String password, int badge) {
        loginPage.openPage()
                .login(email, password)
                .waitForMoodBtnVisible()
                .clickUpdateBtn()
                .updateMood(badge)
                .clickUpdateMoodBtn()
                .clickGoToDiaryBtn();
        return this;
    }
}


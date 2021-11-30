package steps;

import pages.FeedPage;
import pages.LoginPage;
import pages.RateYourHappinessModalPage;

public class RateYourHappinessSteps {
    LoginPage loginPage;
    FeedPage feedPage;
    RateYourHappinessModalPage rateYourHappinessModalPage;

    public RateYourHappinessSteps() {
        loginPage = new LoginPage();
        feedPage = new FeedPage();
        rateYourHappinessModalPage = new RateYourHappinessModalPage();
    }

    public RateYourHappinessSteps loginAndUpdateMood (String email, String password, int badge) {
        loginPage.openPage()
                .login(email, password)
                .waitForMoodBtnVisible()
                .clickUpdateBtn()
                .updateMood(badge);
        return this;
    }
}

import org.testng.annotations.Test;

public class MoodPandaTest extends BaseTest {

    @Test
    public void moodTest() {
        loginPage.openPage()
                .login("tms_qa08onl_3@mailinator.com", "123456")
                .waitForMoodBtnVisible()
                .clickUpdateBtn()
                .updateMood(1);
    }
}

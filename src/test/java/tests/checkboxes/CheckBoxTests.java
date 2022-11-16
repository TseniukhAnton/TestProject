package tests.checkboxes;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.selenium.practice.constants.Constant.Urls.HOME_PAGE;

public class CheckBoxTests extends BaseTest {
    @Test (testName = "CheckBoxesViewCheck", priority = 2, groups = {"smoke"})
    public void checkboxView() {
        basePage.open(HOME_PAGE);
        loginPage.login()
                .openCheckBoxes()
                .checkboxesSelectedCheck();
    }
}

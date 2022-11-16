package tests.login;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.selenium.practice.constants.Constant.Urls.HOME_PAGE;

public class LoginTests extends BaseTest {
    @Test
    public void wrongLogin(){
        basePage.open(HOME_PAGE);
        loginPage.wrongLogin();
    }
}

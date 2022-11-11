package tests.base;

import org.openqa.selenium.WebDriver;
import org.selenium.practice.common.CommonActions;
import org.selenium.practice.pages.base.BasePage;
import org.selenium.practice.pages.checkboxes.CheckBoxesPage;
import org.selenium.practice.pages.home.HomePage;
import org.selenium.practice.pages.login.LoginPage;
import org.testng.annotations.AfterClass;

import static org.selenium.practice.common.Config.HOLD_BROWSER_OPEN;

public class BaseTest {
    protected WebDriver driver = CommonActions.createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected HomePage homePage = new HomePage(driver);
    protected LoginPage loginPage = new LoginPage(driver);
    protected CheckBoxesPage checkBoxesPage = new CheckBoxesPage(driver);

    @AfterClass(alwaysRun = true)
    public void close(){
        if (HOLD_BROWSER_OPEN){
            driver.quit();
        }
    }
}

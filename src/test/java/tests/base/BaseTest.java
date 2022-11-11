package tests.base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.selenium.practice.common.CommonActions;
import org.selenium.practice.pages.base.BasePage;
import org.selenium.practice.pages.home.HomePage;
import org.selenium.practice.pages.login.LoginPage;
import org.testng.annotations.AfterTest;

import static org.selenium.practice.common.Config.CLEAR_COOKIES_AND_STORAGE;
import static org.selenium.practice.common.Config.HOLD_BROWSER_OPEN;

public class BaseTest {
    protected WebDriver driver = CommonActions.createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected HomePage homePage = new HomePage(driver);
    protected LoginPage loginPage = new LoginPage(driver);

    @AfterTest
    public void clearCookiesAndLocalStorage(){
        if(CLEAR_COOKIES_AND_STORAGE){
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            javascriptExecutor.executeAsyncScript("window.sessionStorage.clear()");
        }
    }

    @AfterTest (alwaysRun = true)
    public void close(){
        if (HOLD_BROWSER_OPEN){
            driver.quit();
        }
    }
}

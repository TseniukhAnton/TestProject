package tests.HomePageCheckView;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;
import tests.base.BaseTest;

import java.util.List;

import static org.selenium.practice.constants.Constant.Urls.HOME_PAGE;

public class HomePageTests extends BaseTest {
    @Test
    public void loginAndCheckHomePageView() throws InterruptedException {
        basePage.open(HOME_PAGE);
        loginPage.login();
        homePage.checkHomePageView();
    }

    @Test
    public void checkboxView() throws InterruptedException {
       // Login.login();
        WebDriver driver = new ChromeDriver();
        WebElement checkboxLink = driver.findElement(By.xpath("//a/span[contains(text(), 'Check-boxes')]"));
        checkboxLink.click();

        WebElement indeterminate = driver.findElement(By.xpath("//label[@for='mat-checkbox-1-input']/span[@class='mat-checkbox-inner-container']"));
        indeterminate.click();

        WebElement primary = driver.findElement(By.xpath("//label[@for='mat-checkbox-2-input']/span[@class='mat-checkbox-inner-container']"));
        WebElement accent = driver.findElement(By.xpath("//label[@for='mat-checkbox-3-input']/span[@class='mat-checkbox-inner-container']"));
        WebElement warn = driver.findElement(By.xpath("//label[@for='mat-checkbox-4-input']/span[@class='mat-checkbox-inner-container']"));

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(indeterminate.isSelected());
        softAssert.assertTrue(primary.isSelected());
        softAssert.assertTrue(accent.isSelected());
        softAssert.assertTrue(warn.isSelected());
//        assert indeterminate.isSelected();
//        assert primary.isSelected();
//        assert accent.isSelected();
//        assert warn.isSelected();
        driver.quit();
    }
}

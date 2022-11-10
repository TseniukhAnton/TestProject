package tests.base.CheckHomePage;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;
import tests.base.BaseTest;

import java.util.List;

public class HomePageTests extends BaseTest {
    @Test
    public void loginAndCheckHomePageView() throws InterruptedException {
       loginPage.login();
       homePage.checkHomePageView();
    }

    @Test
    public void checkHomePageElements() throws InterruptedException {
        //Login.login();
        WebDriver driver = new ChromeDriver();

        WebElement homeNavElem = driver.findElement(By.xpath("//span[contains(text(), 'Home')]"));
        assert homeNavElem.isDisplayed();

        String hugeText = driver.findElement(By.xpath("//i[@class='material-icons']//parent::h1")).getText();
        System.out.println(hugeText);
        assert hugeText.equals("Test website designed for the automation practice. I know, site design is painful. sentiment_very_satisfied");

        List<String> categoryList = driver.findElements(By.xpath("//a/span[@class='mat-button-wrapper']")).stream().map(WebElement::getText).toList();
        int size = categoryList.size();
        System.out.println(categoryList);

        for (String el : categoryList) {
            System.out.println(el);
        }

        assert size == 9;

        String mainLogo = driver.getTitle();
        assert mainLogo.equals("DockerJenkinsAngular");

        driver.quit();
        System.out.println(driver.getWindowHandle());
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

package org.selenium.practice;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

public class TestClass {
    @FindBy(xpath = "//label[@for='mat-checkbox-1-input']")
    private final WebElement indeterminate;
    @FindBy(xpath = "//label[@for='mat-checkbox-2-input']")
    private final
    WebElement primary;
    @FindBy(xpath = "//label[@for='mat-checkbox-3-input']")
    private final WebElement accent;
    @FindBy(xpath = "//label[@for='mat-checkbox-4-input']")
    private final WebElement warn;

    public TestClass(WebElement indeterminate, WebElement primary, WebElement accent, WebElement warn) {
        this.indeterminate = indeterminate;
        this.primary = primary;
        this.accent = accent;
        this.warn = warn;
    }

    @Test
    public void main() {
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium files\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://qa-automation-test-site.web.app/login");
        driver.manage().window().maximize();

        WebElement login = driver.findElement(By.id("login"));
        login.sendKeys("test@test.com");
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("test");
        WebElement loginBtn = driver.findElement(By.xpath("//button[@id='loginBtn']"));
        loginBtn.click();

        WebElement checkboxLink = driver.findElement(By.xpath("//a/span[contains(text(), 'Check-boxes')]"));
        checkboxLink.click();

        indeterminate.click();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(indeterminate.isSelected());
        softAssert.assertTrue(primary.isSelected());
        softAssert.assertTrue(accent.isSelected());
        softAssert.assertTrue(warn.isSelected());

        driver.quit();
    }
}

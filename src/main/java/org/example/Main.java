package org.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    @Test
    public void main() throws InterruptedException {
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

        WebElement mainText = driver.findElement(By.xpath("//span[contains(text(),'QA Automation Web')]"));
        assert mainText.isDisplayed();

        WebElement userAdmin = driver.findElement(By.xpath("//mat-label[contains(text(),'admin')]"));
        assert userAdmin.getText().equals("admin");

        driver.close();
    }
}

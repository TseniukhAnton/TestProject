package org.selenium.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class Login {
    @BeforeTest
    public static void login() {
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
    }
}

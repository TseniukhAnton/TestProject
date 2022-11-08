package org.selenium.practice;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePageTests {

    @Test
    public void loginAndCheckHomePageView() throws InterruptedException {
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

        String url = driver.getCurrentUrl();
        String urlNeeded = "https://qa-automation-test-site.web.app/home";

        assert url.equals(urlNeeded);
        System.out.println(url.equals(urlNeeded));

        WebElement userAdmin = driver.findElement(By.xpath("//mat-label[contains(text(),'admin')]"));
        assert userAdmin.getText().equals("admin");

        driver.close();
    }

    @Test
    public void checkHomePageElements(){
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

        WebElement homeNavElem = driver.findElement(By.xpath("//span[contains(text(), 'Home')]"));
        assert homeNavElem.isDisplayed();

        String mainLogo = driver.getTitle();
        assert mainLogo.equals("DockerJenkinsAngular");

        driver.close();
    }
}

package org.selenium.practice;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class HomePageTests {
    @Test
    public void loginAndCheckHomePageView() throws InterruptedException {
        Login.login();

        WebDriver driver = new ChromeDriver();

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
    public void checkHomePageElements() throws InterruptedException {
        Login.login();
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
    }

    @Test
    public void checkboxView() throws InterruptedException {
        Login.login();
        WebDriver driver = new ChromeDriver();
        WebElement checkboxLink = driver.findElement(By.xpath("//a/span[contains(text(), 'Check-boxes')]"));
        checkboxLink.click();

        WebElement indeterminate = driver.findElement(By.cssSelector("//label[@for='mat-checkbox-1-input']"));
        indeterminate.click();

        WebElement primary = driver.findElement(By.cssSelector("//label[@for='mat-checkbox-2-input']"));
        WebElement accent = driver.findElement(By.cssSelector("//label[@for='mat-checkbox-3-input']"));
        WebElement warn = driver.findElement(By.cssSelector("//label[@for='mat-checkbox-4-input']"));

        assert indeterminate.isSelected();
        assert primary.isSelected();
        assert accent.isSelected();
        assert warn.isSelected();
        driver.quit();
    }
}

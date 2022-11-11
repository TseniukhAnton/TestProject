package org.selenium.practice.pages.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.practice.pages.base.BasePage;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    private final By login = By.id("login");
    private final By password = By.xpath("//input[@id='password']");
    private final By loginBtn = By.xpath("//button[@id='loginBtn']");

    public LoginPage login() {
       // driver.get(HOME_PAGE);
        driver.findElement(login).sendKeys("test@test.com");
        driver.findElement(password).sendKeys("test");
        driver.findElement(loginBtn).click();

        return this;
    }
}

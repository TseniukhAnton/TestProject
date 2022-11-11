package org.selenium.practice.pages.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.selenium.practice.pages.base.BasePage;
import org.selenium.practice.pages.checkboxes.CheckBoxesPage;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static org.selenium.practice.constants.Constant.NumberVars.CATEGORY_LIST_COUNT;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }
    private final By logo = By.xpath("//span[contains(text(),'QA Automation Web')]");
    private final By admin = By.xpath("//mat-label[contains(text(),'admin')]");
    private final By home = By.xpath("//span[contains(text(), 'Home')]");
    private final By hugeText = By.xpath("//i[@class='material-icons']//parent::h1");
    private final By categoryList = By.xpath("//a/span[@class='mat-button-wrapper']");
    private final By checkboxLink = By.xpath("//a/span[contains(text(), 'Check-boxes')]");

    public HomePage checkHomePageView() {
        waitElementIsVisible(driver.findElement(hugeText));
        driver.findElement(logo).isDisplayed();
        driver.findElement(admin).isDisplayed();
        driver.findElement(home).isDisplayed();

        System.out.println(driver.findElement(hugeText).getText());
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.findElement(hugeText).getText(), "Test website designed for the automation practice. I know, site design is painful. sentiment_very_satisfied");
        Assert.assertEquals(driver.findElement(hugeText).getText(), "Test website designed for the automation practice. I know, site design is painful. sentiment_very_satisfied");

        List<String> elements = driver.findElements(categoryList).stream().map(WebElement::getText).toList();
        int size = elements.size();
        for (String el : elements) {
            System.out.println(el);
        }
        assert size == CATEGORY_LIST_COUNT;

        String mainLogo = driver.getTitle();
        assert mainLogo.equals("DockerJenkinsAngular");

        return this;
    }
    public CheckBoxesPage openCheckBoxes(){
        driver.findElement(checkboxLink).click();
        return new CheckBoxesPage(driver);
    }
}

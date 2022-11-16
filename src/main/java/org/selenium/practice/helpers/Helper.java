package org.selenium.practice.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.selenium.practice.pages.base.BasePage;

import java.time.Duration;

import static org.selenium.practice.constants.Constant.TimeoutVariable.IMPLICIT_WAIT;

public class Helper extends BasePage {
    private final Actions actions = new Actions(driver);

    public Helper(WebDriver driver) {
        super(driver);
    }

    public void dragAndDrop(WebElement el1, WebElement el2){
        try{
            actions.moveToElement(el1).pause(Duration.ofSeconds(IMPLICIT_WAIT)).clickAndHold().moveToElement(el2).release().build().perform();
            //or
            actions.dragAndDrop(el1,el2);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

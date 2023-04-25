package utilities;

import browserfactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Utility extends BaseTest {

    public void clickOnElement(By by) {    //This method will Click on element found through - By class
        driver.findElement(by).click();
    }

//    public void clickOnElement(WebElement ele) { // This method will click on element found through - WebElement interface
//        ele.click();
//    }

    public void sendTextToElement(By by, String text) {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
    }
//    public void sendTextToElement(WebElement ele , String text) {
//       ele.sendKeys(text);
//    }


    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    //This method will mouse hoover to any element
    public void moveToElement(WebElement ele) {
        Actions actions = new Actions(driver);
        actions.moveToElement(ele).build().perform();
    }


    /**
     * This method will get text from element and check whether it is displayed or not.
     */
    public boolean isTextDisplayed(By by, String expectedText) {
        boolean actualText = (driver.findElement(by).getText()).contains(expectedText); // Find and get actual text on page and check whether it contains expected text or not?
        assert actualText : "Text is not found" + expectedText;
        return true;
    }
    /**
     * This method will get number from element and check
     * whether it is displayed or not.
     */
//    public boolean getNumberFromElement(By by,int expectedNumber){
//        int actualNumber = driver.findElements(by).size();
//        assert actualNumber == expectedNumber : "Expected Number is not found" + expectedNumber;
//        return true;
//    }


}





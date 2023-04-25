package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

public class MenTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }
    @After
    public void tearDown() {
        closeBrowser();
    }
    @Test
    public void verifyuserShouldAddProductSuccessFullyToShoppinCart(){
        WebElement men = driver.findElement(By.xpath("//span[contains(text(),'Men')]"));
        WebElement bottoms = driver.findElement(By.xpath("//a[@id='ui-id-18']//span[contains(text(),'Bottoms')]"));
        WebElement pants = driver.findElement(By.xpath("//a[@id='ui-id-23']//span[contains(text(),'Pants')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(men).moveToElement(bottoms).moveToElement(pants).click().build().perform();
        //Click on size of Cronus Yoga Pant
        WebElement size = driver.findElement(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-size-143-item-175']"));
        size.click();
        //Click on black colour of Cronus Yoga Pant
        WebElement black = driver.findElement(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-color-93-item-49']"));
        black.click();
        //Click on Add to cart of Cronus Yoga Pant
        WebElement addToCart = driver.findElement(By.xpath("//body/div[1]/main[1]/div[3]/div[1]/div[3]/ol[1]/li[1]/div[1]/div[1]/div[3]/div[1]/div[1]/form[1]/button[1]/span[1]"));
        addToCart.click();
        //Varify the text 'You added Cronus Yoga Pant to your shopping cart.'
         String expectedText = "You added Cronus Yoga Pant to your shopping cart.";
         WebElement text = driver.findElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"));
         String actualText = text.getText();
         Assert.assertEquals("Item is not added",expectedText,actualText);
         //click on shopping cart link
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));
        //Verify the text 'Shopping Cart'
        String expectedText1 = "Shopping Cart";
        WebElement text1 = driver.findElement(By.xpath("//body/div[1]/main[1]/div[1]/h1[1]/span[1]"));
        String actualText1 = text1.getText();
        Assert.assertEquals("text 'Shopping Cart' not found ",expectedText1,actualText1);
        //Verify the text 'Cronus yoga pant'
        String expectedProdcutName = "Cronus Yoga Pant";
        WebElement text2 = driver.findElement(By.xpath("//tbody/tr[1]/td[1]/div[1]/strong[1]/a[1]"));
        String actualProductName = text2.getText();
        Assert.assertEquals("text 'Crounus Yoga Pant' not found",expectedProdcutName,actualProductName);
        // verify the product size '32'
        String expectedSize = "32";
        WebElement size1 = driver.findElement(By.xpath("//dd[contains(text(),'32')]"));
        String actualSize = size1.getText();
        Assert.assertEquals("text '32' not found", expectedSize,actualSize);
        //verify the text 'Black'
        String expectedColour = "Black";
        WebElement colour = driver.findElement(By.xpath("//dd[contains(text(),'Black')]"));
        String actualColour = colour.getText();
        Assert.assertEquals("The text 'Black' not found", expectedColour,actualColour);





    }




}

package testsuite;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

public class GearTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }
//    @After
//    public void tearDown() {
//        closeBrowser();
 //   }
    @Test
    public void userShouldAddProductSuccessFullyToShoppinCart(){
        //mouse hoover over Gear---------->Bags and click on it
        WebElement gear =driver.findElement(By.xpath("//span[normalize-space()='Gear']"));
        WebElement bags = driver.findElement(By.xpath("//a[@id='ui-id-25']//span"));
        Actions actions = new Actions(driver);
        actions.moveToElement(gear).moveToElement(bags).click().build().perform();
        //click on product name 'overnigt Duffle'
        clickOnElement(By.xpath("//a[normalize-space()='Overnight Duffle']"));
        // verify the text ‘Overnight Duffle’
        String expectedProductName = "Overnight Duffle";
        WebElement text = driver.findElement(By.xpath("//span[contains(text(),'Overnight Duffle')]"));
        String actualTextProductName = text.getText();
        Assert.assertEquals("The text'Ovefrnigt Duffle' is not found",expectedProductName,actualTextProductName);
        //Change quantity 3
        sendTextToElement(By.id("qty"),"3");
        //click on Add to Cart button
        clickOnElement(By.xpath("//span[contains(text(),'Add to Cart')]"));
        //Verify the text ‘You added Overnight Duffle to your shopping cart.’
        String expectedText = "You added Overnight Duffle to your shopping cart.";
        WebElement text1 = driver.findElement(By.xpath("//body/div[1]/main[1]/div[1]/div[2]/div[1]/div[1]/div[1]"));
        String actualText = text1.getText();
        Assert.assertEquals("The text '‘You added Overnight Duffle to your shopping cart.' is not found" ,expectedText,actualText);
       // click on Shopping cart link
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));
        // verify the product name 'Overnight Duffle'
        String expectedProductName1 = "Overnight Duffle";
        WebElement productName = driver.findElement(By.xpath("(//div[@class = 'product-item-details']//strong//a)[last()]"));
        String actualProductName1 = productName.getText();
        Assert.assertEquals("Text name couldn't found", expectedProductName1,actualProductName1);
        //Verify the quantity 3
        String expectedQty = "3";
        WebElement qty = driver.findElement(By.id("cart-104320-qty"));
        String actualQty = qty.getText();
      //  Assert.assertEquals("Quantity 3 couldn't found",expectedQty,actualQty);

        String expectedPrice = "$135.00";
        WebElement price = driver.findElement(By.xpath("//tbody[@class='cart item']//tr//td[4]//span//span//span"));
        String actualPrice = price.getText();
        Assert.assertEquals(actualPrice,expectedPrice);

        //change qty to 5
        sendTextToElement(By.id("cart-104320-qty"),"5");
        clickOnElement(By.xpath("//span[text()='Update Shopping Cart']"));
        String expectedPrice1 = "$225.00";
        String actualPrice1 = price.getText();
        Assert.assertEquals(actualPrice1,expectedPrice1);









    }



}

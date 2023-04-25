package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WomenTest extends Utility {

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
    public void verifyTheSortByProductNameFilter() {
        //Women------Tops------>Jackets and click
        WebElement Women = driver.findElement(By.xpath("//span[contains(text(),'Women')]"));
        WebElement Tops = driver.findElement(By.xpath("//a[@id='ui-id-9']"));
        WebElement Jackets = driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/nav[1]/ul[1]/li[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]/span[1]"));
        //  Actions actions = new Actions(driver);
        // actions.moveToElement(Women).moveToElement(Tops).moveToElement(Jackets).click().build().perform();
        moveToElement(Women);
        moveToElement(Tops);
        moveToElement(Jackets);
        clickOnElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/nav[1]/ul[1]/li[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]/span[1]"));
        //Find Dropdown box element
        WebElement sortBy = driver.findElement(By.id("sorter"));
        //Use Select class to select option from dropdawn list
        Select select = new Select(sortBy);
        //select option, by visibleText from drop down list
        select.selectByVisibleText("Product Name");
        //Verify the products name display in alphabetical order
        List<WebElement> productlist = driver.findElements(By.className("product-item-link"));
        //Define two arraylist to store the name of the products
        List<String> actualProductList = new ArrayList<>();
        List<String> expectedSortedProductList = new ArrayList<>();
        for (WebElement product : productlist) {
            actualProductList.add(product.getText());   // add product name from product list to ArrayList
            expectedSortedProductList.add(product.getText());
        }
        //sort the expected product list by Collections.sort();
        Collections.sort(expectedSortedProductList);
        Assert.assertEquals("Product names are not sorted alphabetically", actualProductList, expectedSortedProductList);
    }

    @Test
    public void verifyTheSortByPriceFilter() {
        //Women------Tops------>Jackets and click
        WebElement Women = driver.findElement(By.xpath("//span[contains(text(),'Women')]"));
        WebElement Tops = driver.findElement(By.xpath("//a[@id='ui-id-9']"));
        WebElement Jackets = driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/nav[1]/ul[1]/li[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]/span[1]"));
        //  Actions actions = new Actions(driver);
        // actions.moveToElement(Women).moveToElement(Tops).moveToElement(Jackets).click().build().perform();
        moveToElement(Women);
        moveToElement(Tops);
        moveToElement(Jackets);
        clickOnElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/nav[1]/ul[1]/li[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]/span[1]"));
        //Find Dropdown box element
        WebElement sortBy = driver.findElement(By.id("sorter"));
        //Use Select class to select option from dropdawn list
        Select select = new Select(sortBy);
        //select option, by visibleText from drop down list
        select.selectByVisibleText("Price");
        //Verify the products price display in Low to High
        List<WebElement> prices = driver.findElements(By.xpath("//span[@class='price-wrapper ']//span"));
        List<Double> actualPrices = new ArrayList<>();
        List<Double> expectedSortedPrices = new ArrayList<>();
        for (WebElement price : prices) {
            //  from product prices add price to ArrayList, by removing 'Dollar sign' by replace() method and
            // converting String to Double as getText() return String value

            actualPrices.add(Double.valueOf(price.getText().replace("$", "")));
            expectedSortedPrices.add(Double.valueOf(price.getText().replace("$", "")));
        }
        //sort the expected product price by Collections.sort();
        Collections.sort(expectedSortedPrices);
        Assert.assertEquals("Products are not sorted by Prices", actualPrices, expectedSortedPrices);


    }


}




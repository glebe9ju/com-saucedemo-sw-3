package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class LoginTest extends Utility {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void  userShouldLoginSuccessfullyWithValidCredentials(){
        //Enter “standard_user” username
        sendTexttoElement(By.name("user-name"),"standard_user");
        //Enter “secret_sauce” password
       sendTexttoElement(By.id("password"),"secret_sauce");
        //Click on ‘LOGIN’ button
        clickOnElement(By.id("login-button"));
        //Verify the text “PRODUCTS”
//        WebElement products =driver.findElement(By.className("title"));
        System.out.println(driver.findElement(By.className("title")).getText());
        String products = getTextFromElement(By.className("title"));
        System.out.println(products);
        Assert.assertEquals("Incorrect loging detail" , "PRODUCTS", products);
    }
    @Test
    public void  verifyThatSixProductsAreDisplayedOnPage(){
        //Enter “standard_user” username
       sendTexttoElement(By.name("user-name"),"standard_user");
        //Enter “secret_sauce” password
        sendTexttoElement(By.id("password"),"secret_sauce");
        //Click on ‘LOGIN’ button
        clickOnElement(By.id("login-button"));
        //Verify the text “PRODUCTS”
        WebElement products =driver.findElement(By.className("title"));
        Assert.assertEquals("Incorrect loging detail" , "PRODUCTS", products.getText());
        //create iteamlist by xpath
        List<WebElement> itemList = driver.findElements(By.xpath("//div[@class='inventory_list']//div[@class='inventory_item_name']"));
        //number of iteam displayed
        System.out.println("Number of item displayed : " + itemList.size());
        //if you enter wrong number then number of items are not six message will appear
        Assert.assertTrue("Number of items display are not six",itemList.size()==6);
        for (WebElement item: itemList) {
            System.out.println(item.getText() + "is dispayed? : "  +  item.isDisplayed());
        }
    }
    @After
    public void tearDown() {
        closeBrowsers();
    }

}

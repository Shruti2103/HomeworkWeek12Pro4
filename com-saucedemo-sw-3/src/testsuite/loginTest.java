package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class loginTest extends Utility {
    String baseurl = "https://www.saucedemo.com/";

    // click on login click
    @Before
    public void setbrowser() {
        openbrowser(baseurl);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() {
        //create username

        sendTextToElement(By.xpath("//input[@id='user-name']"), "standard_user");
        // create password

        sendTextToElement(By.id("password"), "secret_sauce");
        // create login button

        clickOnElement(By.xpath("//input[@id='login-button']"));
        // verify text "Products"

        getTextFromElement(By.xpath("//span[contains(text(),'Products')]"));
        //  varify product field
        String expextedmessage = "PRODUCTS";

        String actualmessage1 = getTextFromElement(By.xpath("//span[contains(text(),'Products')]"));
        //Assert actual with expected
        Assert.assertEquals("User is on Products ", expextedmessage, actualmessage1);


    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        // create user name

        sendTextToElement(By.xpath("//input[@id='user-name']"), "standard_user");
        // password field create

        sendTextToElement(By.xpath("//input[@id='password']"), "secret_sauce");
        // click log in button

        clickOnElement(By.xpath("//input[@id='login-button']"));
        // varify that 6 products are displayed
        // Finding if actual text in present or not
        List<WebElement> Items = listOfWebElementsList(By.xpath("//div[@class='inventory_item']"));
        int actualCountedItems = Items.size();

        //Required for validation
        int expectedItems = 6;

        // validating a test
        Assert.assertEquals("Nr of items are not Six", expectedItems, actualCountedItems);


    }

    @After
    public void teardown() {
        closebrowser();
    }

}

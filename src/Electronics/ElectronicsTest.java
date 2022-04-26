package Electronics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class ElectronicsTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/ftrfgtrrgrftfvgvtgtti-";

    @Before
    public void openBrowser() {
        setUpBrowser(baseUrl);
    }

    @Test
    public void textVerified() throws InterruptedException {
mouseHoverAndClick(By.xpath("//ul[@class='top-menunotmobile']/li[2]"), By.xpath("//ul[@class='top-menu notmobile']/li[2]/ul/li[2]"));
        verifyTextWithAssert("Electronics", By.xpath("//div[@class='center-2']/div/div[1]/h1"), "Verify cellphones text");
    }


    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
//        2.1 Mouse Hover on “Electronics”Tab
        mouseHoverToElement(By.xpath("//ul[@class='top-menu notmobile']/li[2]"));
//        2.2 Mouse Hover on “Cell phones” and click
        mouseHoverAndClick(By.xpath("//ul[@class='top-menu notmobile']/li[2]/ul/li[2]"));
//        2.3 Verify the text “Cell phones”
        verifyTextWithAssert("Cell phones",By.xpath("//h1[contains(text(),'Cell phones')]"),"text is verified");
//        2.4 Click on List View Tab
        clickOnElement(By.xpath("//div[@class='product-viewmode']/a[2]"));
//        2.5 Click on product name “Nokia Lumia 1020” link
        Thread.sleep(2000);
        clickOnElement(By.xpath("//div[@class='item-grid']/div[3]/div/div[2]/h2/a"));
//        2.6 Verify the text “Nokia Lumia 1020”
        verifyTextWithAssert("Nokia Lumia 1020",By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]"),"text is verified");
//        2.7 Verify the price “$349.00”
        verifyTextWithAssert("$349.00",By.xpath("/html[1]/body[1]/div[6]/div[3]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/div[2]/div[6]/div[1]/span[1]"),"price is verified");
//        2.8 Change quantity to 2
        Thread.sleep(2000);
        clearTextFromField(By.xpath("//div[@class='add-to-cart']/div/input"));
        sendTextToElement(By.xpath("//div[@class='add-to-cart']/div/input"),"2");
//        2.9 Click on “ADD TO CART” tab
        clickOnElement(By.xpath("//div[@class='add-to-cart']/div"));
//        2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        verifyTextWithAssert("The product has been added to your shopping cart",By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"),"Text is verified");
//        After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]"));
//        2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverAndClick(By.xpath("//span[contains(text(),'Shopping cart')]"));
        Thread.sleep(2000);
        mouseHoverAndClick(By.xpath("//button[contains(text(),'Go to cart')]"));
        Thread.sleep(2000);
//        2.12 Verify the message "Shopping cart"
        verifyTextWithAssert("Shopping cart",By.xpath("//h1[contains(text(),'Shopping cart')]"),"text is verified");
//        2.13 Verify the quantity is 2
      //  verifyTextWithAssert("2",By.xpath("//td[@class='quantity']/input"),"Quantity is verified");
//        2.14 Verify the Total $698.00
        verifyTextWithAssert("$698.00",By.xpath("//td[@class='cart-total-right']/span/strong"),"price is verified");
//        2.15 click on checkbox “I agree with the terms of service”
        clickOnElement(By.id("termsofservice"));
//        2.16 Click on checkout
        clickOnElement(By.xpath("//button[@id='checkout']"));
//“2.17 Verify the Text “Welcome, Please Sign In!”
        verifyTextWithAssert("Welcome, Please Sign In!",By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"),"text is verified");
//        2.18 Click on “REGISTER” tab
        clickOnElement(By.xpath("//button[contains(text(),'Register')]"));
//        2.19 Verify the text “Register”
        mouseHoverAndClick(By.xpath("//input[@id='gender-female']"));
//        2.20 Fill the mandatory fields
        sendTextToElement(By.xpath("//input[@id='FirstName']"),"chaman");
        sendTextToElement(By.xpath("//input[@id='LastName']"),"patel");
        selectByIndexFromDropDown(By.xpath("//select[@name='DateOfBirthDay']"),25);
        selectByVisibleTextFromDropDown(By.xpath("//select[@name='DateOfBirthMonth']"),"October");
        selectByVisibleTextFromDropDown(By.xpath("//select[@name='DateOfBirthYear']"),"1920");
        sendTextToElement(By.xpath("//input[@id='Email']"),"ppp123@gmail.com");
        sendTextToElement(By.xpath("//input[@id='Password']"),"chaman123");
        sendTextToElement(By.xpath("//input[@id='ConfirmPassword']"),"chaman123");


//        2.21 Click on “REGISTER” Button
        clickOnElement(By.xpath("//button[@id='register-button']"));
//        2.22 Verify the message “Your registration completed”
        Thread.sleep(2000);
        verifyTextWithAssert("Your registration completed",By.xpath("//div[contains(text(),'Your registration completed')]"),"text is verified");
        Thread.sleep(2000);
        //        2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
//        2.24 Verify the text “Shopping cart”
        verifyTextWithAssert("Shopping cart",By.xpath("//h1[contains(text(),'Shopping cart')]"),"text is verified");
//        2.25 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
//        2.26 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));
//        2.27 Fill the Mandatory fields
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"),"chaman");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"),"patel");
        selectByValueFromDropdown(By.xpath("//div[@class='edit-address']/div[5]/select"),"1");
        selectByValueFromDropdown(By.xpath("//div[@class='edit-address']/div[6]/select"),"49");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"),"phoenix");
        sendTextToElement(By.xpath("//div[@class='edit-address']/div[8]/input"),"alvarado road");
        sendTextToElement(By.xpath("//div[@class='edit-address']/div[9]/input"),"555 south");
        sendTextToElement(By.xpath("//div[@class='edit-address']/div[10]/input"),"85035");
        sendTextToElement(By.xpath("//div[@class='edit-address']/div[11]/input"),"+157512345678");
        sendTextToElement(By.xpath("//div[@class='edit-address']/div[12]/input"),"123456789");
//        2.28 Click on “CONTINUE”
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/button[4]"));
//        2.29 Click on Radio Button “2nd Day Air ($0.00)”
        Thread.sleep(2000);
       // clickOnElement(By.xpath("//ul[@class='method-list']/li[2]/div[1]/input"));
//        2.30 Click on “CONTINUE”
        Thread.sleep(2000);
        clickOnElement(By.xpath("//div[@id='shipping-method-buttons-container']/button"));
        //2.31 Select Radio Button “Credit Card”
        clickOnElement(By.id("paymentmethod_1"));
        clickOnElement(By.xpath("//div[@id='payment-method-buttons-container']/button"));
        //2.32 Select “Visa” From Select credit card dropdown
        //2.33 Fill all the details
        sendTextToElement(By.id("CardholderName"),"pin");
        sendTextToElement(By.id("CardNumber"),"4917484589897107");
        selectByIndexFromDropDown(By.id("ExpireYear"),2);
        sendTextToElement(By.id("CardCode"),"007");
        //2.34 Click on “CONTINUE”CHECKOUT”
        clickOnElement(By.xpath("//div[@id='payment-info-buttons-container']/button"));
        //2.35 Verify “Payment Method” is “Credit Card”
        verifyTextWithAssert("Credit Card",By.xpath("//li[@class='payment-method']/span[2]"),"Credit card validation");
        //2.36 Verify “Shipping Method” is “2nd Day Air”
       // verifyTextWithAssert("2nd Day Air",By.xpath("//li[@class='shipping-method']/span[2]"),"Shipping method validation");
        //2.37 Verify Total is “$698.00”
        verifyTextWithAssert("$698.00",By.xpath("//td[@class='subtotal']/span"),"Amount validation");
        //2.38 Click on “CONFIRM”
        clickOnElement(By.xpath("//div[@id='confirm-order-buttons-container']/button"));
        //2.39 Verify the Text “Thank You”
        verifyTextWithAssert("Thank you",By.xpath("//div[@class='page checkout-page order-completed-page']/div[1]/h1"),"Thank you text validation");
        //2.40 Verify the message “Your order has been successfully processed!”
        verifyTextWithAssert("Your order has been successfully processed!",By.xpath("//div[@class='page checkout-page order-completed-page']/div[2]/div/div[1]"),"yoru order has been successfully processed");
        //2.41 Click on “CONTINUE”
        clickOnElement(By.xpath("//div[@class='section order-completed']/div[3]/button"));
        //2.42 Verify the text “Welcome to our store”
        verifyTextWithAssert("Welcome to our store",By.xpath("//div[@class='topic-block-title']/h2"),"Welcome to store text");
        //2.43 Click on “Logout” link
        clickOnElement(By.xpath("//div[@class='header-links']/ul/li[2]"));
        //2.44 Verify the URL is “https://demo.nopcommerce.com/”
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://demo.nopcommerce.com/";
        Assert.assertEquals(actualUrl,expectedUrl);

    }

    @After
    public void tearDown() {
        //closeBrowser();
    }
}



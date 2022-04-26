package computer;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestSuite extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/ftrfgtrrgrftfvgvtgtti-";

    @Before
    public void openBrowser() {
        setUpBrowser(baseUrl);
    }

    @Test
    public void clickOnComputer() {
        //click on header menu computers
        clickOnElement(By.xpath("//div[@class='header-menu']/ul/li[1]"));
        //click on desktop on side menu
        clickOnElement(By.xpath("//ul[@class='sublist']/li[1]/a"));
        //Prices Before filter
        List<WebElement> beforeFilterPrice = driver.findElements(By.xpath("item-grid"));
        //remove the "$" sign and stored in array
        List<Double> beforeFilterPriceList = new ArrayList<>();
        for (WebElement prices : beforeFilterPrice) {
            beforeFilterPriceList.add(Double.valueOf(prices.getText().replace("$", "")));
        }
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"), "Price: Low to High");
        List<WebElement> afterFilterPrice = driver.findElements(By.xpath("item-grid"));
        //remove the "$" sign and stored in array
        List<Double> afterFilterPriceList = new ArrayList<>();
        for (WebElement prices : beforeFilterPrice) {
            afterFilterPriceList.add(Double.valueOf(prices.getText().replace("$", "")));
        }
        //sorting the priceList
        Collections.sort(beforeFilterPriceList);
        Assert.assertEquals(beforeFilterPriceList,afterFilterPriceList);



    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        Actions actions = new Actions(driver);

//        2.1 Click on Computer Menu.
        WebElement computer = driver.findElement(By.linkText("Computers"));
//        2.2 Click on Desktop
        WebElement desktop = driver.findElement(By.xpath("//div[@class='header-menu']/ul[1]/li[1]/ul/li[1]/a"));
        actions.moveToElement(computer).moveToElement(desktop).click().build().perform();
//        2.3 Select Sort By position "Name: A to Z"
        selectByValueFromDropdown(By.xpath("//select[@id='products-orderby']"), "5");
//        2.4 Click on "Add To Cart"
        Thread.sleep(2000);
        mouseHoverAndClick(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/button[1]"));
        //        2.5 Verify the Text "Build your own computer"
        verifyTextWithAssert("Build your own computer", By.xpath("//div[@class='products-wrapper']/div/div/div[1]/div/div[2]/h2/a"), "text is displayed");
//        2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        Thread.sleep(3000);
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='product_attribute_1']"), "2.2 GHz Intel Pentium Dual-Core E2200");
//        2.7.Select "8GB [+$60.00]" using Select class.
        selectByValueFromDropdown(By.xpath("//div[@class='product-essential']/div[2]/div[7]/dl/dd[2]/select"), "5");
//        2.8 Select HDD radio "400 GB [+$100.00]"
        mouseHoverAndClick(By.xpath("//input[@id='product_attribute_3_7']"));
//        2.9 Select OS radio "Vista Premium [+$60.00]"
        mouseHoverAndClick(By.xpath("//li[@data-attr-value='9']/input"));
//        2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        mouseHoverAndClick(By.xpath("//input[@id='product_attribute_5_12']"));
//        2.11 Verify the price "$1,475.00"
        Thread.sleep(3000);
        verifyTextWithAssert("$1,475.00", By.xpath("//div[@class='product-price']//span[@id='price-value-1']"), "price is matched");
//        2.12 Click on "ADD TO CART" Button.
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));
//        2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        verifyTextWithAssert("The product has been added to your shopping cart", By.xpath("//body/div[@id='bar-notification']/div[1]"), "Text is displayed");
//        After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]"));
//        2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverToElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        clickOnElement(By.xpath("//button[contains(text(),'Go to cart')]"));
//        2.15 Verify the message "Shopping cart"
        verifyTextWithAssert("Shopping cart", By.xpath("//h1[contains(text(),'Shopping cart')]"), "text is displayed");
        Thread.sleep(3000);
//        2.16 Change the Qty to "2" and Click on "Update shopping cart"
        clearTextFromField(By.xpath("//td[@class='quantity']/input"));
        Thread.sleep(3000);
        sendTextToElement(By.xpath("//td[@class='quantity']/input"), "2");
        clickOnElement(By.xpath("//button[@id='updatecart']"));

//        2.17 Verify the Total"$2,950.00"
        verifyTextWithAssert("$2,950.00", By.xpath("//span[@class='value-summary']/strong"), "Total is displayed");
//        2.18 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
//        2.19 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));
//        2.20 Verify the Text “Welcome, Please Sign In!”
        verifyTextWithAssert("Welcome, Please Sign In!", By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"), "Text is displayed");
//        2.21Click on “CHECKOUT AS GUEST”Tab
        clickOnElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));
//        2.22 Fill the all mandatory field
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"), "Chaman");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"), "patel");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Email']"), "chaman123@gmail.com");

        selectByIndexFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), 1);
        //selectByValueFromDropdown(By.xpath("//select[@id='BillingNewAddress_CountryId']"),"United States");
        selectByValueFromDropdown(By.xpath("//select[@id='BillingNewAddress_StateProvinceId']"), "49");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"), "phoenix");
        sendTextToElement(By.xpath("//div[@class='edit-address']/div[8]/input"), "Alvarado road");
        sendTextToElement(By.xpath("//div[@class='edit-address']/div[9]/input"), "7770, south");
        sendTextToElement(By.xpath("//div[@class='edit-address']/div[10]/input"), "23455");
        sendTextToElement(By.xpath("//div[@class='edit-address']/div[11]/input"), "+157512345678");
        sendTextToElement(By.xpath("//div[@class='edit-address']/div[12]/input"), "12345678");
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/button[4]"));
//        2.23 Click on “CONTINUE”
//        2.24 Click on Radio Button “Next Day Air($0.00)”
        clickOnElement(By.xpath("//input[@id='shippingoption_1']"));
//        2.25 Click on “CONTINUE”
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/button[1]"));
//        2.26 Select Radio Button “Credit Card”
        clickOnElement(By.xpath("//ul[@class='method-list']/li[2]/div/div[2]/input"));
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/button[1]"));
//        2.27 Select “Master card” From Select credit card dropdown
        Thread.sleep(3000);
        selectByValueFromDropdown(By.xpath("//select[@id='CreditCardType']"), "MasterCard");
//       2.28 Fill all the details
        sendTextToElement(By.xpath("//input[@id='CardholderName']"), "cpatel");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"), "5105105105105100");
        selectByIndexFromDropDown(By.xpath("//select[@id='ExpireMonth']"), 10);
        selectByValueFromDropdown(By.xpath("//select[@id='ExpireYear']"), "2022");
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "123");
//        2.29 Click on “CONTINUE”
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]"));
//        2.30 Verify “Payment Method” is “Credit Card”
        verifyTextWithAssert("Credit Card", By.xpath("//span[contains(text(),'Credit Card')]"), "Text is not verified");
//        2.32 Verify “Shipping Method” is “Next Day Air”
        verifyTextWithAssert("Next Day Air", By.xpath("//li[@class='shipping-method']/span[2]"), "Text is not displayed");
//        2.33 Verify Total is “$2,950.00”
        verifyTextWithAssert("$2,950.00", By.xpath("//tr[@class='order-total']/td/span"), "Total is not verified");
//        2.34 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));
//        2.35 Verify the Text “Thank You”
        verifyTextWithAssert("Thank you", By.xpath("//h1[contains(text(),'Thank you')]"), "text ia verified");
//        2.36 Verify the message “Your order has been successfully processed!”
        verifyTextWithAssert("Your order has been successfully processed!", By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"), "text is not verified");
//        2.37 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));
//        2.37 Verify the text “Welcome to our store”
        verifyTextWithAssert("Welcome to our store", By.xpath("//h2[contains(text(),'Welcome to our store')]"), "text is not verified");
    }
    @After
    public void tearDown(){
        closeBrowser();
    }


}

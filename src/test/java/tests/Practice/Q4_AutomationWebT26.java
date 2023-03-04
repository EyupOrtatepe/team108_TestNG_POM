package tests.Practice;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Automationexercise;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class Q4_AutomationWebT26 extends TestBaseRapor {
    //1. Launch browser



    @Test
    public void test01() throws IOException {
        extentTest = extentReports.createTest("Q4_AutomationWebT26","istenen sartlarin testi");

        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigReader.getProperty("automationexerciseUrl"));
        extentTest.info("Navigate to url 'http://automationexercise.com'");

        //3. Verify that home page is visible successfully
        Automationexercise automationexercise = new Automationexercise();
        extentTest.info("Verify that home page is visible successfully");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(automationexercise.logo.isDisplayed());
        extentTest.pass("logonun visibil oldugu test edildi");

        //4. Scroll down page to bottom
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.END).perform();
        extentTest.info("sayfanin sonuna gidildi");
        ReusableMethods.bekle(3);

        //5. Verify 'SUBSCRIPTION' is visible

        softAssert.assertTrue(automationexercise.subscription.isDisplayed());
        extentTest.pass("SUBSCRIPTION visibil oldugu test edildi");

        //6. Scroll up page to top
        automationexercise.upArrow.click();
        extentTest.info("sayfanin basina gidildi");
       // actions.sendKeys(Keys.HOME).perform();
        ReusableMethods.bekle(3);


        //7. Verify that page is scrolled up and
        softAssert.assertTrue(automationexercise.logo.isDisplayed());

        // 'Full-Fledged practice website for Automation Engineers' text is visible on screen

        softAssert.assertTrue(automationexercise.fullFledgedText.isDisplayed());

        ReusableMethods.getScreenshot("Q4_AutomationWebT26");

        extentTest.pass("fullFledged testinin visibil oldugu test edildi");
        softAssert.assertAll();



    }


}

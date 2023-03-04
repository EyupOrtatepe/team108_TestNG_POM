package tests.Practice;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Herokuapp;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class Q5_Herokuapp {

    @Test
    public void Test01() {
        SoftAssert softAssert = new SoftAssert();

        Herokuapp herokuapp = new Herokuapp();


        //● https://the-internet.herokuapp.com/windows adresine gidin.
        Driver.getDriver().get(ConfigReader.getProperty("herokuappUrl"));

        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.

        String expectedText = "Opening a new window";
        String actualText = herokuapp.openingText.getText();

        softAssert.assertTrue(actualText.equals(expectedText));

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.

        String expectedTitle = "The Internet";
        String actualTitel = Driver.getDriver().getTitle();

        softAssert.assertEquals(actualTitel,expectedTitle);

        //● Click Here butonuna basın.

        herokuapp.hereButton.click();

        //Driver.getDriver().findElement(By.linkText("Click Here")).click();

        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.

        ReusableMethods.switchToWindow("New Window");
        expectedTitle = "New Window";
        actualTitel = Driver.getDriver().getTitle();
        softAssert.assertEquals(actualTitel,expectedTitle);



        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        expectedText = "New Window";
        actualText = herokuapp.newWindowText.getText();

        softAssert.assertEquals(actualText,expectedText);


        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.

        ReusableMethods.switchToWindow("The Internet");
        expectedTitle = "The Internet";
        actualTitel = Driver.getDriver().getTitle();

        softAssert.assertEquals(actualTitel,expectedTitle);

       softAssert.assertAll();
    }
}

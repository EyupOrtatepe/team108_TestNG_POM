package tests.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.util.List;

public class D26_AmazonHucreTesti extends TestBaseRapor {

    AmazonPage amazonPage = new AmazonPage();
    SoftAssert softAssert = new SoftAssert();
    @Test
    public void hucreTesti(){
        extentTest = extentReports.createTest("hucre testi yapildi","hucrelerde home service test edildi");

        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        extentTest.info("amazona gidildi");


        String expectedText = "Home Services";
        String actualText = amazonPage.getCellText(3,5);


        softAssert.assertTrue(actualText.contains(expectedText));
        extentTest.pass("3. satir 2. sutunda home service yazdigi test edildi");

        softAssert.assertAll();
    }
    @Test
    public void AmazonYazisi(){
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        List<WebElement> cellTextList = Driver.getDriver()
                .findElements(By.xpath("//td[@class='navFooterDescItem']"));
        String amazonText ="Amazon";
        int amazonSayisi =0;
        for (WebElement webElement : cellTextList) {
            if(webElement.getText().contains(amazonText)){
                amazonSayisi++;
            }
        }
        int exp = 9;
        System.out.println(amazonSayisi);


        softAssert.assertTrue(amazonSayisi==9);
        softAssert.assertAll();
        Driver.closeDriver();

    }
}

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

public class D26_AmazonSatirSutunSayisi extends TestBaseRapor {


    @Test
    public void satirSayisi(){
        extentTest = extentReports.createTest("satir sayisi testi","kac satir oldugu bulundu");
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        AmazonPage amazonPage = new AmazonPage();
        amazonPage.amazonGoToEnd();
        extentTest.info("sayfa sonuna gidildi");

        List<WebElement> satirlarList = Driver.getDriver().findElements(By.tagName("tr"));

        int expectedSatirSayisi = 10;
        int actualSatirSayisi = satirlarList.size();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(actualSatirSayisi,expectedSatirSayisi);
        extentTest.pass("satir sayisinin 10 oldugu test edildi");

        List<WebElement> sutunlarList = Driver.getDriver()
                .findElements(By.xpath("//tr[1]/td[@class='navFooterDescItem']"));

        int expectedYaziliSutunSayisi = 7;
        int actualYaziliSutunSayisi = sutunlarList.size();

        softAssert.assertEquals(actualYaziliSutunSayisi,expectedYaziliSutunSayisi);
        extentTest.pass("sutun sayisinin 7 oldugu test edildi");


        softAssert.assertAll();
        Driver.closeDriver();
    }



}

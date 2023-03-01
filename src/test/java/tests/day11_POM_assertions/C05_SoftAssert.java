package tests.day11_POM_assertions;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C05_SoftAssert {

    @Test
    public void amazonTesti(){

        // amazona gidip gittiginizi verify edin
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        String expectedIcerik = "amazon";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(actualUrl.contains(expectedIcerik),"url amazon icermiyor");

        // Nutella aratip, sonuclarin nutella icerdigini verify edin
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        expectedIcerik = "Nutella";
        String actualAramaSonucYazisi = amazonPage.aramaSonucElementi.getText();

        softAssert.assertTrue(actualAramaSonucYazisi.contains(expectedIcerik),"Nutella icermiyor");

        // ilk urun isminde nutella gectigini verify edin

        amazonPage.ilkUrun.click();
        expectedIcerik = "Nutella";
        String actualIlkUrunIsim = amazonPage.ilkUrunIsmi.getText();

        softAssert.assertTrue(actualIlkUrunIsim.contains(expectedIcerik),"ilk urun isminde nutella gecmiyor");



        softAssert.assertAll();
        Driver.closeDriver();
    }
}

package tests.day12_xmlFiles;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QdPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C03_RaporluPozitifLoginTesti extends TestBaseRapor {

    @Test
    public void pozitifLoginTesti(){
        extentTest = extentReports.createTest("Pozitif login testi","gecerli bilgilerle giris yapilabilmeli");

        //qd ana sayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        extentTest.info("QD anasayfaya gidildi");

        //login e tiklayin
        QdPage qdPage = new QdPage();
        qdPage.ilkLoginLinki.click();
        extentTest.info("ilk login linkine tiklandi");

        //gecerli kullanici adi ve password ile giris yapin
        qdPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        extentTest.info("gecerli emIL YAZILDI");
        qdPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecersliPassword"));
        extentTest.info("gecerli password yazildi");
        qdPage.loginButonu.click();
        extentTest.info("logine tiklandi");
        // basarili girisi test edin
        Assert.assertTrue(qdPage.basariliGirisElementi.isDisplayed());
        extentTest.pass("basarili giris test yapildi");


    }
}

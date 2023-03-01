package tests.day11_POM_assertions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ZeroWebAppPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReuseableMethods;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

public class C06_SoftAssert {
    @Test
    public void webappTesti(){

        // 1. “http://zero.webappsecurity.com/” Adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("zeroUrl"));

        // 2. Sign in butonuna basin
        ZeroWebAppPage zeroWebAppPage = new ZeroWebAppPage();
        zeroWebAppPage.signInButonu.click();

        // 3. Login kutusuna “username” yazin
        zeroWebAppPage.usernameKutusu.sendKeys("username");

        // 4. Password kutusuna “password” yazin
        zeroWebAppPage.passwordKutusu.sendKeys("password");

        // 5. Sign in tusuna basin
        zeroWebAppPage.signInSubmitButonu.click();

        // navigate.back yapin
        Driver.getDriver().navigate().back();

        // 6. Online banking menusu icinde Pay Bills sayfasina gidin
        zeroWebAppPage.onlineBanking.click();
        zeroWebAppPage.payBillLinki.click();

        // 7. “Purchase Foreign Currency” tusuna basin
        zeroWebAppPage.purchaseFCButonu.click();

        // 8. “Currency” drop down menusunden Eurozone’u secin
        Select select = new Select(zeroWebAppPage.currencyDropdown);
        ReuseableMethods.bekle(3);
        select.selectByVisibleText("Eurozone (euro)");

        // 9. soft assert kullanarak "Eurozone (euro)" secildigini test edin
        SoftAssert softAssert = new SoftAssert();
        String expectedSecim = "Eurozone (euro)";
        String actualSecim = select.getFirstSelectedOption().getText();

        softAssert.assertEquals(actualSecim,expectedSecim, "dropdownda eurozone secili degil");

        // 10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin
        // "Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"

        List<WebElement> optionsElementListesi = select.getOptions();
        List<String> actualOptionsStringList = ReuseableMethods.stringListeCevir(optionsElementListesi);

        String [] expectedArr ={"Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"};
        List<String> expectedOptionListesi = new ArrayList<>();

        for (String each : expectedArr) {
            expectedOptionListesi.add(each);
        }

        softAssert.assertEquals(actualOptionsStringList,expectedOptionListesi);


        softAssert.assertAll();
        Driver.closeDriver();
    }
}

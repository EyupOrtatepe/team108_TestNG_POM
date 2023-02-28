package tests.day10_TestNGFramework;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class C02_dependsOnMethods {

    /*
        priority oncelik belirler ama testleri bir birine baglamaz.
        eger bir test methodun calismasi baska bir test motoduna bagli ise
        bu durunmda dependsOnMethods kullanmak daa uygun olur

        dependsOnMethod siralama methodu degildir.
        once bagli oldugu methodu calistirir.
        ancak bu 2 method icin gecerlidir, 3 method calistirmaz.
        once bagli oldugu methodun calismaini ve PASSED olmasini bekler

        Eger bagli olunan method FAILED olursa bagli olan method calistirilmaz ignore edilir
     */
    // 3 test methodu olusturun
    // 1. amazona gidip gittiginizi test edin
    // 2. nutella aratip, sonucun nutella icerdigini test edin
    // 3. ilk urune click yapip, urun isminin nutella icerdigini test edin

    @Test
    public void amazonTesti(){

        Driver.getDriver().get("https://www.amazon.com");
        String expectedIcerik = "amazon";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedIcerik));
    }
    @Test (dependsOnMethods = "amazonTesti")
    public void nutellaTesti(){

        AmazonPage amazonPage = new AmazonPage();
        amazonPage.aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        String expectedIcerik = "Nutella";
        String actualSonucYazisi = amazonPage.aramaSonucElementi.getText();

        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));
    }
    @Test (dependsOnMethods = "nutellaTesti")
    public void ilkUrunTesti(){

        AmazonPage amazonPage = new AmazonPage();
        amazonPage.ilkUrun.click();

        String expected = "Nutella";
        String actualIsim = amazonPage.ilkUrunIsmi.getText();

        Assert.assertTrue(actualIsim.contains(expected));

        Driver.closeDriver();

    }
}

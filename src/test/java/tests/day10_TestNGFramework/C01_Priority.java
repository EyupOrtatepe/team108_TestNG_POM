package tests.day10_TestNGFramework;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class C01_Priority {
    /*
        TestNg test methodlari calistirirken standart olarak harf sirasina gore calisir.
        Ancak tetsNG siralamayi kontrol etmemizi saglar
        ayni priority ler harf sirasina gore calisir
        priority nin default degeri 0 dir
     */

    @Test (priority = 10)
    public void amazonTesti(){
        //Amazona gidip gittigimizi test edelim
        Driver.getDriver().get("https://www.amazon.com");
        String expectedIcerik = "amazon";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedIcerik));
        Driver.closeDriver();

    }
    @Test (priority = 5)
    public void wiseTesti(){
        //wisequarter a gidip gittiginizi test edelim
        Driver.getDriver().get("https://www.wisequarter.com");
        String expectedIcerik = "wisequarter";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedIcerik));
        Driver.closeDriver();
    }
    @Test (priority = -3)
    public void youtubeTesti(){
        //youtube a gidip gittiginizi test edelim
        Driver.getDriver().get("https://www.youtube.com");
        String expectedIcerik = "youtube";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedIcerik));
        Driver.closeDriver();
    }
}

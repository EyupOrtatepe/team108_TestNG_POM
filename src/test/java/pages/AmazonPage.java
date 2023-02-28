package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonPage {

    /*
        Pages classlari surekli kullandigimiz locateleri tekrar tekrar locate etmek
        zorunda kalmaktan kurtulmak icin kullanilir.

        Her pages classi Driver classinda olusturulan Driver i kullanir

        @FindBy notasyonunun Driver classindaki webDriver i kullanabilmesi icin
        bu class a tanitmak gerekiyor.

        Bunun icinher pages sayfasi ilk olusturuldugunda basinda parametresiz constructor
        olusturup icersinde driveri bu classa tanititiyoruz.
     */


    public AmazonPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (id="twotabsearchtextbox")
    public WebElement aramaKutusu;

    @FindBy(xpath= "//h1[@class='a-size-base s-desktop-toolbar a-text-normal']")
    public WebElement aramaSonucElementi;

    @FindBy(xpath = "(//img[@class='s-image'])[1]")
    public WebElement ilkUrun;

    @FindBy(xpath = "//span[@id='productTitle']")
    public WebElement ilkUrunIsmi;
}

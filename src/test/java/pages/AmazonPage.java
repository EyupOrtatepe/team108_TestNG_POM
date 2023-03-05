package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

        Bunun icin her pages sayfasi ilk olusturuldugunda basinda parametresiz constructor
        olusturup icerisinde driveri bu classa tanitiyoruz.
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

    public void amazonGoToEnd (){

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.END).perform();

    }
    public String getCellText(int satirNo, int sutunNo){


        String xpath = "//tr[" + satirNo + "]/td[" + sutunNo + "]";


        String cellText = Driver.getDriver().findElement(By.xpath(xpath)).getText();

        return cellText;

    }


}



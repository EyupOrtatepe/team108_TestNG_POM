package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

    public class Herokuapp {

    public Herokuapp(){PageFactory.initElements(Driver.getDriver(), this);}

    @FindBy(xpath = "//h3[text()='Opening a new window']")
    public WebElement openingText;

    @FindBy(xpath = "//a[@target='_blank'][1]")
    public WebElement hereButton;

    @FindBy(xpath = "//div[@class='example']")
        public WebElement newWindowText;



}

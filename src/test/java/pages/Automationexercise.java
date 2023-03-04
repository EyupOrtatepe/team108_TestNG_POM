package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import utilities.Driver;

public class Automationexercise {

    public Automationexercise(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@class='logo pull-left']")
    public WebElement logo;

    @FindBy(xpath = "//h2[text()='Subscription']")
    public WebElement subscription;

    @FindBy(xpath = "//div[@class='carousel-inner'][1]")
    public WebElement fullFledgedText;

    @FindBy(xpath = "//a[@id='scrollUp']")
    public WebElement upArrow;


}

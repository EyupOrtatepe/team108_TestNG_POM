package tests.Practice;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class DataProvider {


    @org.testng.annotations.DataProvider
    public static Object[][] AmazonSearchWords() {

        Object [][] arr ={{"Nutella"},{"Java"},{"Samsung"},{"Apple"}};

        return arr;
    }

    @Test(dataProvider = "AmazonSearchWords")
    public void searchTest(String keyWordToSearch){
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        AmazonPage amazonPage = new AmazonPage();
        amazonPage.aramaKutusu.sendKeys(keyWordToSearch + Keys.ENTER);

        String actualResultText = amazonPage.aramaSonucElementi.getText();

        Assert.assertTrue(actualResultText.contains(keyWordToSearch));




    }
}

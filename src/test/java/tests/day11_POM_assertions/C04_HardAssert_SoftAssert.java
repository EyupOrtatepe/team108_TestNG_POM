package tests.day11_POM_assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class C04_HardAssert_SoftAssert {

    @Test
    public void hardAssertiontest(){
        Assert.assertTrue(5>8);
        Assert.assertFalse(9==8);
        Assert.assertEquals(5,8);
        Assert.assertNotEquals(6,6);

    }
    @Test
    public void softAssertionTesti(){
        /*

         */
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(5>8, "true testi failed");
        softAssert.assertFalse(8==8, "false testi passed");
        softAssert.assertEquals(5,8);
        softAssert.assertNotEquals(6,6);

        softAssert.assertAll();
    }
}

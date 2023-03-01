package tests.day11_POM_assertions;

import org.testng.Assert;
import org.testng.annotations.Test;

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

        Assert.assertTrue(5>8);
        Assert.assertFalse(9==8);
        Assert.assertEquals(5,8);
        Assert.assertNotEquals(6,6);
    }
}

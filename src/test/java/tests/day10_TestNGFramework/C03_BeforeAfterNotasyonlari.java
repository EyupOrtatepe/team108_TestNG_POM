package tests.day10_TestNGFramework;

import org.testng.annotations.*;

public class C03_BeforeAfterNotasyonlari {

    /*
        Smoke Test
        Regression
        EndToEnd e2e Test

        Test: bir amac icin bir araya getirilmis test methodlari, classlari veya packageleri icerir.

        Test Suite : Birden fazla testin bir amac icin bir araya getirilmesidir.

        Test Hiyerarsisi :
            -Suite
            -Test
            -groups, package, classes, methods


     */
    @BeforeSuite
    public void beforeSuit(){
        System.out.println("beforeSuit");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("afterSuite");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("beforeTest");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("beforeClass");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("beforeMethod");
    }
    @Test
    public void test01(){
        System.out.println("test01");
    }
    @Test
    public void test02(){
        System.out.println("test02");
    }
    @Test
    public void test03(){
        System.out.println("test03");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("afterTest");
    }
    @AfterClass (groups = "smoke")
    public void afterClass(){
        System.out.println("afterClass");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("afterMethod");
    }
}

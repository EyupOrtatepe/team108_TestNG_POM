package tests.day12_xmlFiles;

import org.testng.annotations.Test;
import utilities.Driver;

public class C01_DriverSingletonPattern {

    @Test
    public void test01(){
        /*
            POM webDriver olarak Driver class indaki
            getDriver() methodunun kullanilmasi uzerine kurgulanmistir.

            Driver.getDriver();

            Driver classinin obje olusturularak kullanilmasini engellmek icin bir onlem alinmistir.

            Javada bir classdan obje olusturulmasini engellemek isterseniz
            SINGLETON PATTERN kullanabilirsiniz

            Singleton Pattern : Bir class dan obje olusturulmasini engellemek veya
                                sinirlamak icin kullanilan bir yontemdir.
                                Temel fikir obje olusturmak icin kullanilan
                                default constructor yerine gorunur bir constructor olusturup
                                bu constructorun access modifier ini private yapip
                                kullanilmasini ENGELLEMEKTIR.


         */

        //Driver objeDriver = new Driver();
    }
}

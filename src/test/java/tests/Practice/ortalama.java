package tests.Practice;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ortalama {
    public static void main(String[] args) {

        String[][] anketSonuclari = {{"20:30","2"},{"21:00","1"},{"21:30","5"},{"22:00","0"}};

        double saatlerToplami = 0;
        double oySayilariToplami = 0;

        for (String[] innerArray : anketSonuclari) {
            double saat = Double.parseDouble(innerArray[0].replaceAll(":",""));
            double oy = Double.parseDouble(innerArray[1].replaceAll(":",""));
            saatlerToplami += saat * oy;
            oySayilariToplami += oy;

        }
        double average = saatlerToplami / oySayilariToplami;

        DecimalFormat df = new DecimalFormat("00.##");
        String formattedTime = df.format(average/100);
        System.out.println("Ortalama saat : " + formattedTime);



    }
}

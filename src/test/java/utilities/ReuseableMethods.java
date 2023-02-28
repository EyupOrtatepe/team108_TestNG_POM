package utilities;

public class ReuseableMethods {

    public static void bekle(int saniye){

        try {
            Thread.sleep(saniye);
        } catch (InterruptedException e) {

        }
    }
}

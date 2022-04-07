import java.util.Random;

public class MyUtils {
    public double intervalDoubleRandom(double min, double max) {
        Random rnd = new Random();
        double i = rnd.nextDouble()*(max-min) + min;
        return i;
    }
}

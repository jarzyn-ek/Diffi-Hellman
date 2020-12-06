import java.util.concurrent.ThreadLocalRandom;

public class DiffiHellmanApp {

    public static void main(String[] args) {
        int n = 23; //BigPrimeNumberGenerator.generate();
        int g = 5; //PrimitiveRootGenerator.generate(n);
        System.out.println("n: " + n + " g: " + g);
        //czyli "x"
        int aPrivateKey = 6; //ThreadLocalRandom.current().nextInt(2, 20);
        System.out.println("x: " +  aPrivateKey);
        //czyli "X"
        int x = (int) (Math.pow(g,aPrivateKey) % n);
        //bPrivateKey -> "y"
        int bPrivateKey = 15; //ThreadLocalRandom.current().nextInt(2, 20);
        //"y" -> "Y"
        int y = (int) (Math.pow(g,bPrivateKey) % n);
        int aK = (int) (Math.pow(y,aPrivateKey) % n);
        int bK = (int) (Math.pow(x,bPrivateKey) % n);
        System.out.println("aK: " + aK);
        System.out.println("bK: " + bK);
    }
}

import java.math.BigInteger;
import java.util.concurrent.ThreadLocalRandom;

public class DiffiHellmanApp {

    public static void main(String[] args) {
        int n = BigPrimeNumberGenerator.generate();
        int g = PrimitiveRootGenerator.generate(n);

        BigInteger gBigInteger = BigInteger.valueOf(g);
        BigInteger nBigInteger = BigInteger.valueOf(n);

        System.out.println("n: " + n + " g: " + g);
        //czyli "x"
        int aPrivateKey = ThreadLocalRandom.current().nextInt(2, 20);
        System.out.println("aPrivateKey: " +  aPrivateKey);
        //czyli "X"
        BigInteger x = gBigInteger.pow(aPrivateKey).mod(nBigInteger);
        System.out.println("x: " + x);
        //bPrivateKey -> "y"
        int bPrivateKey = ThreadLocalRandom.current().nextInt(2, 20);
        System.out.println("bPrivateKey: " + bPrivateKey);
        //"y" -> "Y"

        BigInteger y = gBigInteger.pow(bPrivateKey).mod(nBigInteger);
        System.out.println("y: " + y);

        BigInteger aK = y.pow(aPrivateKey).mod(nBigInteger);
        BigInteger bK = x.pow(bPrivateKey).mod(nBigInteger);
        System.out.println("aK: " + aK);
        System.out.println("bK: " + bK);
    }

}

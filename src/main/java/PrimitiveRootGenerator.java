import java.math.BigInteger;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class PrimitiveRootGenerator {

    public static int checkIfPrimitiveRoot(int number, List<Integer> listOfFactors, int nNumber) {
        for (Integer factor : listOfFactors) {
            BigInteger x = BigInteger.valueOf(number).pow(factor);
            if (x.mod(BigInteger.valueOf(nNumber)).equals(BigInteger.ONE)) {
                return 0;
            }
        }
        return number;
    }



    public static int generate(int nNumber) {
        List<Integer> listOfFactors = new LinkedList<>();
        int mainPhi = nNumber - 1;
        int phi = mainPhi;
        if (phi%2==0) {
            listOfFactors.add(mainPhi/2);
            while (phi%2==0) {
                phi /= 2;
            }
        }
        for (int i=3; i <= Math.sqrt(phi) ; i += 2) {
            if (phi % i == 0) {
                listOfFactors.add(mainPhi/i);
                while (phi%i==0) {
                    phi /= i;
                }
            }
        }
        if (phi!=1) {
            listOfFactors.add(mainPhi/phi);
        }

        if (checkIfPrimitiveRoot(2,listOfFactors,nNumber)!=0) {
            return 2;
        }
        for (int i = 3; ;i+=2) {
            if (checkIfPrimitiveRoot(i,listOfFactors,nNumber)!=0) {
                return i;
            }
        }
    }
}

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class PrimitiveRootGenerator {

    public static int checkIfPrimitiveRoot(int randomNum, int nNumber) {
        Set<Integer> setOfModuloRests = new HashSet<Integer>();
        for (int i=1; i < nNumber; i++) {
            setOfModuloRests.add(i);
        }

        int firstRest = (int) (Math.pow(randomNum,1)%nNumber);
        if (setOfModuloRests.contains(firstRest)) {
            setOfModuloRests.remove(firstRest);
        }

        for (int i=2; ;i++) {
            int rest = (int) Math.pow(randomNum,i)%nNumber;
            if (setOfModuloRests.contains(rest)) {
                setOfModuloRests.remove(rest);
            }
            if (setOfModuloRests.isEmpty()) {
                return randomNum;
            }
            if (rest == firstRest) {
                return 0;
            }
        }
    }

    public static int generate(int nNumber) {
        int rootChecked = 0;
        int randomNum = 2;
        while (rootChecked==0) {
//            int randomNum = ThreadLocalRandom.current().nextInt(2, nNumber);
            rootChecked = checkIfPrimitiveRoot(randomNum,nNumber);
            randomNum += 1;
        }
        return rootChecked;
    }
}

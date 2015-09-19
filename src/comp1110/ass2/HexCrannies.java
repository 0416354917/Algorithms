package comp1110.ass2;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by SIQI on 24/08/15.
 */

public class HexCrannies extends HexGame {
    public static boolean CranniesJudge(String crannies) {
        int[] num = new int[6];
        String crannyNum;
        int upperBound = 176, lowerBound = 169;


        if (crannies.length() != 18) {
            return false;
        }

        for (int i = 0; i < crannies.length(); i = i + 3) {
            crannyNum = crannies.substring(i, i + 3);
            num[i / 3] = Integer.parseInt(crannyNum);
        }

        for (int j = 0; j < 5; j++) {
            for (int k = 1; k < 5 - j; k++) {
                if (num[k] > num[k + 1]) {
                    int tem = num[k];
                    num[k] = num[k + 1];
                    num[k + 1] = tem;
                }
            }
        }

        for (int i = 0; i < 6; i++) {

            if (num[i] >= lowerBound && num[i] <= upperBound) {
                lowerBound += 8;
                upperBound += 8;
            } else {
                return false;
            }
        }
        return true;
    }

}

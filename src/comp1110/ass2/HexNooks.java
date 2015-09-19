package comp1110.ass2;

import java.util.HashMap;

/**
 * Created by yushen on 26/08/2015.
 */
public class HexNooks extends HexGame{
    public static boolean NooksJudge(String nooks){
        if (nooks.length() != 72) {
            return false;
        }
        int[] numbers = new int[90];// store one triangle numbers which has 90 numbers
        int number = 8;// the first triangle and the smallest number
        String nookNum;
        int[] numberList = new int[18];
        int index = 0;
        HashMap surroundings = new HashMap();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j <= i; j++) {
                numbers[index] = number + j;// meige index duiying de shuzi
                surroundings.put(numbers[index], HexgetSurroundings.getSurroundings(numbers[index], i, 0));// mei yi ge triangle de 15 ge shuzi yiji zhouwei de 6 ge dian

                for (int k = 0; k < 5; k++) {//sheng xia 5 ge quyu de sanjianxing
                    numbers[index + (k + 1) * 15] = numbers[index] + (k + 1) * (2 + i);// the second triangle the first number,and math method
                    surroundings.put(numbers[index + (k + 1) * 15], HexgetSurroundings.getSurroundings(numbers[index + (k + 1) * 15], i, k + 1));// shengxia de dian de lingju
                }
                index++;
            }
            number = number + 6 * (i + 2);
        }
        ///belong to the right area
        for (int i = 0; i < nooks.length(); i = i + 4) {
            nookNum = nooks.substring(i, i + 3);// huo qu nooks de shuzi
            numberList[i / 4] = Integer.parseInt(nookNum);// nooks cundao shuzu
        }

        ///check orientation
        for (int i = 3; i < nooks.length(); i = i + 4) {
            char orientation = nooks.charAt(i);// jiang letter transfer to ascii value
            if (orientation >= 65 && orientation <= 70) {// judge juti de letter
            } else {
                return false;
            }
        }

        int distribution[] = {0, 0, 0, 0, 0, 0};//fen bie cun chu 6 ge qu yu de nooks de shuliang
        for (int i = 0; i < 18; i++) {
            for (int j = 0; j < 90; j++) {
                if (numberList[i] == numbers[j]) {
                    distribution[j / 15]++;//mei ge qu de nooks shuliang jia yi
                    break;
                }
            }
        }
        for (int j = 0; j < 6; j++) {//fen bie dui 6 ge quyu jinxing panduan nooks de shuliang
            if (distribution[j] != 3) {//ru guo yige quyu de nooks budengyu 3
                return false;
            }
        }
        ///check adjacency
        for(int i =0;i<17;i+=3){// mei san ge nooks bijiao yici
            int[] surroundings1=(int[])surroundings.get(numberList[i+1]);//
            int[] surroundings2=(int[])surroundings.get(numberList[i+2]);
            for(int j=0;j<6;j++){
                if(numberList[i]==surroundings1[j]||numberList[i]==surroundings2[j]||numberList[i+1]==surroundings2[j]){
                    return false;
                }
            }

        }

        return true;
    }
}

package comp1110.ass2;

/**
 * Created by yushen on 26/08/2015.
 */
public class HexgetSurroundings extends HexGame {

    public static int[] getSurroundings(int value,int i,int k) {
        int[] results=new int[6];
        results[0]=value-1;
        results[1]=value+1;
        results[2]=value+(i+2)*6+k;
        results[3]=value+(i+2)*6+1+k;
        results[4]=value-(i+1)*6-k;
        results[5]=value-(i+1)*6-1-k;
        return results;

    }
}

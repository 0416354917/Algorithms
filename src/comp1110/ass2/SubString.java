package comp1110.ass2;

/**
 * Created by SIQI on 24/08/15.
 */
import java.util.ArrayList;
import java.util.List;

public class SubString {
    public static List<String> subString(String num){
        List<String> list = new ArrayList<>();
        for(;num.length()>3;){
            list.add(num.substring(num.length()-3));
            num = num.substring(0,num.length()-3);
        }
        if(num.length()>0){
            list.add(num);
        }
        return list;
    }
    public static void main(String[] args){
        String s = "1242332435234523464256245645634564356345634653423342134";
        List<String> l = SubString.subString(s);
        for(String str :l){
            System.out.println(str);
        }
    }
}

package comp1110.ass2;

import java.util.Scanner;

/**
 * Created by SIQI on 24/08/15.
 */
public class Test {
    public static void main(String args[])
    {
        System.out.println("pleast input a number:");
        Scanner reader=new Scanner(System.in);
        String inpt;
        inpt=reader.next();
        int inptLength = inpt.length();
        int strLength;
        boolean b = true;
        if(inptLength%3 == 0)
        {
            strLength = inptLength/3;
        }
        else
        {
            b = false;
            strLength = (int)inptLength/3 + 1;
        }
        String[] str = new String[strLength];
        for(int i=0; i<str.length;i++)
        {
            if(b||(i!=str.length-1))
                str[i] = inpt.substring(3*i,3*i+3);
            else
                str[i] = inpt.substring(3*i);
        }
        for(int i=0;i<str.length;i++)
        {
            System.out.print(str[i] + "   ");
        }
        System.out.println();
    }
}

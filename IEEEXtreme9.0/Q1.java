import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
public static void main(String[] arg){
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNextLine()){
			
			try {
                long a0 = scanner.nextLong();
			    long a1 = length(a0);
				long result = caculation(a0, a1,0);
				System.out.println(result);
			} catch (Exception e) {
				break;
			}
		}
	}
	public static long caculation(long a0, long a1, int counter){
		counter++;
		if(a0 == a1){
			return counter;
		}
		return caculation(a1, length(a1), counter);
	}
	public static long length(long input){
		int length =0;
		
		if(input==0){
			return 1;
		}else{
			length =(int)(Math.log10(input)+1);
		}
		return length;
	}
}
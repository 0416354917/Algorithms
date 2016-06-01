import java.time.LocalDateTime;

/**
 * Java Interview Preparation.
 * 
 * @author Jun Chen
 *
 */
public class Main {

	/**
	 * #39. Reverse a string using recursion.
	 */
	public static String reverseString(String s) {
		if (s == null || s.length() <= 1)
			return s;
		else {
			return reverseString(s.substring(1)) + s.substring(0, 1);
		}
	}

	/**
	 * #42. Print current time of yesterday.
	 */
	public static void YesterdayCurrent() {
		LocalDateTime today = LocalDateTime.now();
		LocalDateTime yesterday = today.minusDays(1);
		System.out.println(yesterday);
	}

	public static void main(String[] args) {
		// #39:
		System.out.println(reverseString("apple"));

		// #42:
		YesterdayCurrent();

		char ch = '去';
		System.out.println(Integer.toBinaryString(new Integer((int) ch)));

	}

}

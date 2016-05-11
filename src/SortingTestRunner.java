import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import interview.SortingTest;

public class SortingTestRunner {

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(SortingTest.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		System.out.println(result.wasSuccessful());

	}

}

package comp6710.studyevent.room2;

import java.sql.Time;
import java.util.HashMap;

public class MyCarpark implements Carpark {

	int ticketId = 0;

	HashMap<Integer, Time> enterLog;
	HashMap<Integer, Time> exitLog;

	@Override
	public void enter(Time time, int ticketId) {
		enterLog.put(ticketId, time);
	}

	@Override
	public void exit(Time time, int ticketId) {
		exitLog.put(ticketId, time);
	}

	@Override
	public void printReport() {
		Long meanTime = 0L;
		for (int id : exitLog.keySet()) {
			meanTime += exitLog.get(id).getTime() - enterLog.get(id).getTime();
		}
		meanTime /= (long) (60 * Math.pow(10, 6)); // unit of meanTime: minutes.
		System.out.println("The mean length of time a car stays in the carpark is: " + meanTime + " minutes.");
		System.out.println("The number of cars that used used the carpark: " + enterLog.keySet().size() + ".");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

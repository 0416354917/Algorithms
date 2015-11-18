package comp6710.studyevent.room2;

import java.sql.Time;

public interface Carpark {
	public void enter(Time time, int ticketId);

	public void exit(Time time, int ticketId);

	public void printReport();
}

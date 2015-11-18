package comp6710.studyevent.room2;

import java.util.ArrayList;
import java.util.HashMap;

public interface VendingMachine {
	public void restockItems(ArrayList<Item> itemsList);

	public float sellItem(float money, String code);

	public void printRestockReport(HashMap<String, Integer> targetStock);
}

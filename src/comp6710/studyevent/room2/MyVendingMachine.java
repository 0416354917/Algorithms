package comp6710.studyevent.room2;

import java.util.ArrayList;
import java.util.HashMap;

public class MyVendingMachine implements VendingMachine {
	HashMap<String, Item> items;

	public MyVendingMachine() {
		items = new HashMap<String, Item>();
	}

	@Override
	public void restockItems(ArrayList<Item> itemsList) {
		for (Item item : itemsList) {
			if (!items.containsKey(item.getId()))
				items.put(item.getId(), item);
			else {
				int currentStock = items.get(item.getId()).getCurrentStock();
				int addStock = item.getCurrentStock();
				items.get(item.getId()).setCurrentStock(currentStock + addStock);
			}
		}
	}

	@Override
	public float sellItem(float money, String code) {
		float change = 0f;
		if (items.containsKey(code))
			change = money - items.get(code).getPrice();
		return change > 0 ? change : 0;
	}

	@Override
	public void printRestockReport(HashMap<String, Integer> targetStock) {
		for (String id : targetStock.keySet()) {
			int difference = targetStock.get(id) - items.get(id).getCurrentStock();
			if (difference > 0) {
				System.out.println("ID: " + items.get(id).getId() + " Name: " + items.get(id).getName()
						+ " quantity need to be restocked: " + difference);
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

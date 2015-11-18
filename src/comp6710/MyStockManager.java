package comp6710;

import java.util.HashMap;

public class MyStockManager implements StockManager {

	private HashMap<String, Item> items;

	public MyStockManager() {
		items = new HashMap<String, Item>();
	}

	public HashMap<String, Item> getItems() {
		return this.items;
	}

	@Override
	public void newItem(String sku, String name, double price, boolean bulk) {
		items.put(sku, new Item(sku, name, price, bulk));
	}

	@Override
	public void sale(String sku, double sold) {
		Item item = items.get(sku);
		item.setCurrentStock(item.getCurrentStock() - sold);
	}

	@Override
	public void addStock(String sku, double added) {
		// TODO Auto-generated method stub
		Item item = items.get(sku);
		item.setCurrentStock(item.getCurrentStock() + added);
	}

	@Override
	public void targetStock(String sku, double target) {
		// TODO Auto-generated method stub

	}

	@Override
	public double stockTake(String sku, double actual) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void printOrder() {
		for (String sku : this.items.keySet()) {
			Item item = this.items.get(sku);
			double difference = item.getTargetStock() - item.getCurrentStock();
			System.out.println("SKU: " + sku + ", name: " + item.getName()
					+ ", amount needed to reach the target stock level: " + difference);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

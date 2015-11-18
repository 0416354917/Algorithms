package comp6710;

public interface StockManager {
	public void newItem(String sku, String name, double price, boolean bulk);

	public void sale(String sku, double sold);

	public void addStock(String sku, double added);

	public void targetStock(String sku, double target);

	public double stockTake(String sku, double actual);

	public void printOrder();
}

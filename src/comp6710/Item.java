package comp6710;

public class Item {

	private String sku;
	private double currentStock;
	private double targetStock;
	private String name;
	private double price;
	private String description;
	private boolean bulk;

	public Item(String sku, String name, double price, boolean bulk) {
		this.sku = sku;
		this.name = name;
		this.price = price;
		this.bulk = bulk;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public double getCurrentStock() {
		return currentStock;
	}

	public void setCurrentStock(double currentStock) {
		this.currentStock = currentStock;
	}

	public double getTargetStock() {
		return targetStock;
	}

	public void setTargetStock(double targetStock) {
		this.targetStock = targetStock;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isBulk() {
		return bulk;
	}

	public void setBulk(boolean bulk) {
		this.bulk = bulk;
	}

}

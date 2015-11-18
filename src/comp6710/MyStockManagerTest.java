package comp6710;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MyStockManagerTest {

	@Test
	public void testSale() {
		MyStockManager stockManager = new MyStockManager();
		stockManager.newItem("ABC", "Avocado", 25.0, true);
		Item item = stockManager.getItems().get("ABC");
		item.setCurrentStock(20.0);
		assertEquals(20.0, stockManager.getItems().get("ABC").getCurrentStock(), 0.000001);
		stockManager.sale("ABC", 1.0);
		assertEquals(19.0, stockManager.getItems().get("ABC").getCurrentStock(), 0.000001);
	}

}

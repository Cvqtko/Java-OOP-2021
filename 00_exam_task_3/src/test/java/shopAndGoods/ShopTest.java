package shopAndGoods;

import javax.naming.OperationNotSupportedException;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class ShopTest {
	private static final String goodsName = "Good";
	private static final String goodsCode = "123";
	private Goods goods;
	private Shop shop;

	@Before
	public void setUp() {
		this.shop = new Shop();
		this.goods = new Goods(goodsName, goodsCode);
	}

	@Test
	public void testConstructorShouldCreateShopWithTwelveShelves() {
		Assert.assertEquals(12, shop.getShelves().size());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddShelvShouldThrowException() throws OperationNotSupportedException, IllegalArgumentException {
		shop.addGoods("Shelves13", this.goods);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddShelvShouldThrowExceptionWhenShelveTaken()
			throws OperationNotSupportedException, IllegalArgumentException {
		shop.addGoods("Shelves12", this.goods);
		shop.addGoods("Shelves12", this.goods);
	}

//	@Test(expected = OperationNotSupportedException.class)
//	public void testAddShelvShouldThrowExceptionWhenItemExist() {
//		shop.addGoods("Shelves12", this.goods);
//		Goods goods2 = new Goods("Good2","132");
//		shop.addGoods("Shelves12", goods2);
//	}

	@Test(expected = IllegalArgumentException.class)
	public void testRemoveGoodsShouldThrowIfShelfDoesNotExist() {
		shop.removeGoods("Shelves13", goods);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRemoveGoodsShouldThrowIfItemDoesNotExist()
			throws OperationNotSupportedException, IllegalArgumentException {
		Goods goods2 = new Goods("Good2", "132");
		shop.addGoods("Shelves12", goods);
		shop.removeGoods("Shelves12", goods2);
	}

	@Test
	public void testRemoveGoodsShouldSetItemToNull() throws OperationNotSupportedException, IllegalArgumentException {
		shop.addGoods("Shelves12", goods);
		shop.removeGoods("Shelves12", goods);
		Assert.assertEquals(null, this.shop.getShelves().get("Shelves12"));
	}

	@Test
	public void testRemoveGoodsShouldReturnCorrectMessage()
			throws OperationNotSupportedException, IllegalArgumentException {
		shop.addGoods("Shelves12", goods);
		String message = String.format("Goods: %s is removed successfully!", goodsCode);

		Assert.assertEquals(message, shop.removeGoods("Shelves12", goods));

	}
}

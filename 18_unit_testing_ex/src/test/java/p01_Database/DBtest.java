package p01_Database;

import javax.naming.OperationNotSupportedException;

import org.junit.Assert;
import org.junit.Test;


class DBtest {

	@Test
	public void when_coreectElementsArePassed_then_createDBInstance() throws OperationNotSupportedException {

		// arrange
		Integer[] elements = new Integer[] { 4, 5, 632, 4, 2, 1, 45 };

		// act
		Database database = new Database(elements);

		// assert
		Assert.assertEquals(elements.length, database.getElements().length);
		Assert.assertArrayEquals(elements, database.getElements());
	}
	
	@Test(expected = OperationNotSupportedException.class)
	public void when_elementsMoreThanSixteenPassedToConstructor_then_exceptionIsThrown() throws OperationNotSupportedException {
		Integer[] elements = new Integer[17];
		Database database = new Database(elements);
	}
	
	@Test(expected = OperationNotSupportedException.class)
	public void when_elementsLessThanOnePassedToConstructor_than_exceptionIsThrown() throws OperationNotSupportedException {
		Database database = new Database();
	}
}

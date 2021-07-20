package p01_Database;

import org.junit.jupiter.api.Test;

import javax.naming.OperationNotSupportedException;

import org.junit.Assert;

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
}

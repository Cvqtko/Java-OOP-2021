
public class ListIteratorTest {

	private ListIterator listIterator;
	private static final String[] DATA = { "Desi", "Ivo", "Stoyan", "Iliyan", "Vladislav" };

	@Before
	public void setUp() throws OperationNotSupportedException {
		listIterator = new ListIterator(DATA);
	}

	// конструктора
	// 1. ако подавам null
	@Test(expected = OperationNotSupportedException.class)
	public void testConstructorWithNullParam() throws OperationNotSupportedException {
		new ListIterator(null);
	}

	// hasNext and move
	@Test
	public void testHasNextAndMove() {
		// current = 0 -> {"Desi", "Ivo", "Stoyan", "Iliyan", "Vladislav"};
		Assert.assertTrue(listIterator.hasNext());
		Assert.assertTrue(listIterator.move());
		// current = 1
		Assert.assertTrue(listIterator.hasNext());
		Assert.assertTrue(listIterator.move());
		// current = 2
		Assert.assertTrue(listIterator.hasNext());
		Assert.assertTrue(listIterator.move());
		// current = 3
		Assert.assertTrue(listIterator.hasNext());
		Assert.assertTrue(listIterator.move());
		// current = 4
		Assert.assertFalse(listIterator.hasNext());
		Assert.assertFalse(listIterator.move());
	}

	// print
	// 1. ако няма елементи
	@Test(expected = IllegalStateException.class)
	public void testPrintEmptyList() throws OperationNotSupportedException {
		ListIterator listIterator = new ListIterator();
		listIterator.print();
	}

	// 2. ако има елементи
	@Test
	public void testPrintCorrectly() {
		// current = 0 -> {"Desi", "Ivo", "Stoyan", "Iliyan", "Vladislav"};
		int index = 0; // елементите на DATA
		while (listIterator.hasNext()) {
			Assert.assertEquals(listIterator.print(), DATA[index]);
			index++;
			listIterator.move();
		}
	}
}
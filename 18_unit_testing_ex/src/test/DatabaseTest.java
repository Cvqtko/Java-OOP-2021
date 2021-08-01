import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p01_Database.Database;
 
import javax.naming.OperationNotSupportedException;
 
public class DatabaseTest {
 
    private Database database;
    private static final Integer[] NUMBERS = {5, 8, 20, 67, 98};
 
    @Before
    public void prepareDatabase() throws OperationNotSupportedException {
        database = new Database(NUMBERS);
    }
 
    //тестваме конструктора
    //1. дали ми създава правилно обект
    @Test
    public void testConstructorHasToCreateValidObject() {
        //взема елементите на създания обект -> проверка дали са същите, които зададох
        Integer[] databaseElements = database.getElements();
        //проверихме дали броя на елементите е еднакъв
        Assert.assertEquals("Count of elements is incorrect.", databaseElements.length, NUMBERS.length);
        for (int i = 0; i < databaseElements.length; i++) {
            Assert.assertEquals("Arrays are not the same!", NUMBERS[i], databaseElements[i]);
        }
    }
 
    //2. елементите > 16
    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowWhenUseMoreThanSixteenElements() throws OperationNotSupportedException {
        Integer[] numbers = new Integer[17];
        new Database(numbers);
    }
 
    //3. елементите < 1
    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowWhenUseLessThanOneElement() throws OperationNotSupportedException {
        Integer[] numbers = new Integer[0];
        new Database(numbers);
    }
 
    //тестваме add
    //1. ако подадения елемент е null
    @Test(expected = OperationNotSupportedException.class)
    public void testAddShouldThrowWhenParamNull() throws OperationNotSupportedException {
        database.add(null);
    }
    //2. ако подадения елемент не е null -> успешно го добавя към спиксъка
    @Test
    public void testAddShouldAddElement() throws OperationNotSupportedException {
        //{5, 8, 20, 67, 98}
        database.add(7);
        //{5, 8, 20, 67, 98, 7}
        Assert.assertEquals(database.getElements().length, NUMBERS.length + 1);
        Assert.assertEquals(database.getElements()[database.getElements().length - 1], Integer.valueOf(7));
    }
 
    //тестваме remove
    //1. да нямаме елементи в масива
    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveShouldThrowWithEmptyData() throws OperationNotSupportedException {
        // премахнем всички същестуващи елементи
        for (int i = 0; i < NUMBERS.length; i++) {
            database.remove();
        }
        //[]
        //remove
        database.remove();
    }
 
    //2. дали правилно премахва елемент
    @Test
    public void testRemoveLastElement() throws OperationNotSupportedException {
        //{5, 8, 20, 67, 98}
        database.remove();
 
        Integer[] elementsInDatabase = database.getElements();  //5, 8, 20, 67
        Assert.assertEquals(elementsInDatabase.length, NUMBERS.length - 1);
        Assert.assertEquals(elementsInDatabase[elementsInDatabase.length - 1], Integer.valueOf(67));
    }
}
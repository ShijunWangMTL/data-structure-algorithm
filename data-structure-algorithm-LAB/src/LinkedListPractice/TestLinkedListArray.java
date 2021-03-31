package LinkedListPractice;

import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

public class TestLinkedListArray {
    LinkedListArrayOfStrings test = new LinkedListArrayOfStrings();

    @Test
    public void testGetSize() {
        Assert.assertEquals(0, test.getSize());
        test.add("first container");
        Assert.assertEquals(1, test.getSize());
    }

    @Test
    public void testAddToFront(){
        test.add("first container");
        Assert.assertEquals("first container", test.get(0));
    }

    @Test
    public void testAddToEnd(){
        test.add("first container");
        test.add("last container");
        Assert.assertEquals("last container", test.get(test.getSize()-1));
    }

    @Test
    public void testGet(){
        test.add("first container");
        test.add("last container");
        Assert.assertEquals("last container", test.get(1));
    }

    @Test
    public void testInsertValueAtIndex(){
        test.add("first container");
        test.add("last container");
        test.insertValueAtIndex(1, "at index one");
        Assert.assertEquals("at index one", test.get(1));
    }

    @Test
    public void testDeleteByIndex(){
        test.add("0");
        test.add("last");
        test.insertValueAtIndex(1, "new value");
        test.deleteByIndex(2);
        String expected = "[0, new value]";
        Assert.assertEquals(expected, test.toString());
    }

    @Test
    public void testDeleteByValue(){
        test.add("0"); // 0
        test.add("last"); // 0, last
        test.insertValueAtIndex(1, "ADD"); //0, ADD, last
        test.add("ADD"); //ADD, 0, ADD, last
        test.deleteByValue("ADD"); //0, ADD, last
        String expected = "[0, ADD, last]";
        Assert.assertEquals(expected, test.toString());
    }

    @Test
    public void testToString(){
        test.add("0");
        test.add("last");
        test.insertValueAtIndex(1, "1");
        String expected = "[0, 1, last]";
        Assert.assertEquals(expected, test.toString());
    }

    @Test
    public void testToArray(){
        test.add("0");
        test.add("last");
        test.insertValueAtIndex(1, "1");
        String[] expected = new String[]{"0", "1", "last"};
        Assert.assertArrayEquals(expected, test.toArray());
    }

}

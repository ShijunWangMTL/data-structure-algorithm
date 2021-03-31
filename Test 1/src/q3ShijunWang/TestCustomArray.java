package q3ShijunWang;

import org.junit.Assert;
import org.junit.Test;

public class TestCustomArray {
    CustomArrayOfInts testArr = new CustomArrayOfInts();

    @Test
    public void testAddAll() {
        testArr.add(2);
        testArr.add(12);
        testArr.add(55); // data capacity: 4; real items: 3
        int[] tobeAdd = new int[]{66, 31, 77, 99};
        testArr.addAll(tobeAdd);

        int size = testArr.size();  // size should be 7
        Assert.assertEquals(7, size);

        String expected = "[2, 12, 55, 66, 31, 77, 99]";
        Assert.assertEquals(expected, testArr.toString());
    }

    @Test
    public void testAddAllFalse() {
        int[] emptyArr = new int[]{};
        boolean result = testArr.addAll(emptyArr);  // add an empty array, return false
        Assert.assertFalse(result);
    }

    @Test(expected = NullPointerException.class)
    public void testNullPointerException() {
        int[] intArr = null;
        testArr.addAll(intArr);
    }

}

package ArrayListPractice;

import org.junit.Assert;
import org.junit.Test;

public class TestCustomArrayOfInts {
    CustomArrayOfInts testArr = new CustomArrayOfInts();

    @Test
    public void testSize() {
        int size = testArr.size();
        Assert.assertEquals(0, size);
    }

    @Test
    public void testAdd() {
        testArr.add(2);
        testArr.add(20);
        int size = testArr.size();
        Assert.assertEquals(2, size);
    }

    @Test
    public void testDeleteByIndex() {
        testArr.add(2); // size: 1, index: 0
        testArr.add(4); // size: 2, index: 1
        testArr.add(7); // size: 3, index: 2
        testArr.deleteByIndex(1); // value: 2
        //test 1:
        int size = testArr.size();
        Assert.assertEquals(2, size);
        //test 2:
        //int result = testArr.get(2);
        //Assert.assertEquals(0, result);

        String expected = "[2, 7, 0, 0]";
        String resultStr = testArr.toString();
        Assert.assertEquals(expected, resultStr);
    }

    @Test
    public void testDeleteByValue() {
        testArr.add(2); // size: 1, index: 0
        testArr.add(4); // size: 2, index: 1
        testArr.add(4); // size: 3, index: 2
        testArr.add(7); // size: 4, index: 3
        //test 1:
        boolean result = testArr.deleteByValue(4); // index: 0, result: true
        Assert.assertFalse(result == false);
        //test 2:
        int size = testArr.size(); //3
        Assert.assertEquals(3, size);
        //test 3:
        int atIndex2 = testArr.get(2); //7
        Assert.assertEquals(7, atIndex2);
    }

    @Test
    public void testInsertValueAtIndex() {
        testArr.add(2); // size: 1, index: 0
        testArr.add(4); // size: 2, index: 1
      //  testArr.add(7); // size: 3, index: 2
        testArr.insertValueAtIndex(10, 0);
        //test 1:
        String expected = "[10, 2, 4, 0]";
        String result = testArr.toString();
        Assert.assertEquals(expected, result);
        //test 2:
        int size = testArr.size();
        Assert.assertEquals(3, size);
    }

    @Test
    public void testClear() {
        testArr.add(2); // size: 1, index: 0
        testArr.add(4); // size: 2, index: 1
        testArr.add(7); // size: 3, index: 2
        testArr.add(12); // size: 4, index: 3
        testArr.clear();
        int size = testArr.size();
        Assert.assertEquals(0, size);
    }

    @Test
    public void testGet() {
        testArr.add(33); // siez: 1,index: 0
        int result = testArr.get(0);
        Assert.assertEquals(33, result);
    }

    @Test
    public void testGetSlice() {
        testArr.add(2); // size: 1, index: 0
        testArr.add(4); // size: 2, index: 1
        testArr.add(7); // size: 3, index: 2
        testArr.add(12); // size: 4, index: 3
        testArr.add(3); // size: 5, index: 4
        int[] result = testArr.getSlice(1, 3);
        int[] compare = new int[]{4, 7, 12};
        Assert.assertArrayEquals(compare, result);
    }

    @Test
    public void testToString() {
        testArr.add(2); // size: 1, index: 0
        testArr.add(4); // size: 2, index: 1
        testArr.add(7); // size: 3, index: 2
        testArr.add(12); // size: 4, index: 3
        testArr.add(3); // size: 5, index: 4
        // size is 5. length is 8.
        String expected = "[2, 4, 7, 12, 3, 0, 0, 0]";
        String result = testArr.toString();
        Assert.assertEquals(expected, result);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIndexOutOfBoundsException() {
        //test 1:
        int result = testArr.get(2);
        //test 2:
        testArr.add(2); // size: 1, index: 0
        testArr.add(4); // size: 2, index: 1
        testArr.add(7); // size: 3, index: 2
        testArr.add(12); // size: 4, index: 3
        testArr.add(3); // size: 5, index: 4
        int[] slice = testArr.getSlice(3, 3);
    }

}

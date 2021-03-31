package tests;

import Recursion.App;
import org.junit.Assert;
import org.junit.Test;

public class RecursionTest {
    @Test
    public void testChangeXY() {
        String output = App.changeXY("ccccxrxy");
        Assert.assertEquals("ccccyryy", output);
    }
    @Test
    public void testCountChar() {
        int result = App.countChars("hihihih");
        Assert.assertEquals(3, result);
    }

    @Test
    public void testPow(){
        double result = App.pow(2,3);
        Assert.assertEquals(8, result); //???
    }
}

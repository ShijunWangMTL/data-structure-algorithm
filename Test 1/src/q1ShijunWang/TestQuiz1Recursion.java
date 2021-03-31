package q1ShijunWang;

import org.junit.Assert;
import org.junit.Test;

public class TestQuiz1Recursion {
    Quiz1Recursion test = new Quiz1Recursion();

    @Test
    public void testAddPound() {
        String output1 = test.AddPound("program");
        Assert.assertEquals("p#r#o#g#r#a#m", output1);

        String output2 = test.AddPound("abc");
        Assert.assertEquals("a#b#c", output2);

        String output3 = test.AddPound("ab");
        Assert.assertEquals("a#b", output3);

        String output4 = test.AddPound("");
        Assert.assertEquals("", output4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalArgumentException(){
        String str = null;
        test.AddPound(str);
    }

}

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test1() {
        String s = "QWER";
        int expected = 0;
        int actual = new Solution().balancedString(s);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        String s = "QQWE";
        int expected = 1;
        int actual = new Solution().balancedString(s);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        String s = "QQQW";
        int expected = 2;
        int actual = new Solution().balancedString(s);

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void test4() {
        String s = "WWEQERQWQWWRWWERQWEQ";
        int expected = 4;
        int actual = new Solution().balancedString(s);

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void test5() {
        String s = "WQWRQQQW";
        int expected = 3;
        int actual = new Solution().balancedString(s);

        Assert.assertEquals(expected, actual);
    }
}

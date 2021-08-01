package test.java;

import general.array.PalindromeRearranging;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PalindromeRearrangingTest {
    @Test
    public void doTest(){
        assertFalse(new PalindromeRearranging().palindromeRearranging("aabc"));
        assertFalse(new PalindromeRearranging().palindromeRearranging("abca"));
        assertTrue(new PalindromeRearranging().palindromeRearranging("aa"));
        assertTrue(new PalindromeRearranging().palindromeRearranging("aaccbbdidi"));
    }
}

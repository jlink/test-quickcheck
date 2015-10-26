package caesar;

import com.pholser.junit.quickcheck.ForAll;
import com.pholser.junit.quickcheck.generator.InRange;
import org.junit.Before;
import org.junit.Test;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import static org.junit.Assume.*;

@RunWith(Theories.class)
public class CharacterEncryptionTest {

    private CaesarCipher cipher;

    @Before
    public void setUp() throws Exception {
        cipher = new CaesarCipher();
    }

    @Theory
    public void encryptWithKey0(@ForAll @InRange(min = "a", max = "z") char toEncrypt) {
//        assumeTrue(toEncrypt >= 'a' && toEncrypt <= 'z');
        assertEquals(toEncrypt, cipher.encryptChar(toEncrypt, 0));
    }

    @Test
    public void encryptWithoutOverflow() {
        assertEquals('b', cipher.encryptChar('a', 1));
        assertEquals('z', cipher.encryptChar('a', 25));
    }

    @Test
    public void encryptWithOverflow() {
        assertEquals('a', cipher.encryptChar('z', 1));
        assertEquals('k', cipher.encryptChar('x', 13));
    }

    @Theory
    public void encryptAnyCharWithAnyKey(
            @ForAll @InRange(min = "a", max = "z") char toEncrypt,
            @ForAll @InRange(min = "0", max = "" + CaesarCipher.LENGTH_OF_ALPHABET) int key) { //String.valueOf does not work in annotation
        char result = cipher.encryptChar(toEncrypt, key);
        assertTrue(result >= 'a' && result <= 'z');
    }

}

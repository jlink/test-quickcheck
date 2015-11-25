package caesar;

import static org.junit.Assert.*;

import com.pholser.junit.quickcheck.ForAll;
import com.pholser.junit.quickcheck.generator.InRange;
import org.junit.Before;
import org.junit.Test;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class CharacterEncryptionTest {

	private CaesarCipher cipher;

	@Before
	public void setUp() throws Exception {
		cipher = new CaesarCipher();
	}

	@Theory
	public void encryptWithKey0(@ForAll @InRange(minChar = 'a', maxChar = 'z') char toEncrypt) {
		// assumeTrue(toEncrypt >= 'a' && toEncrypt <= 'z');
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
	public void encryptingAnyCharWithAnyKeyShouldAlwaysReturnAValidChar(
			@ForAll @InRange(minChar = 'a', maxChar = 'z') char toEncrypt,
			@ForAll @InRange(minInt = 0, maxInt = CaesarCipher.LENGTH_OF_ALPHABET) int key) {
		char result = cipher.encryptChar(toEncrypt, key);
		assertTrue(result >= 'a' && result <= 'z');
	}

}

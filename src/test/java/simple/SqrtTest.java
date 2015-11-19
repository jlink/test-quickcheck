
package simple;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.ForAll;
import com.pholser.junit.quickcheck.generator.InRange;

@RunWith(Theories.class)
public class SqrtTest {

	@Theory
	public void forPositiveNumbers(@ForAll(sampleSize = 10000) double positiveNumber) {
		Assume.assumeTrue(positiveNumber >= 0);

		double root = Math.sqrt(positiveNumber);
		Assert.assertTrue(root >= 0.0);

		double square = root * root;
		Assert.assertEquals(positiveNumber, square, 1e-15);
	}
}
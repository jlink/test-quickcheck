package cheeses;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.ForAll;
import com.pholser.junit.quickcheck.From;

@RunWith(Theories.class)
public class CheeseDisplayerTest {

	@Theory
	public void onlyFirst50CharactersOfCheeseNameAreDisplayed(@ForAll(sampleSize = 100) @From(CheeseGenerator.class) Cheese cheese) {
		//Assume.assumeTrue(cheese.getName().contains("cheese"));
		String label = "CHEESE: ";
		String display = displayCheese(label, cheese);

		int expectedDisplayLength = Math.min(cheese.getName().length() + label.length(), 50);
		assertDisplayLength(cheese, display, expectedDisplayLength);
	}

	private void assertDisplayLength(@ForAll(sampleSize = 20) @From(CheeseGenerator.class) Cheese cheese,
			String display, int expectedDisplayLength) {
		String failureMessage = String.format("Wrong display length for cheesename of length %s:", cheese.getName().length());
		Assert.assertEquals(failureMessage, expectedDisplayLength, display.length());
	}

	/**
	 * The function under test
	 */
	public static String displayCheese(String label, Cheese cheese) {
		String displayName = cheese.getName();
		if (displayName.length() > 49) {
			displayName = displayName.substring(0, 49);
		}
		return label + displayName;
	}
}

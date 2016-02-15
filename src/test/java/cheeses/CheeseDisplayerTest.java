
package cheeses;

import com.pholser.junit.quickcheck.ForAll;
import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.Assert;
import org.junit.runner.RunWith;

@RunWith(JUnitQuickcheck.class)
public class CheeseDisplayerTest {

    @Property(shrink = true)
	public void onlyFirst50CharactersOfCheeseNameAreDisplayed(
			@From(CheeseGenerator.class) Cheese cheese) {
		//Assume.assumeTrue(cheese.getName().contains("cheese"));
		String label = "CHEESE: ";
		String display = displayCheese(label, cheese);

		int expectedDisplayLength = Math.min(cheese.getName().length() + label.length(), 50);
		assertDisplayLength(cheese, display, expectedDisplayLength);
	}

	private void assertDisplayLength(@ForAll(sampleSize = 20) @From(CheeseGenerator.class) Cheese cheese,
			String display, int expectedDisplayLength) {
		String failureMessage = String.format("Wrong display length for cheesename of length %s:",
			cheese.getName().length());
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

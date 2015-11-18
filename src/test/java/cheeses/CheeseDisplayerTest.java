package cheeses;

import org.junit.Assert;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.ForAll;
import com.pholser.junit.quickcheck.From;

@RunWith(Theories.class)
public class CheeseDisplayerTest {

	@Theory
	public void canHandleNamesUpToLengthOf50(@ForAll @From(CheeseGenerator.class) Cheese cheese) {
		String label = "CHEESE: ";
		String display = displayCheese(label, cheese);
		Assert.assertEquals("Wrong display length", cheese.getName().length() + label.length(), display.length());
	}

	private String displayCheese(String label, Cheese cheese) {
		String displayName = cheese.getName();
		if (displayName.length() > 20) {
			displayName = displayName.substring(0, 20);
		}
		return label + displayName;
	}
}

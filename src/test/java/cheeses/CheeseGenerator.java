package cheeses;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

public class CheeseGenerator extends Generator<Cheese> {

	private static final String ALL_MY_CHARS = "abcdefghijklmnopqrstuvwxyz ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final int MAX_NAME_LENGTH = 100;

	public CheeseGenerator(Class<Cheese> type) {
		super(type);
	}

	@Override
	public Cheese generate(SourceOfRandomness random, GenerationStatus status) {
		String randomName = generateRandomName(random);
		int randomPrice = random.nextInt(1, 1000);
		return new Cheese(randomName, randomPrice);
	}

	private String generateRandomName(SourceOfRandomness random) {
		StringBuilder nameBuilder = new StringBuilder();
		int nextStringLength = random.nextInt(1, MAX_NAME_LENGTH);
		for (int i = 0; i < nextStringLength; i++) {
			int randomIndex = random.nextInt(ALL_MY_CHARS.length());
			nameBuilder.append(ALL_MY_CHARS.charAt(randomIndex));
		}
		return nameBuilder.toString();
	}
}

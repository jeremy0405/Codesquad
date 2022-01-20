package mission.cs.cs06;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberTest {

	@Test
	@DisplayName("완전수 테스트")
	void perfectTest() {
		ClassifierAlpha c = new ClassifierAlpha(6);
		assertTrue(c.isPerfect());
		c = new ClassifierAlpha(28);
		assertTrue(c.isPerfect());
		c = new ClassifierAlpha(10);
		assertFalse(c.isPerfect());
	}

	@Test
	@DisplayName("소수 테스트")
	void primeTest() {
		PrimeAlpha p = new PrimeAlpha(7);
		assertTrue(p.isPrime());
		p = new PrimeAlpha(5);
		assertTrue(p.isPrime());
		p = new PrimeAlpha(4);
		assertFalse(p.isPrime());
	}

	@Test
	@DisplayName("제곱수 테스트")
	void squaredTest() {
		SquaredAlpha s = new SquaredAlpha(25);
		assertTrue(s.isSquared());
		s= new SquaredAlpha(10);
		assertFalse(s.isSquared());
	}

	@Test
	@DisplayName("출력 테스트")
	void print() {

		String[] first = IntStream.rangeClosed(2, 100)
			.mapToObj(i -> new ClassifierAlpha(i).getString())
			.toArray(String[]::new);

		String[] second = IntStream.rangeClosed(2, 100)
			.mapToObj(i -> new PrimeAlpha(i).getString())
			.toArray(String[]::new);

		String[] third = IntStream.rangeClosed(2, 100)
			.mapToObj(i -> new SquaredAlpha(i).getString())
			.toArray(String[]::new);

		IntStream.rangeClosed(2, 100)
			.mapToObj(i -> i + " : " + first[i - 2] + second[i - 2] + third[i - 2])
			.forEach(System.out::println);
	}

}
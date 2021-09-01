package JunitTestsGradle;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class SumNumbersTest {

	private final SumNumbers obj=new SumNumbers();
	@RepeatedTest(10)
	void testSum() {
		assertEquals(5,obj.sum(2, 3));
	}
	@Test
	void testSumNegative() {
		assertEquals(10,obj.sum(6, 4));
	}
}

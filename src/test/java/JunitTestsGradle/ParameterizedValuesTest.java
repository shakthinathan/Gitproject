package JunitTestsGradle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

public class ParameterizedValuesTest {

	private final SumNumbers obj=new SumNumbers();
	public static int[][] getdata(){
		return new int[][] {{1,2,3},{5,3,8},{6,7,13}};
	}
	
	@ParameterizedTest
	@MethodSource("getdata")
	void testWithStringParameter(int[] data)
	{
		int a=data[0];
		int b=data[1];
		int sum=data[2];
		assertEquals(sum,obj.sum(a, b));
	}
	
	@ParameterizedTest
	@EnumSource(
	value=TimeUnit.class,
	names= {"NANOSECONDS","MICROSECONDS"})
	void withsomeEnumValues(TimeUnit Unit) {
		assertNotNull(Unit);
	}
	
	
	@DisplayName("Sum Method Test")
	@ParameterizedTest
	@CsvSource({"1,2,3","6,7,13","6,5,11"})
	void testwithCSV(int num1,int num2,int result) {
		assertEquals(result,obj.sum(num1, num2));
	}
	
	
	
	
	
	
}

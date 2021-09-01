package JunitTestsGradle;

public class SumNumbers {

	public int sum(int a, int b)
	{
		if(a>=12) {
			throw new IllegalArgumentException("Value should be less than 12");
		
		}
		return a+b;
	}
}

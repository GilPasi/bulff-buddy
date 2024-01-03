package utilities;

public class Validator {
	
	public static boolean isIntInRange(int bottom, int top, int numberToExamine)
	{
		if(bottom >= top)
		{
			throw new IllegalArgumentException("Top value cannot be lesser or equal to the bottom value");
		}
		
		return numberToExamine >= bottom && numberToExamine < top;
	}

}

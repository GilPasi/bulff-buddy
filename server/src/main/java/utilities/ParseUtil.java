package utilities;

import java.util.Arrays;

public class ParseUtil {
	
	public static <T> TryResult<T> tryParseName(String textToParse, T[] values)
	{
		TryResult<T> tryResult = new TryResult<T>();
		textToParse = textToParse.toUpperCase();
		
		for(T item : values)
		{
			if(textToParse.equals(item.toString()))
			{
				tryResult.setResult(item);
				return tryResult;
			}
		}
		tryResult.setMessage(String.format("The given text %s does not "
				+ "match any of the values %s", textToParse, Arrays.asList(values)));
		tryResult.setSuccess(false);
		return tryResult;	
	}

}

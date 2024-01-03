package com.github.gilpasi.bluffbuddy.server;
import java.text.ParseException;

import utilities.TryResult;
import utilities.Validator;

public enum Rank {
	ACE,TWO,THREE,
	FOUR,FIVE,SIX,
	SEVEN,EIGHT,NINE,
	TEN,JACK,QUEEN,KING;
	
	
	public static int getMinimumRank()
	{
		return ACE.ordinal()+ 1;
	}
	
	public static int getMaximumRank()
	{
		return KING.ordinal() + 1;
	}
	
	public static Rank Parse(String textToParse) throws ParseException
	{
		textToParse = textToParse.toUpperCase(); // Ignore case
		
		TryResult<Rank> tryResult = tryParseAsLetter(textToParse);
		
		if(tryResult.isSuccessful())
		{
			return tryResult.getResult();
		}
		
		tryResult = tryParseAsName(textToParse);
		
		if(tryResult.isSuccessful())
		{
			return tryResult.getResult();
		}
		
		tryResult = tryParseAsNumber(textToParse);
		
		if(tryResult.isSuccessful())
		{
			return tryResult.getResult();
		}
		
		throw new ParseException("The given text is neither a rank name, "
				+ "rank valid index nor a valid rank letter", 0);
	}
	
	
	private static TryResult<Rank> tryParseAsLetter(String textToParse)
	{
		TryResult<Rank> tryResult = new TryResult<Rank>();		
		switch (textToParse)
		{
			case "A":
				tryResult.setResult(ACE);
				break;
				
			case "K":
				tryResult.setResult(KING);
				break;				
				
			case "Q":
				tryResult.setResult(QUEEN);
				break;			
				
			case "J":
				tryResult.setResult(JACK);
				break;
				
			default:
				tryResult.setSuccess(false);
		}
		
		return tryResult;
	}
	
	
	
	//___TryParse Methods___//
	
	private static TryResult<Rank> tryParseAsNumber (String textToParse)
	{
		TryResult<Rank> tryResult = new TryResult<Rank>();		
		int rankIndex;
		
		try
		{
			rankIndex = Integer.parseInt(textToParse);//Might throw NumberFormatException
		}
		catch (NumberFormatException e)
		{
			tryResult.setMessage("The given text is not an integer");
			tryResult.setSuccess(false);
			return tryResult;
		}
		
		if(Validator.isIntInRange(getMinimumRank(), getMaximumRank() + 1, rankIndex))
		{
			tryResult.setResult(Rank.values()[rankIndex - 1]);
			tryResult.setSuccess(true);
			return tryResult;
		}
		else
		{
			tryResult.setSuccess(false);
			tryResult.setMessage(String.format("The given rank is not in range of cards %d-%d"
					,getMinimumRank(),getMaximumRank() + 1));
			return tryResult;
		}		
	}
	
	private static TryResult<Rank> tryParseAsName(String textToParse)
	{
		TryResult<Rank> tryResult = new TryResult<Rank>();
		
		for(Rank rank : Rank.values())
		{
			if(textToParse.equals(rank.toString()))
			{
				tryResult.setResult(rank);;
				return tryResult;
			}
		}
		tryResult.setMessage("The given text does not match any of the ranks");
		tryResult.setSuccess(false);
		return tryResult;
	}

}

package com.github.gilpasi.bluffbuddy.server;
import java.text.ParseException;

import utilities.ParseUtil;
import utilities.TryResult;
import utilities.Validator;

public enum Rank {
	TWO,THREE,
	FOUR,FIVE,SIX,
	SEVEN,EIGHT,NINE,
	TEN,JACK,QUEEN,KING,ACE;
	
	private static final int CARD_TO_INDEX_OFFSET = 2;
	//All cards has an offset of 2 from their actual index
	//as 2 is the lowest card in a deck
	
	
	public static int getMinimumRank()
	{
		return TWO.ordinal()+ 1;
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
		
		tryResult = ParseUtil.tryParseName(textToParse, values());
		
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
			
			tryResult.setResult(Rank.values()[rankIndex - CARD_TO_INDEX_OFFSET]);
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
}

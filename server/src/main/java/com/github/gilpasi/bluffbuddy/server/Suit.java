package com.github.gilpasi.bluffbuddy.server;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;

import utilities.ParseUtil;
import utilities.TryResult;

public enum Suit {
	HEARTS,DIAMONDS,CLUBS,SPADES;
	
	
	public static Suit Parse(String textToParse) throws ParseException
	{
		TryResult<Suit> tryResult = ParseUtil.tryParseName(textToParse, values());
		if(tryResult.isSuccessful())
		{
			return tryResult.getResult();
		}
		else
		{
			throw new ParseException(tryResult.getMessage(), 0);
		}
	}
}

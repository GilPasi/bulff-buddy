package com.github.gilpasi.bluffbuddy.server;

import java.awt.RadialGradientPaint;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
    	try {
			Rank rank =  Rank.Parse("9");
	    	System.out.println(rank);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
        List<Card> cards = Arrays.asList(
                new Card(Rank.ACE, Suit.CLUBS ),
                new Card(Rank.ACE, Suit.SPADES ),
                new Card(Rank.KING, Suit.HEARTS ),
                new Card(Rank.SEVEN, Suit.CLUBS )
        );
        
        Collections.sort(cards, Card.comparator());
        
        System.out.println(cards);
    }
}

package com.github.gilpasi.bluffbuddy.server;

public class Hand {
	final static int HAND_SIZE = 2;
	
	private Card[] cards = new Card[HAND_SIZE];
	
	public Hand(Card firstCard, Card secondCard)
	{
		if(firstCard == null || secondCard == null)
		{
			throw new NullPointerException("A hand cannot contain null cards");
		}
		cards[0] = firstCard;
		cards[1] = secondCard;
	}
	
	public Card getFirsCard()
	{
		return cards[0];
	}
	
	public Card getSecondCard()
	{
		return cards[1];
	}
	
	public void setFirstCard(Card firstCard)
	{
		cards[0] = firstCard;
	}
	
	public void setSecondCard(Card secondCard)
	{
		cards[1] = secondCard;
	}
	
	
	public int score(Board board) 
	{
		return 1;
	}
	

}

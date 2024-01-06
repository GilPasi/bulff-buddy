package com.github.gilpasi.bluffbuddy.server;

import java.util.Comparator;

public class CardComparator implements Comparator<Card> {
	
	@Override
	public int compare(Card card1, Card card2)
	{
		return card1.score() - card2.score();
	}
}

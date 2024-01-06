package com.github.gilpasi.bluffbuddy.server;

public class Card {
	//Immutable class
    private final Rank rank;
    private final Suit suit;
    
    private static CardComparator comparator = new CardComparator();
    private static final int WEIGHT_FACTOR = 10;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }
    
    public int score()
    {
    	return rank.ordinal() * WEIGHT_FACTOR + suit.ordinal();
    }
    
    public static CardComparator comparator()
    {
    	return comparator;
    }
    

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}

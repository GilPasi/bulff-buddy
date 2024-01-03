package com.github.gilpasi.bluffbuddy.server;

import java.text.ParseException;

public class App 
{
    public static void main( String[] args )
    {
        try {
			System.out.println( Rank.Parse("7"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}

/* This class will construct a deck of cards
 *
 * Programmer:  Susie Cunningham
 *
*/

import java.io.*;
import java.util.*;

public class Card
{
	Map d = new HashMap();
	Map dv = new HashMap();
	
	public Card()
	{
			
		d.put(1,"Ace of Hearts");
		d.put(2,"2 of Hearts");
		d.put(3,"3 of Hearts");
		d.put(4,"4 of Hearts");
		d.put(5,"5 of Hearts");
		d.put(6,"6 of Hearts");
		d.put(7,"7 of Hearts");
		d.put(8,"8 of Hearts");
		d.put(9,"9 of Hearts");
		d.put(10,"10 of Hearts");
		d.put(11,"Jack of Hearts");
		d.put(12,"Queen of Hearts");
		d.put(13,"King of Hearts");
		d.put(14,"Ace of Spades");
		d.put(15,"2 of Spades");
		d.put(16,"3 of Spades");
		d.put(17,"4 of Spades");
		d.put(18,"5 of Spades");
		d.put(19,"6 of Spades");
		d.put(20,"7 of Spades");
		d.put(21,"8 of Spades");
		d.put(22,"9 of Spades");
		d.put(23,"10 of Spades");
		d.put(24,"Jack of Spades");
		d.put(25,"Queen of Spades");
		d.put(26,"King of Spades");
		d.put(27,"Ace of Diamonds");
		d.put(28,"2 of Diamonds");
		d.put(29,"3 of Diamonds");
		d.put(30,"4 of Diamonds");
		d.put(31,"5 of Diamonds");
		d.put(32,"6 of Diamonds");
		d.put(33,"7 of Diamonds");
		d.put(34,"8 of Diamonds");
		d.put(35,"9 of Diamonds");
		d.put(36,"10 of Diamonds");
		d.put(37,"Jack of Diamonds");
		d.put(38,"Queen of Diamonds");
		d.put(39,"King of Diamonds");
		d.put(40,"Ace of Clubs");
		d.put(41,"2 of Clubs");
		d.put(42,"3 of Clubs");
		d.put(43,"4 of Clubs");
		d.put(44,"5 of Clubs");
		d.put(45,"6 of Clubs");
		d.put(46,"7 of Clubs");
		d.put(47,"8 of Clubs");
		d.put(48,"9 of Clubs");
		d.put(49,"10 of Clubs");
		d.put(50,"Jack of Clubs");
		d.put(51,"Queen of Clubs");
		d.put(52,"King of Clubs");
	
		dv.put(1,1);
		dv.put(2,2);
		dv.put(3,3);
		dv.put(4,4);
		dv.put(5,5);
		dv.put(6,6);
		dv.put(7,7);
		dv.put(8,8);
		dv.put(9,9);
		dv.put(10,10);
		dv.put(11,11);
		dv.put(12,12);
		dv.put(13,13);
		dv.put(14,1);
		dv.put(15,2);
		dv.put(16,3);
		dv.put(17,4);
		dv.put(18,5);
		dv.put(19,6);
		dv.put(20,7);
		dv.put(21,8);
		dv.put(22,9);
		dv.put(23,10);
		dv.put(24,11);
		dv.put(25,12);
		dv.put(26,13);
		dv.put(27,1);
		dv.put(28,2);
		dv.put(29,3);
		dv.put(30,4);
		dv.put(31,5);
		dv.put(32,6);
		dv.put(33,7);
		dv.put(34,8);
		dv.put(35,9);
		dv.put(36,10);
		dv.put(37,11);
		dv.put(38,12);
		dv.put(39,13);
		dv.put(40,1);
		dv.put(41,2);
		dv.put(42,3);
		dv.put(43,4);
		dv.put(44,5);
		dv.put(45,6);
		dv.put(46,7);
		dv.put(47,8);
		dv.put(48,9);
		dv.put(49,10);
		dv.put(50,11);
		dv.put(51,12);
		dv.put(52,13);

	}
	
	
	public String nameofCard(int i)
	{
	 	return ((String)d.get(i));	
	}
	
	public Integer getValueofCard(int i)
	{		
		return ((Integer)dv.get(i));
	}
}
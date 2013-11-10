package jab.lejos.util;

import java.util.ArrayDeque;
import java.util.Iterator;
 
public class FifoTest {
	public static void main(String... args){
		ArrayDeque<String> aq= new ArrayDeque<String>();
		aq.add("A");
		aq.add("B");
		aq.add("C");
		//offerFirst-adds elements at the front of the ArrayDeque
		aq.offerFirst("D");
		//offerLast inserts the element at the last of ArrayDeque
		aq.offerLast("E");
		aq.removeFirst();
		
		Iterator<String> itr= aq.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
	}
}
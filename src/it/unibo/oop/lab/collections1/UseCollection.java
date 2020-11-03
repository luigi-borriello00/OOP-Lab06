package it.unibo.oop.lab.collections1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Example class using {@link java.util.List} and {@link java.util.Map}.
 * 
 */
public final class UseCollection {

    private UseCollection() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
    	final List<Integer> lista= new ArrayList<>();
    	final int valInit = 1000;
    	for(int i = 0; i<1000; i++) {
    		lista.add(i+1000);
    	}
    	System.out.println(lista);
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
    	final List<Integer> listaLinkata = new LinkedList<>();
    	listaLinkata.addAll(lista);
    	System.out.println(listaLinkata);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
    	Integer x = lista.get(0);
    	Integer y = lista.get(lista.size() - 1);
    	lista.set(0, y);
    	lista.set(lista.size() - 1, x);
    
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
     	for(int val : lista) {
     		System.out.print(val + "->");
     	}
     	System.out.println();
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
     	 /*
         * Prepare a variable for measuring time
         */
     	lista.clear();
     	listaLinkata.clear();
     	final int ELEMS = 100000;
     	final int TO_MS = 1_000_000;
        long timeArray = System.nanoTime();
        /*
         * Run the benchmark
         */
        for (int i = 1; i <= ELEMS; i++) {
            lista.add(i);
        }
        /*
         * Compute the time and print result
         */
        timeArray = System.nanoTime() - timeArray;
        System.out.println("Converting " + ELEMS
                + " int to String and inserting them in a Array List took " + timeArray
                + "ns (" + timeArray / TO_MS + "ms)");
        
        long timeLink = System.nanoTime();
        /*
         * Run the benchmark
         */
        for (int i = 1; i <= ELEMS; i++) {
            listaLinkata.add(i);
        }
        /*
         * Compute the time and print result
         */
        timeLink = System.nanoTime() - timeLink;
        System.out.println("Converting " + ELEMS
                + " int to String and inserting them in a Linked List took " + timeLink
                + "ns (" + timeLink / TO_MS + "ms)");
        
        
        
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         * 
         * Africa -> 1,110,635,000
         * 
         * Americas -> 972,005,000
         * 
         * Antarctica -> 0
         * 
         * Asia -> 4,298,723,000
         * 
         * Europe -> 742,452,000
         * 
         * Oceania -> 38,304,000
         */
        Map<String, Long > mappa = new HashMap<>();
        mappa.put("Africa", 1110635000L);
        mappa.put("Americas", 972005000L);
        mappa.put("Antartica", 0L);
        mappa.put("Asia", 4298723000L);
        mappa.put("Europe", 742542000L);
        mappa.put("Oceania", 38304000L);
        long sommaTot = 0;
        for(long k : mappa.values()) {
        	sommaTot += k;
        }
        System.out.println("Popolazione Mondiale : " + sommaTot);
        /*
         * 8) Compute the population of the world
         */
    }
}

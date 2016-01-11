package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class QuadGramMap {
	public static final int GRAM_SIZE = 4; // size
	
	public Map<String, Integer> parsequadGramMap() throws FileNotFoundException{ // creates the quadGramMap
		
		Map<String, Integer> quadGramMap = new ConcurrentHashMap<String, Integer>();
		
		BufferedReader reader = new BufferedReader(new FileReader("4grams.txt")); // reads in the 4Grams file for the cypher.
		
		return null;
		
	}
}
package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class QMMap 
{
	public static final int GRAM_SIZE = 4;
	
	// here is where the quadgram is made
	public Map<String, Integer> parsequadGramMap() throws FileNotFoundException{ 
		
		Map<String, Integer> quadGramMap = new ConcurrentHashMap<String, Integer>();
		
		// gets info from txt specified file
		BufferedReader reader = new BufferedReader(new FileReader("4grams.txt")); 
		
		return null;
		
	}
}
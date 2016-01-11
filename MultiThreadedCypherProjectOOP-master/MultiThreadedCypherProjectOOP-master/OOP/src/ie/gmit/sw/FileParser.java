package ie.gmit.sw;

import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class FileParser {
	public Map<String, Double> parse(String dile) throws FileNotFoundException {
		Map<String, Double> temp = new ConcurrentHashMap<String, Double>();
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(dile)));
		return temp;
	}
}

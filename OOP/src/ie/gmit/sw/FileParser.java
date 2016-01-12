package ie.gmit.sw;

import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

// parses the file txt file and returns its value
public class FileParser 
{
	public Map<String, Double> parse(String fileParsed) throws FileNotFoundException 
	{
		Map<String, Double> temporary = new ConcurrentHashMap<String, Double>();
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileParsed)));
		return temporary;
	}
}

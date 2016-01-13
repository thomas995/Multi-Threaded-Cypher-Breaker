package ie.gmit.sw;

import java.io.FileNotFoundException;
import java.util.Map;

// gets the values from the Quad Gram Map
public class TextScorer extends QMMap
{
	private Map<String, Integer> map = null;
	
	public TextScorer(Map<String, Double> m) throws FileNotFoundException
	{
		this.map = super.parsequadGramMap();
	}
	
	// getScore
	public double getScore(String text)
	{
		double score = 0f;

		for (int i = 0; i < text.length(); i++){
			if (i + QMMap.GRAM_SIZE <= text.length() -1)
			{
				score += calculateScore(text.substring(i, i + QMMap.GRAM_SIZE));
				
				// outputs the score
				System.out.println("The score is:" + score);				 
			}
		}
		return score;
		
	}
	
	//calculateScore
	public double calculateScore(String quadgram)
	{
		if (map.containsKey(quadgram))
		{
			double frequency = map.get(quadgram);
			double total = (double) map.size();
			double probability = (double) (frequency/total);
			
			return Math.log10(probability);
			
		}
		else
		{
			// return the score
			return 0f;
			
		}
	}
}


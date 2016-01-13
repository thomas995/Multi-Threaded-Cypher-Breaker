package ie.gmit.sw;

public class Result implements Resultable 
{
	// variables 
	private String plainText;
	private int key;
	private double score;
	
	public Result(String plainText, int key, double score) 
	{
		// calls from the super class - 
		super();
		this.plainText = plainText;
		this.key = key;
		this.score = score;
	}

	public String getPlainText() 
	{
		return plainText;
	}

	public void setPlainText(String plainText)
	{
		this.plainText = plainText;
	}

	public int getKey()
	{
		return key;
	}

	public void setKey(int describerKey)
	{
		this.key = describerKey;
	}

	public double getScore() 
	{
		return score;
	}

	public void setScore(double score) 
	{
		this.score = score;
	}
}

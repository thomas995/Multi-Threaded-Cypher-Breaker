package ie.gmit.sw;

public interface Resultable 
{
	// allows other classes to inherit from here - tidies up the code
	public abstract String getPlainText();

	public abstract void setPlainText(String plainText);

	public abstract int getKey();

	public abstract void setKey(int key);

	public abstract double getScore();

	public abstract void setScore(double score);

}
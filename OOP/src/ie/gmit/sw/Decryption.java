package ie.gmit.sw;

import java.util.concurrent.BlockingQueue;

public class Decryption implements Runnable
{ 
	
	private BlockingQueue<Resultable> queue;
	private String cypText;
	private int key;
	
	public Decryption(BlockingQueue<Resultable> queue, String cypherText) 
	{
		// makes class a superclass
		super();
		this.queue = queue;
		this.cypText = cypherText;
	}

	public void run() 
	{
		
		//Get the Phrase
		Resultable r = null; // Create a result
		try
		{
			queue.put(r);
		} catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

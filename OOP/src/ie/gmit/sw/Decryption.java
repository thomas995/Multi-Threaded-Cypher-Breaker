package ie.gmit.sw;

import java.util.concurrent.BlockingQueue;

public class Decryption implements Runnable
{ 
	
	private BlockingQueue<Resultable> queue;
	private String cypText;
	private int key;
	
	public Decryption(BlockingQueue<Resultable> queue, String cypherText) 
	{
		// calls from the super class
		super();
		this.queue = queue;
		this.cypText = cypherText;
	}

	public void run() 
	{
		
		// calls an instance of the interface
		Resultable r = null; 
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

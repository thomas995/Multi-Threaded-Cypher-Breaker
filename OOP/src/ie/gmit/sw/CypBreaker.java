package ie.gmit.sw;

import java.util.*;
import java.util.concurrent.*;

public class CypBreaker 
{
	private static final int MAXIMUM_QUEUE = 1000;
	// stores the results for the plaintext, key and score
	private BlockingQueue<Resultable> queue;
	private String cypText;
	private Resultable r = null;

	
	public CypBreaker()
	{
		queue = new ArrayBlockingQueue<Resultable>(MAXIMUM_QUEUE);
		init();
	}
	
	// initializes instance of the queue
	public void init()
	{ 
		for (int i = 2; i < cypText.length()/2; i++)
		{
			new Thread(new Decryption(queue, cypText)).start();
		}
		
		new Thread(new Runnable()
		{
			
			public void run() 
			{
				while(!queue.isEmpty())
				{
					// try/catch
					try 
					{
						Resultable r = queue.take();
						
					} catch (InterruptedException e) 
					{
						e.printStackTrace();
					}
				}
			} // end run
		});
	} // end init
} // end class

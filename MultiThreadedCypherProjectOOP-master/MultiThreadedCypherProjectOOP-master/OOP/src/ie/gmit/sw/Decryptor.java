package ie.gmit.sw;

import java.util.concurrent.BlockingQueue;

public class Decryptor implements Runnable{ // implements the runnable interface
	
	private BlockingQueue<Resultable> queue;
	private String cypherText;
	private int key;
	
	public Decryptor(BlockingQueue<Resultable> queue, String cypherText) {
		super();
		this.queue = queue;
		this.cypherText = cypherText;
	}

	public void run() {
		RailFence rf = new RailFence();
		String plainText = rf.decrypt(cypherText, key);
		//Get the Score
		
		Resultable r = null; // Create a result
		try {
			queue.put(r);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

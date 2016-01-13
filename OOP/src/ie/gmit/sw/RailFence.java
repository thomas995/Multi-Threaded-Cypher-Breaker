package ie.gmit.sw;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import ie.gmit.sw.EncryptionClass;

public class RailFence    
{
	
	//***** Encrypt a String called cypherText using an integer key ***** 
	//public String encrypt(String cypherText, int key)
	public String encrypt(String s, int key)

	{
		//Declare a 2D array of key rows and text length columns
		//char[][] matrix = new char[key][cypherText.length()]; //The array is filled with chars with initial values of zero, i.e. '0'.
		char[][] matrix = new char[key][s.length()];
		
		//Fill the array
		int row = 0; //Used to keep track of rows
		boolean down = true;
		//for (int i = 0; i < cypherText.length(); i++)
		for (int i = 0; i < s.length(); i++)
		{
			//Loop over the plaintext
			//matrix[row][i] = cypherText.charAt(i); //Add the next character in the plaintext to the array
			matrix[row][i] = s.charAt(i);
			
			if (down)
			{ //If we are moving down the array
				row++;
				if (row == matrix.length)
				{ //Reached the bottom
					row = matrix.length - 2; //Move to the row above
					down = false; //Switch to moving up
				} 
			}
			else
			{ //We are moving up the array
				row--;
				
				if (row == -1)
				{ //Reached the top
					row = 1; //Move to the first row
					down = true; //Switch to moving down
				}
			}
		}
				
		//Extract the cypher text - SATTMTSLSOETAEEPHHCGTTEA
		StringBuffer sb = new StringBuffer(); // buffer which allows it to be read easily
		for (row = 0; row < matrix.length; row++)
		{ 
			//Loop over each row in the matrix
			for (int col = 0; col < matrix[row].length; col++)
			{ 
				//Loop over each column in the matrix
				if (matrix[row][col] > '0') sb.append(matrix[row][col]); /// uses characters from the rows and columns
			}
		}
		
		return sb.toString(); // converts and returns it
	}
	
	//***** Decrypt a String cypherText using an integer key ***** 
	public String decrypt(String cypherText, int key)
	{
		//Declare a 2D array of key rows and text length columns
		char[][] matrix = new char[key][cypherText.length()]; //The array is filled with chars with initial values of zero, i.e. '0'.
		
		//Fill the array
		int targetRow = 0;
		int index = 0;
		do
		{
			//Used to keep track of rows
			int row = 0;
			
			//Used to create the RailFence in console
			boolean down = true; 
			for (int i = 0; i < cypherText.length(); i++)
			{ //Loop over the plaintext
				if (row == targetRow){
					matrix[row][i] = cypherText.charAt(index); //Add the next character in the plaintext to the array
					index++;
				}
				
				if (down)
				{ //If we are moving down the array
					row++;
					if (row == matrix.length){ //Reached the bottom
						row = matrix.length - 2; //Move to the row above
						down = false; //Switch to moving up
					} 
				}
				else
				{ //We are moving up the array
					row--;
					
					if (row == -1)
					{ //Reached the top
						row = 1; //Move to the first row
						down = true; //Switch to moving down
					}
				}
			}

			targetRow++;
		}
		while (targetRow < matrix.length);
		
		printMatrix(matrix); 
		
		//Extract the cypher text
		// runs the code more efficiently
		StringBuffer sb = new StringBuffer(); 
		int row = 0;
		boolean down = true; 
		
		for (int col = 0; col < matrix[row].length; col++)
		{ //Loop over each column in the matrix
			sb.append(matrix[row][col]); 
			
			if (down)
			{ //If we are moving down the array
				row++;
				//at the bottom
				if (row == matrix.length)
				{ //move up row
					row = matrix.length - 2; 
					// keep moving up
					down = false; 
				} 
			}else
			{ 
				row--;
				// can't go up
				if (row == -1)
				{ 
					// first row
					row = 1; 
					// start moving down
					down = true; 
				}
			}
		}
		
		//returns as string
		return sb.toString(); 
	}
	
	// draws the RailFence zigzag in the console
	private void printMatrix(char[][] matrix)
	{
		for (int row = 0; row < matrix.length; row++)
		{ 
			//Loop over each row in the matrix
			for (int col = 0; col < matrix[row].length; col++)
			{ 
				//Loop over each column in the matrix
				System.out.print(matrix[row][col]); 
				//Output the value at row/column index
				if (col < matrix[row].length - 1) System.out.print("...");
			}
			System.out.println();
		}
	}
		
	public static void main(String[] args) throws Exception
	{
			
		
		File cypherfile = new File("txtfile.txt"); 

		try 
		{ 
			
			@SuppressWarnings("resource")
			Scanner enterText = new Scanner(System.in);
			
			EncryptionClass user = new EncryptionClass();
			
			System.out.print("Enter a message: ");
			String msg = enterText.nextLine();
			user.dumpGrid();
			
			System.out.println("Original: " + msg);
			
			String inputText = new RailFence(). encrypt(msg, 5);
			System.out.println("   Coded: " + inputText);
			
			String inputText1 = new RailFence(). decrypt(inputText, 5);
			System.out.println(" Decoded: " + inputText1);
			
			
			if(inputText1 != msg)
			{
				System.out.println("If no result/ only numbers are inputted, then run program again");
				
			}
			

			
			// scanner takes in input from the file
			Scanner scanner = new Scanner(cypherfile);
			
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter any key to read phrases from the file");
			sc.next();
			
			while (scanner.hasNextLine()) 
			{
				String cypherText = scanner.nextLine();
				
				String s = new RailFence(). decrypt(cypherText, 5);
				System.out.println("Encrypted Phrase: " + cypherText);
				
				System.out.println("Decrypted Phrase: " + s);
			}
						scanner.close();
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}		
	}
}

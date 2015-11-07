package cz2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieGoerController {
	private static Scanner input = new Scanner(System.in);
	public static void MovieGoerMain(){
	
		while(true){
		System.out.println("Movie-goer Option:");
		System.out.println("1. I want all movie showing now");
		System.out.println("2. I want see the details about a movie");
		System.out.println("3. I want to buy a ticket"); //check seat first then buy the ticket
		System.out.println("4. I want to make review on a movie");
		System.out.println("5. I want to see my booking history");
		System.out.println("6. I want to see the top5 movies");
		System.out.println("7. Exit");
		int option = input.nextInt();
		if(option == 7) break;
		switch(option){
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			System.out.println("Please input your name");
			String name1 = input.next();
			System.out.println("Please input the movie's name");
			String mName = input.next();
			try {
		           FileOutputStream fos = new FileOutputStream("database/Review");
		           ObjectOutputStream oos = new ObjectOutputStream(fos);
		           System.out.println("Please key in your rating");
		           int rate = input.nextInt();
		           System.out.print("Please make your review");
		           String content = input.next();
		           Review review = new Review(name1,content,rate);
		           
		           oos.writeObject(review); // write a Review object to file
		           
		           oos.close();
		        } catch (IOException e) {
		            System.out.println("File input error");
		        }
			break;
		case 5:
			System.out.println("Please input your name");
			String name2 = input.next();
			try{
				FileInputStream fis = new FileInputStream("database/History");
		        ObjectInputStream ois = new ObjectInputStream(fis);
			while (true){
				String custName = ois.readUTF();
				String movieName = ois.readUTF();
				String TID = ois.readUTF();
				if (custName == name2)
					System.out.println(custName+": "+TID);
			}
			
			}
			catch (EOFException e){}
			catch (IOException e){System.out.println("File input Error.");}
			
			break;
		case 6:
			int choice;
			System.out.println("1. Top 5 ranking by ticket sales");
			System.out.println("2. Top 5 ranking by reviewers' rating");
			choice = input.nextInt();
			if (choice == 1) break;
			else if (choice == 2){
				try{
					FileInputStream fis2 = new FileInputStream("database/Review");
			        ObjectInputStream ois2 = new ObjectInputStream(fis2);
			        
			        
			        
				}
				catch (EOFException e){}
				catch (IOException e){System.out.println("File input Error.");}
			}
			break;
		default: break;
		}
		}
		
	}

}

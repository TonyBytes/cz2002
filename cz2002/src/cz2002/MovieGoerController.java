package cz2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieGoerController {
	private static Scanner input = new Scanner(System.in);
	public static void MovieGoerMain() throws Exception{
	
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
			makeReview();
			break;
		case 5:
			seeHistory();			
			break;
		case 6:
			seeTop5();
			break;
		default: break;
		}
		}
		
	}
	public static void makeReview() throws Exception{
		int num;
		System.out.println("Please input your name");
		String name1 = input.next();
		System.out.println("Please input the movie's name");
		String mName = input.next();
		FileInputStream fis = new FileInputStream("database/Review");
	    ObjectInputStream ois = new ObjectInputStream(fis);
	    num = ois.readInt();
	    ArrayList<Review> reviewList = new ArrayList<Review>();
	    for (int i = 0; i<num;i++){
	    	reviewList.add((Review)ois.readObject());
	    }
	    FileOutputStream fos = new FileOutputStream("database/Review");
	    ObjectOutputStream oos = new ObjectOutputStream(fos);
	    System.out.println("Please key in your rating");
	    double rate = input.nextDouble();
	    System.out.print("Please make your review");
	    String content = input.next();
	    Review review = new Review(name1,mName,content,rate);    
	    reviewList.add(review); // write a Review object to file
	    num++;
	    oos.writeInt(num);
	    oos.writeObject(reviewList);
	    oos.close();
	      
	}
	
	public static void seeHistory() throws Exception{
		System.out.println("Please input your name");
		String name2 = input.next();
		FileInputStream fis2 = new FileInputStream("database/History");
	    ObjectInputStream ois2 = new ObjectInputStream(fis2);
	    int num = ois2.readInt();
	    ArrayList<History> historyList = new ArrayList<History>();
		for (int i = 0; i<num; i++){
			historyList.add((History)ois2.readObject());
		}
		for (History h: historyList){
			if(h.getCustName()==name2)
				System.out.println(name2+"booked: "+h.getMovieName()+"TID: "+h.getTID());
		}
	}
	public static void seeTop5() throws Exception{
		int choice;
		double[] rateList = null;
		System.out.println("1. Top 5 ranking by ticket sales");
		System.out.println("2. Top 5 ranking by reviewers' rating");
		choice = input.nextInt();
		if (choice == 1) ;
		else if (choice == 2){
			FileInputStream fis = new FileInputStream("database/Movie");
		    ObjectInputStream ois = new ObjectInputStream(fis);
		    int num = ois.readInt();
		    ArrayList<Movie> movieList = new ArrayList<Movie>();
		    for (int i = 0; i<num;i++){
		    	movieList.add((Movie)ois.readObject());
		    }
		        
			
		}
	}

}

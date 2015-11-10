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
		
		FileInputStream fis = new FileInputStream("database/Movie");
	    ObjectInputStream ois = new ObjectInputStream(fis);
	    num = ois.readInt();
	    ArrayList<Movie> movieList = new ArrayList<Movie>();
	    System.out.println("select from below");
	    for (int i = 0; i<num;i++){
	    	movieList.add((Movie)ois.readObject());
	    	System.out.println("Movie " + (i + 1) + ": " + movieList.get(i).toString());
	    }
	    int sel = input.nextInt();
	    Movie aMovie = movieList.get(sel-1);
	    System.out.println("Please key in your rating");
	    float rate = input.nextFloat();
	    while(rate>10 || rate<0){
	    	System.out.println("Please key in your rating(0-10)");
		    rate = input.nextFloat();
	    }
	    System.out.print("Please make your review");
	    String content = input.next();
	    String mName = aMovie.getTitle();
	    Review review = new Review(name1,mName,content,rate);    
	    aMovie.addReview(review); // write a Review object to file
	    FileOutputStream fos = new FileOutputStream("database/Movie");
		ObjectOutputStream oos= new ObjectOutputStream(fos);
	    oos.writeInt(num);
	    for(int i=0; i<num;i++){
	    	oos.writeObject(movieList.get(i));
	    }
	    ois.close();
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
		ois2.close();
	}
	public static void seeTop5() throws Exception{
		int choice;
		FileInputStream fis = new FileInputStream("database/Movie");
	    ObjectInputStream ois = new ObjectInputStream(fis);
	    int num = ois.readInt();
	    ArrayList<Movie> movieList = new ArrayList<Movie>();
		float[] rateList = new float[5];
		int[] salesList = new int[5];
		Movie topList[]=new Movie[5];
		for (int i=0;i<5;i++) {
			rateList[i]=0; salesList[i]=0;
			topList[i]=null;
			}
		System.out.println("1. Top 5 ranking by ticket sales");
		System.out.println("2. Top 5 ranking by reviewers' rating");
		choice = input.nextInt();
		if (choice == 1) {
			for(int i = 0; i<num;i++){
				movieList.add((Movie)ois.readObject());
				int temp = movieList.get(i).getSales();
				if(temp>salesList[0]){
		    		for(int n = 4;n>0;n--) {
		    			salesList[n]=salesList[n-1];
		    			topList[n]=topList[n-1];
		    		}
		    		salesList[0]=temp;
		    		topList[0]=movieList.get(i);
		    	}
		    	else if(temp>salesList[1]){
		    		for(int n = 4;n>1;n--) {
		    			salesList[n]=salesList[n-1];
		    			topList[n]=topList[n-1];
		    		}
		    		salesList[1]=temp;
		    		topList[1]=movieList.get(i);
		    	}
		    	else if(temp>salesList[2]){
		    		for(int n = 4;n>2;n--) {
		    			salesList[n]=salesList[n-1];
		    			topList[n]=topList[n-1];
		    		}
		    		salesList[2]=temp;
		    		topList[2]=movieList.get(i);
		    	}
		    	else if(temp>salesList[3]){
		    		salesList[4]=salesList[3];
		    		topList[4]=topList[3];
		    		salesList[3]=temp;
		    		topList[3]=movieList.get(i);
		    	}
		    	else if(temp>salesList[4]){
		    		salesList[4]=temp;
		    		topList[4]=movieList.get(i);
		    	}
			}
		for(int i = 0; i>5;i++)
		    	System.out.println((i+1)+". "+topList[i].toString());
		}
		else if (choice == 2){
		    for (int i = 0; i<num;i++){
		    	movieList.add((Movie)ois.readObject());
		    	float temp = movieList.get(i).getRating();
		    	if(temp>rateList[0]){
		    		for(int n = 4;n>0;n--) {
		    			rateList[n]=rateList[n-1];
		    			topList[n]=topList[n-1];
		    		}
		    		rateList[0]=temp;
		    		topList[0]=movieList.get(i);
		    	}
		    	else if(temp>rateList[1]){
		    		for(int n = 4;n>1;n--) {
		    			rateList[n]=rateList[n-1];
		    			topList[n]=topList[n-1];
		    		}
		    		rateList[1]=temp;
		    		topList[1]=movieList.get(i);
		    	}
		    	else if(temp>rateList[2]){
		    		for(int n = 4;n>2;n--) {
		    			rateList[n]=rateList[n-1];
		    			topList[n]=topList[n-1];
		    		}
		    		rateList[2]=temp;
		    		topList[2]=movieList.get(i);
		    	}
		    	else if(temp>rateList[3]){
		    		rateList[4]=rateList[3];
		    		topList[4]=topList[3];
		    		rateList[3]=temp;
		    		topList[3]=movieList.get(i);
		    	}
		    	else if(temp>rateList[4]){
		    		rateList[4]=temp;
		    		topList[4]=movieList.get(i);
		    	}
		    }
		    for(int i = 0; i>5;i++)
		    	System.out.println((i+1)+". "+topList[i].toString());
		        
			
		}
	}

}

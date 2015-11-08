package cz2002;

import java.util.Scanner;

public class MovieGoerController {
	private static Scanner input = new Scanner(System.in);
	public static void MovieGoerMain(){
		while(true){
		System.out.println("Movie-goer Option:");
		System.out.println("1. I want all movie showing now");
		System.out.println("2. I want see the details about a movie");
		System.out.println("3. I want to buy a ticket"); //check seat first then buy the ticket
		System.out.println("4. I want to see my booking history");
		System.out.println("5. I want to see the top5 movies");
		System.out.println("6. Exit");
		int option = input.nextInt();
		if(option == 6) break;
		switch(option){
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			String name = input.next();
			for (History i : )
			break;
		default: break;
		}
		}
	}
}

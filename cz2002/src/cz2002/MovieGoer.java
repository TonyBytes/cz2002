package cz2002;

import java.util.ArrayList;
import java.util.Scanner;

public class MovieGoer {
	private String name;
	private long mobileNo;
	private String email;
	private int age;
	private ArrayList<Review> review;
	//public ArrayList<History> history;
	
	public MovieGoer(String n, long mNo, String e, int a)
	{
		name = n;
		mobileNo = mNo;
		email = e;
		age = a;
	}
	public String getName(){return name;}
	public long getMobileNo(){return mobileNo;}
	public String getEmail(){return email;}
	public int getAge(){return age;}
	/*
	public void makeReview(){
		Review newReview = new Review();
		String content;
		Scanner scan = new Scanner(System.in);
		System.out.println("Please type your review:");
		content = scan.next();
		newReview.name = this.getName();
		newReview.content = content;
		review.add(newReview);
	}
	
	public void showReview(){
		System.out.println(this.getName()+"'s review:");
		for (Review i: review)
			if(i.name == this.getName())
				System.out.println(i.content);
		
	}
	*/
	//public void addHistory(History his){
	//	this.history.add(his);
	//}
	
}

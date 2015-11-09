package cz2002;

import java.io.Serializable;
import java.util.ArrayList;

public class Ticket implements Serializable{

	private int row;
	private int column;
	private double price;
	private boolean isBooked;
	public String TID;
	//public ArrayList<String> history;
	private MovieGoer cust;
	
	public Ticket(){
		row = 0;
		column = 0;
		price = 0;
		isBooked = false;
	}
	
	public Ticket(int r, int c, double p, String TicketID){
		row = r;
		column = c;
		price = p;
		isBooked = false;
		TID = TicketID;
	}
	
	public boolean getBooked(){
		return isBooked;
	}
	
	public void setBooked(Boolean s){
		isBooked = s;
	}
	
	public void setSeatNumber(int r, int c){
		row = r;
		column = c;
	}
	
	public int getSeatRow(){
		return row;
	}
	
	public int getSeatColumn(){
		return column;
	}
	
	
	//public void printHistory(MovieGoer cust){
	//	for(String i:cust.history)
	//		System.out.println(i);
	//}
}

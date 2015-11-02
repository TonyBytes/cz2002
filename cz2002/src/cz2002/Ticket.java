package cz2002;

public class Ticket {
	private int row;
	private int column;
	private double price;
	private boolean isBooked;
	private String TID;
	Vector history;
	
	public Ticket(){
		row = 0;
		column = 0;
		price = 0;
		isBooked = false;
	}
	
	public Ticket(int r, int c, double p, boolean is, String TicketID){
		row = r;
		column = c;
		price = p;
		isBooked = is;
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
	
	public String getTID(){
		return TID;
	}
	
	public void printHistory(String name){
		System.out.println(name);
	}

}

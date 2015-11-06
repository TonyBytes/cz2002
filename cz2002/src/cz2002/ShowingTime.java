package cz2002;

public class ShowingTime {
	private Cinema cinema;
	private Movie movie;
	private String date;
	private String time;
	private Ticket[][] ticket;
	//first class 1, second class 2
	private int classType;


	public ShowingTime(cinema:Cinema, movie:Movie, date:String, time:String, class:int){
		this.cinema = cinema;
		this.movie = movie;
		this.date = date;
		this.time = time;
		this.class = class;

		double price = (classType==1)?100:50;

		ticket = new Ticket[10][10];
		for(int i = 0; i < 10; i++){
			for (int j = 0; j < 10; j++ ) {
				ticket[i][j] = new Ticket(i,j,price);
			}
		}
	}

	public Movie getMovie(){
		return this.movie;
	}
	
	public String getDate(){
		return this.date;
	}

	public String getTime(){
		return this.time;
	}

	public Ticket[] getTicket(available:boolean){
		int size = ticket.length;
		Ticket[] checkTicket = new Ticket[length * length];
		int index = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (ticket[i][j].getBooked != available) {
					checkTicket[index] = ticket[i][j].clone();
					index++;
				}
				
			}
		}
		return checkTicket;
	}

	public String toString(){
		return "MOVIE: "movie.getInfo + " DATE: " + date + " TIME: " + time;
	}

	public void printAllTicket(){
		int size = ticket.length;

		System.out.print("  ");
		for (int k = 0; k < size; k++) 
			System.out.print(k + " ");
		System.out.println();

		for (int i = 0; i < size; i++) {
			System.out.print(i + " ");
			for (int j = 0; j < size; j++) {
				if (ticket[i][j].getBooked) 
					System.out.print("X ");
				else
					System.out.print("O ");
			}
		System.out.println();
		}
	}
}
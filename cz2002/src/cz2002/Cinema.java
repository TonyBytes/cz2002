package cz2002;

import java.util.ArrayList;

public class Cinema {

	private String code;
	private String cineplex;
	private String cinemaClass;
	private ArrayList<ShowingTime> showingTime;

	public Cinema(String code, String cineplex, String cinemaClass) {
		this.code = code;
		this.cineplex = cineplex;
		this.cinemaClass = cinemaClass;
	}

	public String getCode() {
		return code;
	}

	public String getCineplex() {
		return cineplex;
	}

	public String getCinemaClass() {
		return cinemaClass;
	}

	public void addShowingTime() {
		showingTime.add(new Showingtime(cinema, movie, date, time, classType));
	}

	public void removeShowingTime(int i) {
		showingTime.remove(i);
	}

	public void listShowingTime() {
		for (ShowingTime i : showingTime) {
			System.out.println(i.toString());
		}
	}
}

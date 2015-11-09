package cz2002;

import java.util.ArrayList;

public class Cinema {

	private String code;
	private String cineplex;
	private int cinemaClass;
	private ArrayList<ShowingTime> showingTime;

	public Cinema(String code, String cineplex, int cinemaClass) {
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
		if (cinemaClass == 1) {
			return "Platinum Class";
		} else {
			return "Gold Class";
		}
	}

	public void addShowingTime(Movie movie, String date, String time) {
		showingTime.add(new ShowingTime(code, movie, date, time, cinemaClass));

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

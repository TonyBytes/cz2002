package cz2002;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Vector;

public class Movie implements Serializable {

	private int id;
	private String title;
	protected int showingStatus; // coming soon =1 , preview = 2, now showing
									// =3;
	private String synopsis;
	private String director;
	private Vector cast;
	private float rating;
	private Vector reviewList; // connecting reviews
	private Vector timeList; // connecting showingTime
	private int reviewNum; // record the review number to calculate the average
							// review

	public Movie(String t, String s, String d) {

		title = t;
		showingStatus = 1;
		synopsis = s;
		director = d;
		cast = new Vector<String>();
		reviewList = new Vector<Review>();
		timeList = new Vector<ShowingTime>();
		reviewNum = 0;
		rating = 5;

	}

	// all add function needed to store data into database
	public boolean addCast(String s) {
		return cast.add(s);
	}

	public boolean addTime(ShowingTime s) {
		return timeList.add(s);
	}

	// add and update average rating
	public boolean addReview(Review r) {

		if (reviewList.add(r)) {

			float total = rating * ((reviewNum) + r.getRating());
			rating = total / (++reviewNum);
			return true;
		} else
			return false;
	}

	public String toString() {

		String castInfo = "";
		Iterator i = cast.iterator();
		while (i.hasNext()) {
			castInfo += (i.next() + " ");
		}

		return title + " " + showingStatus + " " + director + " " + synopsis + " " + castInfo + " ";
		// depends on the format requirement , needed to discuss
	}

	public void showTime() {
		// needed to retrieve from database
	}

	public void showReview() {
		// needed to retrieve from database
	}

}

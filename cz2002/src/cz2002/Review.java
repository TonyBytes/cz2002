package cz2002;

public class Review {
	public String name;
	public String mName;
	public String content;
	private double rating;
	
	public Review(String aName,String moName,String aContent,double aRating){
		name = aName;
		mName = moName;
		content = aContent;
		rating = aRating;
	}
	public double getRating(){return rating;}
	
}

package cz2002;
import java.io.*;
public class Review implements Serializable{
	private String name;
	private String mName;
	private String content;
	private float rating;
	
	public Review(String aName,String moName,String aContent,float aRating){
		name = aName;
		mName = moName;
		content = aContent;
		rating = aRating;
	}
	public float getRating(){return rating;}
	public String getContent(){return content;}
}

package cz2002;

import java.io.Serializable;

public class History implements Serializable{
	private String custName;
	private String movieName;
	private String trID;
	public History(String name,String mName,String TID){
		custName = name;
		movieName = mName;
		trID=TID;
	}
	public String getCustName(){return custName;}
	public String getMovieName(){return movieName;}
	public String getTID(){return trID;}
}

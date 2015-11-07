package cz2002;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
	 public static void main(String[] args) {
		/*try{ 
			
		 
			FileOutputStream fos = new FileOutputStream("database/Movie");
	           ObjectOutputStream oos = new ObjectOutputStream(fos);
	         
	           oos.writeInt(0);
	           
	           oos.close();
		}catch (IOException e){
			System.out.println(e);
		}
		*/
		 
		 AdminManager.adminManager();
}}

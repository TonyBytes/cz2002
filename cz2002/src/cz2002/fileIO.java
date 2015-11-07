package cz2002;

import java.io.*;
import java.util.Date;

public class fileIO {

   public static void main(String[] args) {
       	// a file is saved by amountOfOBject+[Objects]
	   
	   try {
           FileOutputStream fos = new FileOutputStream("database/Movie");
           ObjectOutputStream oos = new ObjectOutputStream(fos);

           int amount = 2;
           System.out.print("saving data to Movie ...");
           
           Movie s = new Movie("007", "an action movie", "Tony Lu");
           s.addCast("James Bond");
           System.out.printf("Output data: "+ s.toString());
           
           oos.writeInt(amount);
           oos.writeObject(s); // write a String object to file
      
           Movie x = new Movie("007", "an action movie", "Tony Lu");
           x.addCast("James Bond");
           System.out.printf("Output data: "+ x.toString());
           
           oos.writeObject(x); // write a String object to file
           
           oos.close();
       } catch (IOException e) {
           System.out.println("File input error"+e.toString());
       }

       try {
           FileInputStream fis = new FileInputStream("database/Movie");
           ObjectInputStream ois = new ObjectInputStream(fis);

           System.out.print("reading data from Movie1 ...");
           int i = ois.readInt();
           Movie t = (Movie) ois.readObject();  // read the String object from file
         
           System.out.printf("Input data: "+ t.toString());
           t = (Movie) ois.readObject();  // read the String object from file
           
           System.out.printf("Input data: "+ t.toString());
           ois.close();
       } catch (IOException e) {
           System.out.println("File input error");
       } catch (ClassNotFoundException e) {
           System.out.println(e);
       }
       
   } // main
} //class

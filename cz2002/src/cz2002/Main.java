package cz2002;

public class Main {
	public static void main(String[] args) throws Exception {
		/*
		 * try{
		 * 
		 * 
		 * FileOutputStream fos = new FileOutputStream("database/Movie");
		 * ObjectOutputStream oos = new ObjectOutputStream(fos);
		 * 
		 * oos.writeInt(0);
		 * 
		 * oos.close(); }catch (IOException e){ System.out.println(e); }
		 */

		AdminController.adminManager();
	}
}

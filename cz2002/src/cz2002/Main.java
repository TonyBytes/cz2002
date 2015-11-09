package cz2002;

import java.util.Scanner;

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

		Scanner input = new Scanner(System.in);
		int sel = 3;
		System.out.println("=====Welcome=====");

		while (sel != 3) {

			System.out.println("1. Login as administrator");
			System.out.println("2. Login as movie goer");
			System.out.println("3. quit");
			System.out.println("input your choice:");
			sel = input.nextInt();
			input.nextLine();

			switch (sel) {
			case 1:
				if (AdminController.checkLogin()) {
					AdminController.adminManager();
				}
				break;
			case 2:
				break;
			default:
				break;
			}
		}

	}
}

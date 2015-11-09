package cz2002;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class AdminController {
	private static Scanner input = new Scanner(System.in);

	public static boolean checkLogin() {
		System.out.println("input admin password:");
		if (input.nextLine().equals("admin")) {
			return true;
		}
		return false;
	}

	public static void adminManager() throws Exception {

		System.out.println("Administrator Option:");
		System.out.println("1. Create new movie to the list");
		System.out.println("2. Update movie in the list");
		System.out.println("3. Remove movie in the list");
		System.out.println("4. Create new showing time");
		System.out.println("5. Update showing time");
		System.out.println("6. Remove showing time");
		System.out.println("7. Configure other settings");
		System.out.println("8. Quit");
		boolean loop = true;
		try {
			while (loop) {

				System.out.println("input choice:");
				switch (input.nextInt()) {
				case 1: {
					createMovie();
					break;
				}

				case 2: {
					updateMovie();
					break;
				}
				case 3:
					removeMovie();
					break;
				case 4:
					// createShowingTime();
					break;
				case 5:
					// updateShowingTime();
					break;
				case 6:
					// removeShowingTime();
					break;
				case 7:
					// otherConfigure();
					break;
				case 8:
					loop = false;
				default:
					break;
				}

			}

		} catch (IOException e) {
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
	}

	private static void removeMovie() throws Exception {
		int sel, i;

		FileInputStream fis2 = new FileInputStream("database/Movie");
		ObjectInputStream ois2 = new ObjectInputStream(fis2);
		int num = ois2.readInt();
		Movie[] mList = new Movie[num];

		System.out.println("delete from below:");
		for (i = 0; i < num; i++) {
			mList[i] = (Movie) ois2.readObject();
			System.out.println("Movie " + (i + 1) + ": " + mList[i].toString());
		}
		ois2.close();
		sel = input.nextInt();
		input.nextLine();

		// update number of movie
		num--;

		FileOutputStream fos2 = new FileOutputStream("database/Movie");
		ObjectOutputStream oos2 = new ObjectOutputStream(fos2);
		oos2.writeInt(num);
		for (i = 0; i < num; i++) {
			if (!(sel == i + 1)) {
				oos2.writeObject(mList[i]);
			}
		}

		oos2.close();

	}

	private static void updateMovie() throws Exception {
		int i, sel;

		// read the whole Movie objects file
		FileInputStream fis2 = new FileInputStream("database/Movie");
		ObjectInputStream ois2 = new ObjectInputStream(fis2);
		int num = ois2.readInt();
		Movie[] mList = new Movie[num];
		System.out.println("select from below");
		for (i = 0; i < num; i++) {
			mList[i] = (Movie) ois2.readObject();
			System.out.println("Movie " + (i + 1) + ": " + mList[i].toString());
		}
		ois2.close();

		sel = input.nextInt();
		if (num + 1 == sel) {
			return;
		}

		input.nextLine();
		// modify movie ,sort of
		String t, s, d, x;
		System.out.print("Movie Title:");
		t = input.nextLine();
		System.out.print("Movie Synpsis:");
		s = input.nextLine();
		System.out.print("Movie Director:");
		d = input.nextLine();
		Movie m = new Movie(t, s, d);
		System.out.print("Number of cast:");
		int a = input.nextInt();
		input.nextLine();
		for (i = 0; i < a; i++) {
			System.out.print("Cast " + (i + 1) + ":");
			x = input.nextLine();
			m.addCast(x);
		}

		mList[sel - 1] = m;

		// rewrite files
		FileOutputStream fos2 = new FileOutputStream("database/Movie");
		ObjectOutputStream oos2 = new ObjectOutputStream(fos2);
		oos2.writeInt(num);
		for (i = 0; i < num; i++) {
			oos2.writeObject(mList[i]);
		}
		oos2.close();

	}

	private static void createMovie() throws Exception {
		input.nextLine();
		String t, s, d, x;
		System.out.print("Movie Title:");
		t = input.nextLine();
		System.out.print("Movie Synpsis:");
		s = input.nextLine();
		System.out.print("Movie Director:");
		d = input.nextLine();

		Movie m = new Movie(t, s, d);
		System.out.print("Number of cast:");
		int a = input.nextInt();
		input.nextLine();
		int i;
		for (i = 0; i < a; i++) {
			System.out.print("Cast " + (i + 1) + ":");
			x = input.nextLine();
			m.addCast(x);
		}
		int num;
		// update number of movie
		FileInputStream fis = new FileInputStream("database/Movie");
		ObjectInputStream ois = new ObjectInputStream(fis);
		num = ois.readInt();
		num++;
		Movie[] mList = new Movie[num];

		// read all Movie objects file
		for (i = 0; i < num - 1; i++) {
			mList[i] = (Movie) ois.readObject();
		}

		ois.close();
		// append Movie
		mList[num - 1] = m;

		FileOutputStream fos2 = new FileOutputStream("database/Movie");
		ObjectOutputStream oos2 = new ObjectOutputStream(fos2);
		oos2.writeInt(num);
		for (i = 0; i < num; i++) {
			oos2.writeObject(mList[i]);
		}

		oos2.close();
	}
}

package cz2002;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class AdminController {
	private static Scanner input = new Scanner(System.in);
	private	static FileOutputStream fosMov = new FileOutputStream("database/Movie");
    private static ObjectOutputStream oosMov = new ObjectOutputStream(fosMov);
    private	static FileOutputStream fosShow = new FileOutputStream("database/ShowingTime");
    private static ObjectOutputStream oosShow = new ObjectOutputStream(fosShow);
        private static FileInputStream fisMov = new FileInputStream("database/Movie");
    private static ObjectInputStream oisMov = new ObjectInputStream(fis);
    private static FileInputStream fisShow = new FileInputStream("database/ShowingTime");
    private static ObjectInputStream oisShow = new ObjectInputStream(fis);
	public static boolean checkLogin() {
		System.out.println("input admin password:");
		if (input.nextLine().equals("admin")) {
			return true;
		}
		{
			System.out.println("wrong password!");
			return false;
		}
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

	private void createShowingTime(){
		System.out.print("Enter the cinema code: ");
		String cinimaCode = input.next();
		System.out.print("Choose a movie: ");
		int movieNumber = oisMov.readInt;
		Movie movie;
		Movie[] movielist = new Movie[movieNumber];
		for(int i = 0; i < movieNumber; i++){
			movie = (Movie)oisMov.readObject();
			movielist[i] = movie;
			System.out.println(i + ". " + movie.toString());
		}
		int choice = input.nextInt();
		movie = movielist[choice];
		System.out.print("Enter the date(dd/mm/yyyy): ");
		String date = input.next();
		System.out.print("Enter the time(hh/mm): ");
		String time = input.next();
		System.out.println("Choose the class type: ");
		System.out.println("1. Platinum($100 per ticket) ");
		System.out.println("2. Gold($50 per ticket)");
		String classType = input.nextInt();
		ShowingTime st = new ShowingTime(cinemaCode, movie, date, time, classType);
		oosShow.writeInt((int)oisShow.readInt()+1);
		oosShow.writeObject(st);
		System.out.println("New movie is added successfully!");
	}

	private void updateShowingTime(){

	}
	private void removeShowingTime(){

	}
}

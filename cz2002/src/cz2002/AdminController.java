package cz2002;

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

	public static void adminManager() {

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

		while (loop) {

			System.out.println("input choice:");
			switch (input.nextInt()) {
			case 1:
				createMovie();
				break;
			case 2:
				updateMovie();
				break;
			case 3:
				removeMovie();
				break;
			case 4:
				createShowingTime();
				break;
			case 5:
				updateShowingTime();
				break;
			case 6:
				removeShowingTime();
				break;
			case 7:
				otherConfigure();
				break;
			case 8:
				loop = false;
			default:
				break;
			}

		}

	}
}

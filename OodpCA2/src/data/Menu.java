package data;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

	Scanner selection = new Scanner(System.in);

	public void ReportMenu(SetUpData setData) {
		System.out.println();
		System.out.println("| REPORT MENU |");
		System.out.println();
		System.out.println("[1] Highest capital company");
		System.out.println("[2] Lowest capital company");
		System.out.println("[3] Highest share investor");
		System.out.println("[4] Lowest share investor");
		System.out.println("[5] Cancel");
		System.out.println();
		System.out.print("Please make your choice from the options above: ");
		int option = selection.nextInt();

		try {
			switch (option) {
			case 1:
				ReportMenu(setData);
				break;
			case 2:
				ReportMenu(setData);
				break;
			case 3:
				ReportMenu(setData);
				break;
			case 4:
				ReportMenu(setData);
				break;
			case 5:
				StartMenu(setData);
				break;

			default:
				System.out.println("");
				System.out.println("No options match your input");
				System.out.println("Please, try again");
				ReportMenu(setData);
			}

		} catch (InputMismatchException e) {
			System.out.println("please, try again");
			selection.next();
			ReportMenu(setData);
		}
	}

	public void StartMenu(SetUpData setData) {
		System.out.println();
		System.out.println("| MENU |");
		System.out.println();
		System.out.println("[1] Display Investors");
		System.out.println("[2] Display Companies");
		System.out.println("[3] Start Trading Day");
		System.out.println("[4] Exit");
		System.out.println();
		System.out.print("Please make your choice from the options above: ");
		int option = selection.nextInt();

		try {
			switch (option) {
			case 1:

				StartMenu(setData);
				break;
			case 2:
				StartMenu(setData);
				break;
			case 3:
				ReportMenu(setData);
				break;
			case 4:
				System.out.println("thanks for visiting... bye");
				System.exit(0);
				break;
			default:
				System.out.println("");
				System.out.println("No options match your input");
				System.out.println("Please, try again");
				ReportMenu(setData);
			}

		} catch (InputMismatchException e) {
			System.out.println("please, try again");
			selection.next();
			ReportMenu(setData);
		}
	}

}

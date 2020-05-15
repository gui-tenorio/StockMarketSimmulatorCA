package data;

import java.util.InputMismatchException;
import java.util.Scanner;

import data.TradingDay;
import data.PrintOnScreen;

public class Menu {

	PrintOnScreen printOut = new PrintOnScreen();
	Scanner selection = new Scanner(System.in);

	public void ReportMenu(SetUpDBData setData) {
		System.out.println();
		System.out.println("| REPORT MENU |");
		System.out.println();
		System.out.println("[1] Highest capital company");
		System.out.println("[2] Lowest capital company");
		System.out.println("[3] Highest share investor");
		System.out.println("[4] Lowest share investor");
		System.out.println("[5] Exit");
		System.out.println();
		System.out.print("Please choose one of the options above: ");
		int option = selection.nextInt();

		try {
			switch (option) {
			case 1:
				printOut.calculateCapital(setData);
				printOut.printHighestCapital();
				ReportMenu(setData);
				break;
			case 2:
				printOut.calculateCapital(setData);
				printOut.printLowestCapital();
				ReportMenu(setData);
				break;
			case 3:
				printOut.calculateNumberOfShares(setData);
				printOut.printHighestSharesInvestor();
				ReportMenu(setData);
				break;
			case 4:
				printOut.calculateNumberOfShares(setData);
				printOut.printLowestSharesInvestor();
				ReportMenu(setData);
				break;
			case 5:
				StartMenu(setData);
				break;

			default:
				System.out.println("");
				System.out.println("Not found");
				System.out.println("Please, try again");
				ReportMenu(setData);
			}

		} catch (InputMismatchException e) {
			System.out.println("please, try again");
			selection.next();
			ReportMenu(setData);
		}
	}

	public void StartMenu(SetUpDBData setData) {
		System.out.println();
		System.out.println("| MENU |");
		System.out.println();
		System.out.println("[1] Display Investors on the screen");
		System.out.println("[2] Display Companies on the screen");
		System.out.println("[3] Start Trading Day");
		System.out.println("[4] Exit");
		System.out.println();
		System.out.print("Please choose one of the options above: ");
		int option = selection.nextInt();

		try {
			switch (option) {
			case 1:
				printOut.displayInvestors(setData);
				StartMenu(setData);
				break;
			case 2:
				printOut.displayCompanies(setData);
				StartMenu(setData);
				break;
			case 3:
				TradingDay td = new TradingDay();
				td.Trade(setData);
				ReportMenu(setData);
				break;
			case 4:
				System.out.println("thanks for visiting... bye");
				System.exit(0);
				break;
			default:
				System.out.println("");
				System.out.println("Not found");
				System.out.println("Please, try again");
				ReportMenu(setData);
			}

		} catch (InputMismatchException e) {
			System.out.println("Please, try again");
			selection.next();
			ReportMenu(setData);
		}
	}

}

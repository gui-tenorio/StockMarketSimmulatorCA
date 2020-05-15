package data;

import java.util.ArrayList;
import data.SetUpDBData;
import company.Company;
import investor.Investor;

public class PrintOnScreen {

	ArrayList<Company.CompanyBuilder> highestCapitalResults = new ArrayList();
	ArrayList<Company.CompanyBuilder> lowestCapitalResults = new ArrayList();

	ArrayList<Investor.InvestorBuilder> highestSharesResult = new ArrayList();
	ArrayList<Investor.InvestorBuilder> lowestSharesResult = new ArrayList();

	
//	display investor
	public void displayInvestors(SetUpDBData setData) {

		for (int i = 0; i < setData.listOfInvestor.size(); i++) {
			Investor.InvestorBuilder in = setData.listOfInvestor.get(i);
			System.out.println();
			System.out.println(in.build().toString());
			System.out.println();
		}
	}

//	display companies
	public void displayCompanies(SetUpDBData setData) {

		for (int i = 0; i < setData.listOfCompany.size(); i++) {
			Company.CompanyBuilder c = setData.listOfCompany.get(i);
			System.out.println();
			System.out.println(c.build().toString());
			System.out.println();
		}
	}

//	take the company with the highest capital
	public void calculateCapital(SetUpDBData setData) {
		double highest = 0;
		double lowest = 10000000;

//		take the highest capital among companies
		for (int i = 0; i < setData.listOfCompany.size(); i++) {
			Company.CompanyBuilder c = setData.listOfCompany.get(i);
			double capital = c.build().getShares() * c.build().getSharePrice();
			if (capital > highest) {
				highest = capital;
			} else if (capital < lowest) {
				lowest = capital;
			}
		}

//		check if there are more than one company with the highest capital
		for (int i = 0; i < setData.listOfCompany.size(); i++) {
			Company.CompanyBuilder c = setData.listOfCompany.get(i);
			double capital = c.build().getShares() * c.build().getSharePrice();
			if (capital == highest && !highestCapitalResults.contains(c)) {
				highestCapitalResults.add(c);
			} else if (capital == lowest && !lowestCapitalResults.contains(c)) {
				lowestCapitalResults.add(c);
			}
		}

	}

	public void printLowestCapital() {
		System.out.println();
		System.out.println("----- Company(ies) with the lowest capital (shares * shares price) -----");
		for (int i = 0; i < lowestCapitalResults.size(); i++) {
			Company.CompanyBuilder c = lowestCapitalResults.get(i);
			System.out.println();
			System.out.println();
			System.out.println(c.build().toString());
			System.out.println();
		}
	}

	public void printHighestCapital() {
		System.out.println();
		System.out.println("----- Company(ies) with the highest capital (shares * shares price) -----");
		for (int i = 0; i < highestCapitalResults.size(); i++) {
			Company.CompanyBuilder c = highestCapitalResults.get(i);
			System.out.println();
			System.out.println();
			System.out.println(c.build().toString());
			System.out.println();
		}
	}

	
//	return the investor with the highest number of shares
	public void calculateNumberOfShares(SetUpDBData setData) {
		int highest = 0;
		int lowest = 10000;

//		 get the lowest number of shares between the investors
		for (int i = 0; i < setData.listOfInvestor.size(); i++) {
			Investor.InvestorBuilder in = setData.listOfInvestor.get(i);
			int shares = in.build().getShares();
			if (shares > highest) {
				highest = shares;
			} else if (shares < lowest) {
				lowest = shares;
			}
		}

//		check if there are more than one investor with the highest number of shares
		for (int i = 0; i < setData.listOfInvestor.size(); i++) {
			Investor.InvestorBuilder in = setData.listOfInvestor.get(i);
			int shares = in.build().getShares();
			if (shares == highest && !highestSharesResult.contains(in)) {
				highestSharesResult.add(in);
			} else if (shares == lowest && !lowestSharesResult.contains(in)) {
				lowestSharesResult.add(in);
			}
		}
	}

	public void printHighestSharesInvestor() {
		System.out.println();
		System.out.println("----- Investor(s) with the highest number of shares -----");
		for (int i = 0; i < highestSharesResult.size(); i++) {
			Investor.InvestorBuilder in = highestSharesResult.get(i);
			System.out.println();
			System.out.println();
			System.out.println(in.build().toString());
			System.out.println();
		}
	}

	public void printLowestSharesInvestor() {
		System.out.println();
		System.out.println("----- Investor(s) with the lowest number of shares -----");
		for (int i = 0; i < lowestSharesResult.size(); i++) {
			Investor.InvestorBuilder in = lowestSharesResult.get(i);
			System.out.println();
			System.out.println();
			System.out.println(in.build().toString());
			System.out.println();
		}
	}

	public void printCompanies(SetUpDBData setData) {
		int higher = 0;
		int lowest = 2000;

		for (int i = 0; i < setData.listOfInvestor.size(); i++) {
			Investor.InvestorBuilder in = setData.listOfInvestor.get(i);
			int size = in.getCompanies().size();
			if (size > higher) {
				higher = size;
			} else if (size < lowest) {
				lowest = size;
			}
		}

	}

}

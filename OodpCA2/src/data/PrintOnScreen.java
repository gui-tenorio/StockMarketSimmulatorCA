package data;

import java.util.ArrayList;

import data.SetUpDBData;
import data.SetUpDBData;
import company.Company;
import investor.Investor;

public class PrintOnScreen {
	
	ArrayList<Company.CompanyBuilder> highestCapitalResults = new ArrayList();
	ArrayList<Company.CompanyBuilder> lowestCapitalResults = new ArrayList();
	
	ArrayList<Investor.InvestorBuilder> highestSharesResult = new ArrayList();
	ArrayList<Investor.InvestorBuilder> lowestSharesResult = new ArrayList();
	
	
	public void displayInvestors(SetUpDBData setData) {

		for (int i = 0; i < setData.listOfInvestor.size(); i++) {
			Investor.InvestorBuilder in = setData.listOfInvestor.get(i);
			System.out.println();
			System.out.println(in.build().toString());
			System.out.println();
		}
	}

	public void displayCompanies(SetUpDBData setData) {

		for (int i = 0; i < setData.listOfCompany.size(); i++) {
			Company.CompanyBuilder c = setData.listOfCompany.get(i);
			System.out.println();
			System.out.println(c.build().toString());
			System.out.println();
		}
	}
}

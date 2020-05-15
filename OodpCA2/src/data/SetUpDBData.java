package data;

import java.util.ArrayList;
import java.util.Random;

import DataAccessObject.MySqlCompany;
import DataAccessObject.MySqlInvestor;
import data.StoredData;
import company.Company;
import investor.Investor;

public class SetUpDBData {

	int amtOfCompanies = 100;
	int amtOfInvestors = 100;

	public StoredData sd = new StoredData();

	public static ArrayList<Company.CompanyBuilder> listOfCompany = new ArrayList();

	public static ArrayList<Investor.InvestorBuilder> listOfInvestor = new ArrayList();

	Random r = new Random();

	// Singleton Pattern
	MySqlCompany dbCompany = MySqlCompany.getInstance();

	MySqlInvestor dbInvestor = MySqlInvestor.getInstance();

	public void getItReady() {

		dbCheck();

	}

	public void dbCheck() {

		ArrayList<Company.CompanyBuilder> companies = dbCompany.getCompanies();

		ArrayList<Investor.InvestorBuilder> investors = dbInvestor.getInvestors();

		// if db is empty we create the data
		if (investors.isEmpty() && companies.isEmpty()) {
			createData();
			fillDB();
		} else {
			// get data from db
			for (int i = 0; i < companies.size(); i++) {
				Company.CompanyBuilder company = companies.get(i);
				listOfCompany.add(company);
			}

			for (int i = 0; i < investors.size(); i++) {
				Investor.InvestorBuilder investor = investors.get(i);
				listOfInvestor.add(investor);
			}
		}
	}

	public void createData() {

		for (int i = 0; i < amtOfInvestors; i++) {
			listOfInvestor.add(new Investor.InvestorBuilder());
		}

		for (int i = 0; i < amtOfCompanies; i++) {
			listOfCompany.add(new Company.CompanyBuilder());
		}
	}

	public void fillDB() {

		listOfCompany.stream().forEach((Company.CompanyBuilder company) -> {
			company.setName(sd.companyName[r.nextInt(sd.companyName.length)]);

			System.out.println("creating company data...");
			dbCompany.saveCompany(company);
		});

		listOfInvestor.stream().forEach((Investor.InvestorBuilder investor) -> {
			investor.setFirstName(sd.firstName[r.nextInt(sd.firstName.length)]);
			investor.setSurname(sd.surname[r.nextInt(sd.surname.length)]);

			System.out.println("creating investor data...");
			dbInvestor.saveInvestor(investor);
		});

		dbCheck();
	}

}

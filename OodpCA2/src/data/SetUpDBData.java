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
		

		createData();
		fillDB();
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
			
			

		});
		
		listOfInvestor.stream().forEach((Investor.InvestorBuilder investor) -> {
			investor.setFirstName(sd.firstName[r.nextInt(sd.firstName.length)]);
			investor.setSurname(sd.surname[r.nextInt(sd.surname.length)]);
			

		});
		

		
	}


}

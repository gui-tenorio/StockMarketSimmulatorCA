package data;

import java.util.ArrayList;
import java.util.Random;

import data.Menu;
import data.SetUpDBData;
import company.Company;
import investor.Investor;

public class TradingDay {

	int transaction = 0;
	boolean isOpen = true;

	Random r = new Random();

	public static ArrayList<Company.CompanyBuilder> listOfTradeCompanies = new ArrayList();
	public static ArrayList<Investor.InvestorBuilder> listOfTradeInvestors = new ArrayList();

	public void Trade(SetUpDBData setData) {

		while (isOpen) {
			System.out.println("Trading...");

			int randomCompany = r.nextInt(setData.listOfCompany.size());
			int randomInvestor = r.nextInt(setData.listOfInvestor.size());

			Investor.InvestorBuilder investor = setData.listOfInvestor.get(randomInvestor);
			Company.CompanyBuilder company = setData.listOfCompany.get(randomCompany);


			if (company.build().getShares() > 0 && investor.build().getBudget() >= company.build().getSharePrice()) {

				if (investor.available(company)) {
					investor.addCompany(company);
					double price = company.build().getSharePrice();
					investor.buyShare(price);
					company.sellShare();
					listOfTradeCompanies.add(company);
					listOfTradeInvestors.add(investor);

					transaction++;

					
					if (company.build().getCount() % 10 == 0) {
						company.setSharePrice(company.build().getSharePrice() * 2);
					}

					if (transaction % 10 == 0) {
						updateSharePrice(setData);
					}
					checkInvestorContinue(setData);

					checkCompanyContinue(setData);

				}
			}
		}
	}

	public void updateSharePrice(SetUpDBData setData) {
		ArrayList<Company.CompanyBuilder> lastTen = new ArrayList();

		if (listOfTradeCompanies.size() % 10 == 0) {
			for (int i = (listOfTradeCompanies.size() - 10); i < listOfTradeCompanies.size(); i++) {
				Company.CompanyBuilder company = listOfTradeCompanies.get(i);
				lastTen.add(company);
			}

			for (int i = 0; i < setData.listOfCompany.size(); i++) {
				Company.CompanyBuilder company = setData.listOfCompany.get(i);
				for (int j = 0; j < lastTen.size(); j++) {
					Company.CompanyBuilder tradeCompany = lastTen.get(j);
					if (setData.listOfCompany.contains(tradeCompany)) {
						continue;
					} else {
						company.setSharePrice(
								company.build().getSharePrice() - (company.build().getSharePrice() * 0.02));
					}
				}
			}
		} else {
			lastTen.clear();
		}
	}

	public void checkInvestorContinue(SetUpDBData setData) {
		int count = 0;

		Company.CompanyBuilder company;

		for (int i = 0; i < setData.listOfInvestor.size(); i++) {
			Investor.InvestorBuilder in = setData.listOfInvestor.get(i);
			company = setData.listOfCompany.get(i);

			if (in.build().getBudget() < company.build().getSharePrice()) {
				count++;
			}

			if (count == setData.listOfInvestor.size()) {
				isOpen = false;
			}
			if (isOpen != true) {
				System.out.println("Investors out of money!! Trading Day is over!");
				Menu menu = new Menu();
				menu.ReportMenu(setData);
			}
		}
	}

	public void checkCompanyContinue(SetUpDBData setData) {
		int count = 0;

		for (int i = 0; i < setData.listOfCompany.size(); i++) {
			Company.CompanyBuilder company = setData.listOfCompany.get(i);
			if (company.build().getShares() <= 0) {
				count++;
			}
			if (count == setData.listOfCompany.size()) {
				isOpen = false;
			}
			if (isOpen != true) {
				System.out.println("Companies out of shares!! Trading Day is over!");
				Menu menu = new Menu();
				menu.ReportMenu(setData);
			}
		}
	}

}

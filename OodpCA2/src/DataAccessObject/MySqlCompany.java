package DataAccessObject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import company.Company;

public class MySqlCompany implements DAOCompany {

//	array list that holds all companies
	ArrayList<Company.CompanyBuilder> company = new ArrayList<Company.CompanyBuilder>();

	// Singleton pattern
	static private MySqlCompany instance = new MySqlCompany();

	
//	get all companies
	@Override
	public ArrayList<Company.CompanyBuilder> getCompanies() {

		String query = "SELECT * FROM Company";

		DataSource db = new DataSource();

		ResultSet rs = db.select(query);

//		loop ove the result set
		try {
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int shares = rs.getInt(3);
				double sharePrice = rs.getDouble(4);

				company.add(new Company.CompanyBuilder(id, name, shares, sharePrice));
			}

			db.closing();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return company;
	}

	@Override
	public boolean saveCompany(Company.CompanyBuilder company) {

//		access db
		DataSource db = new DataSource();

//		get data from object
		int id = company.build().getId();
		String name = company.build().getName();
		int shares = company.build().getShares();
		double sharePrice = company.build().getSharePrice();

		String query = "INSERT INTO Company (id, name, shares, sharePrice) values ('" + id + "', '" + name + "', '"
				+ shares + "', '" + sharePrice + "')";

		// save the data
		boolean result = db.save(query);

		// closing database
		db.closing();

		return result;
	}

	public static MySqlCompany getInstance() {
		return instance;
	}
}

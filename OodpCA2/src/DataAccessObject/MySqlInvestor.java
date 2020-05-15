package DataAccessObject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DataAccessObject.MySqlInvestor;
import investor.Investor;

public class MySqlInvestor implements DAOInvestor{

	
//	array list with all investors
	private ArrayList<Investor.InvestorBuilder> investor = new ArrayList<Investor.InvestorBuilder>();
	
	
	// Singleton pattern
	static private MySqlInvestor instance = new MySqlInvestor();
	
	
	// get all the companies
		@Override
		public ArrayList<Investor.InvestorBuilder> getInvestors() {
			
//			array list with all companies
			ArrayList<Investor.InvestorBuilder> investor = new ArrayList<Investor.InvestorBuilder>();
			
			String query = "SELECT * FROM Investor";
			
//			access the db
			DataSource db = new DataSource();
			
//			querying the db
			ResultSet rs = db.select(query);
			
//			loop the result set
			try {
				while(rs.next()) {
					int id = rs.getInt(1);
					String firstName = rs.getString(2);
					String surname = rs.getString(3);
					double budget = rs.getDouble(4);
					
					investor.add(new Investor.InvestorBuilder(id, firstName, surname, budget));
				}
				
				db.closing();
				
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
			return investor;
		}
		
		
		@Override
		public boolean saveInvestor(Investor.InvestorBuilder investor) {
			
//			access the db
			DataSource db = new DataSource();
			
//			get data from object
			int id = investor.build().getId();
			String firstName = investor.build().getFirstName();
			String surname = investor.build().getSurname();
			double budget = investor.build().getBudget();
			
			String query = "INSERT INTO Investor (id, firstName, surname, budget) values ('"+ id + "', '" + firstName + "', '" + surname + "', '" + budget +"')";
			
//			save data
			boolean result = db.save(query);
					
//			close db
			db.closing();
					
			return result;
		}

//		added a static public getter for the instance
		public static MySqlInvestor getInstance() {
			return instance;
		}

}

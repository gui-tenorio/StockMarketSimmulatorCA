package DataAccessObject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DataAccessObject.MySqlInvestor;
import investor.Investor;

public class MySqlInvestor implements DAOInvestor{

	
	
	private ArrayList<Investor.InvestorBuilder> investor = new ArrayList<Investor.InvestorBuilder>();
	
	
	// Singleton pattern
	static private MySqlInvestor instance = new MySqlInvestor();
	
	
	
		@Override
		public ArrayList<Investor.InvestorBuilder> getInvestors() {
			

			ArrayList<Investor.InvestorBuilder> investor = new ArrayList<Investor.InvestorBuilder>();
			

			String query = "SELECT * FROM Investor";
			

			DataSource db = new DataSource();
			

			ResultSet rs = db.select(query);
			

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
			

			DataSource db = new DataSource();
			

			int id = investor.build().getId();
			String firstName = investor.build().getFirstName();
			String surname = investor.build().getSurname();
			double budget = investor.build().getBudget();
			

			String query = "INSERT INTO Investor (id, firstName, surname, budget) values ('"+ id + "', '" + firstName + "', '" + surname + "', '" + budget +"')";
			

			boolean result = db.save(query);
					

			db.closing();
					
			return result;
		}
		
		

		public static MySqlInvestor getInstance() {
			return instance;
		}

}

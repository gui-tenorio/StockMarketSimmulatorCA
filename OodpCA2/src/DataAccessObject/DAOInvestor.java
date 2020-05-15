package DataAccessObject;

import java.util.ArrayList;

import investor.Investor;

public interface DAOInvestor {

	public ArrayList<Investor.InvestorBuilder> getInvestors();
	public boolean saveInvestor(Investor.InvestorBuilder investor);
}

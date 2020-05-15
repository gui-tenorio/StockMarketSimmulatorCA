package DataAccessObject;

import java.util.ArrayList;

import company.Company;

public interface DAOCompany {
	public ArrayList<Company.CompanyBuilder> getCompanies();
	public boolean saveCompany(Company.CompanyBuilder company);

}

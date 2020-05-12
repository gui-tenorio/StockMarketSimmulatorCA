package investor;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;



public class Investor {
	
	private static final AtomicInteger idGenerator = new AtomicInteger(1000);
    private final Integer id;
	private double budget; // 1000 - 10000
	private String firstName;
	private String surname;
	private int shares;
	
	
	private Investor(InvestorBuilder builder) {
		this.id = builder.id;
		this.firstName = builder.firstName;
		this.surname = builder.surname;
		this.budget = builder.budget;
		this.shares = builder.shares;
	}


	public Integer getId() {
		return id;
	}


	public double getBudget() {
		return budget;
	}


	public String getFirstName() {
		return firstName;
	}
	
	public String getName() {
		return firstName + " " + surname;
	}


	public String getSurname() {
		return surname;
	}


	public int getShares() {
		return shares;
	}


	public String toString() {
		return "Investor ID: " +this.getId() + " | name: " + this.getName() +  "\n"
				+ "budget: $"	+ this.getBudget()+ "\n"
				+ "shares: " + this.getShares();
				
	}
	
public static class InvestorBuilder {
		
		private static final AtomicInteger idGenerator = new AtomicInteger(1000);
	    private final Integer id;
		private double budget; // 1000 - 10000
		private String firstName;
		private String surname;
		private int shares;
		
		
		
		
		Random r = new Random();
		
		int minBudget = 1000;
		int maxBudget = 10000;
		
		public InvestorBuilder() {
			this.budget = r.nextInt(maxBudget-minBudget) + minBudget;
			this.id = idGenerator.getAndIncrement();
			
		}
		
		
		public InvestorBuilder(int id, String firstName, String surname, double budget ) {
			this.id = id;
			this.firstName = firstName;
			this.surname = surname;
			this.budget = budget;
			this.shares = 0;
			
		}
		
		public InvestorBuilder setFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}
		
		public InvestorBuilder setSurname(String surname) {
			this.surname = surname;
			return this;
		}
		
		public InvestorBuilder setName(String firstName, String surname) {
			this.firstName = firstName;
			this.surname = surname;
			return this;
		}
		
		public InvestorBuilder setBudget(double budget) {
			this.budget = budget;
			return this;
		}
		
		public void buyShare(double price) {
			this.setBudget(build().getBudget() - price);
			this.shares++;
		}
		
		
		public Investor build() {
			return new Investor(this);
		}
	}
	
	
	

}

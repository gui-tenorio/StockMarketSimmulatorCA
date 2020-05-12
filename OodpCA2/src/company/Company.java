package company;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Company {

	private static final AtomicInteger idGenerator = new AtomicInteger(1000);
    private final Integer id;
	private int shares; // 500 - 1000
	private double sharePrice; // 10 - 100
	private String name;
	private int count; // counts sold shares
	
	
	
	
	private Company(CompanyBuilder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.shares = builder.shares;
		this.sharePrice = builder.sharePrice;
		this.count = builder.count;
	}
	
	
	public String toString() {
		return "Company ID: " +this.getId() + " | name: " + this.getName() +  "\n"
				+ "shares: " + this.getShares() + "\n"
				+ "share price: $"	+ this.getSharePrice();
	}

	public int getShares() {
		return shares;
	}

	public double getSharePrice() {
		return sharePrice;
	}

	public String getName() {
		return name;
	}
	

	public int getCount() {
		return count;
	}
	
	public int getId() {
		return id;
	}
	
	
	
	public static class CompanyBuilder {
		private static final AtomicInteger idGenerator = new AtomicInteger(1000);
	    private final Integer id;
		private int shares; // 500 - 1000
		private double sharePrice; // 10 - 100
		private String name;
		private int count; // counts sold shares
		
		
		Random r = new Random();
		int minShare = 500;
		int maxShare = 1000;
		
		int minPrice = 10;
		int maxPrice = 100;
		
		
		public CompanyBuilder() {
			this.shares = r.nextInt(maxShare-minShare) + minShare;
			this.sharePrice = r.nextInt(maxPrice-minPrice)+ minPrice;
			this.count = 0;
			this.id = idGenerator.getAndIncrement();
		}
		
		public CompanyBuilder(int id, String name, int shares, double sharePrice) {
			this.id = id;
			this.name = name;
			this.shares = shares;
			this.sharePrice = sharePrice;
			this.count = 0;
		}
		
		public CompanyBuilder setName(String name) {
			this.name = name;
			return this;
		}
		
		
		public CompanyBuilder setSharePrice(double sharePrice) {
			this.sharePrice = sharePrice;
			return this;
		}
		
		public CompanyBuilder setShares(int shares) {
			this.shares = shares;
			return this;
		}
		
		public CompanyBuilder setCount(int count) {
			this.count = count;
			return this;
		}
		
		public void sellShare() {
			this.setShares(build().getShares()-1);
			this.count++;
		}
		
	
		public Company build() {
			return new Company(this);
		}
	}
	
	
	

}

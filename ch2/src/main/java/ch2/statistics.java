package ch2;

public class statistics {
	
	private String event_name;
	private int event_cost;
	private int tickets_sold;
	private double credits_won;
	private double money_won;
	
	public statistics(String event_name, int event_cost, int tickets_sold,
			double credits_won, double money_won) {
		this.event_name = event_name;
		this.event_cost = event_cost;
		this.tickets_sold = tickets_sold;
		this.credits_won = credits_won;
		this.money_won = money_won;
	}

	public String getEvent_name() {
		return event_name;
	}

	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}

	public int getEvent_cost() {
		return event_cost;
	}

	public void setEvent_cost(int event_cost) {
		this.event_cost = event_cost;
	}

	public int getTickets_sold() {
		return tickets_sold;
	}

	public void setTickets_sold(int tickets_sold) {
		this.tickets_sold = tickets_sold;
	}

	public double getCredits_won() {
		return credits_won;
	}

	public void setCredits_won(double credits_won) {
		this.credits_won = credits_won;
	}

	public double getMoney_won() {
		return money_won;
	}

	public void setMoney_won(double money_won) {
		this.money_won = money_won;
	};
	
	

}


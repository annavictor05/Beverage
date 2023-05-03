import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.lang.Math;

public class Order implements OrderInterface, Comparable<Order> {
    private int orderNumber;
    private int orderTime;
    private DAY orderDay;
    private Customer customer;
    private ArrayList<Beverage> beverage;

    // Constructor
    public Order(int orderTime, DAY orderDay, Customer customer) {
        this.orderNumber = generateOrderNumber();
        this.orderTime = orderTime;
        this.orderDay = orderDay;
        this.customer = new Customer(customer);
        this.beverage = new ArrayList<>();
    }

    // Generate a random order number between 10000 and 90000
    private int generateOrderNumber() {
        int rand = 10000 + (int)(Math.random() * ((90000 - 10000) + 1));
        return rand;
    }

    // Add a new beverage to the order
    public void addNewBeverage(Beverage beverage) {
        this.beverage.add(beverage);
    }

    // Overridden toString method
    @Override
    public String toString() {
    	String total = "ORDER NUMBER: " + this.getOrderNo() + "\nCUSTOMER NAME: " + this.getCustomer().getName() + "\n ORDER TOTAL:" + this.calcOrderTotal() + "\n";
		for(int i = 0; i < beverage.size();i++) {
			total += "[ "+this.getBeverage(i).toString()+"]";
		}
		return total;
    }

    // Override the compareTo method to compare orders based on order number
    @Override
    public int compareTo(Order otherOrder) {
        if (this.orderNumber == otherOrder.getOrderNo()) {
            return 0;
        } else if (this.orderNumber > otherOrder.getOrderNo()) {
            return 1;
        } else {
            return -1;
        }
    }

    // Getters and setters
   
    public int getOrderNo() {
        return this.orderNumber;
    }

    public int getOrderTime() {
        return this.orderTime;
    }

    public void setOrderTime(int orderTime) {
        this.orderTime = orderTime;
    }

    public DAY getOrderDay() {
        return this.orderDay;
    }

    public void setOrderDay(DAY orderDay) {
        this.orderDay = orderDay;
    }

    public Customer getCustomer() {
        return new Customer(this.customer);
    }

    public void setCustomer(Customer customer) {
        this.customer = new Customer(customer);
    }

    public List<Beverage> getBeverageList() {
        return new ArrayList<>(this.beverage);
    }

    public void setBeverageList(List<Beverage> beverageList) {
        this.beverage = new ArrayList<>(beverageList);
    }

	@Override
	public boolean isWeekend() {
		if(orderDay==DAY.SUNDAY||orderDay==DAY.SATURDAY) {
			return true;
		}
		else
		{		
			return false;
		}
	}

	@Override
	public Beverage getBeverage(int itemNo) {
		return beverage.get(itemNo);
	}

	@Override
	public void addNewBeverage(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
		Coffee c = new Coffee(bevName, size, extraShot, extraSyrup);
		beverage.add(c);		
	}

	@Override
	public void addNewBeverage(String bevName, SIZE size) {
		Alcohol a = new Alcohol(bevName, size, this.isWeekend());
		beverage.add(a);		
	}

	@Override
	public void addNewBeverage(String bevName, SIZE size, int numOfFruits, boolean addPRotien) {
		Smoothie s = new Smoothie(bevName, size, numOfFruits, addPRotien);
		beverage.add(s);
			
	}

	@Override
	public double calcOrderTotal() {
		double total = 0.0;
		for(int i = 0; i < beverage.size();i++) {
			total = total + beverage.get(i).calcPrice();
			
		}
		return total;
	}

	@Override
	public int findNumOfBeveType(TYPE type) {
		int bevtype =0;
		for (int i = 0; i < beverage.size();i++) {
			if(beverage.get(i).getType()==type) {
				bevtype++;
			}
		}
		return bevtype; 
	}
	

	public int getTotalItems() {
		return beverage.size();
	}
}

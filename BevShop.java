import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BevShop implements BevShopInterfce {
    private ArrayList<Order> numOfOrders;
    private Order currentOrder;
    private static final int MAX_ALCOHOLS = 3;
    private static final int MINIMUM_AGE = 21;
    
    public BevShop() {
    	numOfOrders = new ArrayList<Order>();
    	
    }
    
    public boolean validTime (int T) {
    	return (MIN_TIME <= T) && (MAX_TIME >= T);
    }
    public boolean eligibleForMore() {
		return getNumOfAlcoholDrink() < MAX_ALCOHOLS;
	}
    public boolean validAge(int age) {
		return age > MIN_AGE_FOR_ALCOHOL;
	}
    
    @Override
	public void startNewOrder(int time, DAY day, String customerName, int customerAge) {
		currentOrder = new Order(time, day, new  Customer(customerName, customerAge));
		numOfOrders.add(currentOrder);	
	}
	@Override
	public void processCoffeeOrder(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
		this.currentOrder.addNewBeverage(bevName, size, extraShot, extraSyrup);
	}
	@Override
	public void processAlcoholOrder(String bevName, SIZE size) {
		this.currentOrder.addNewBeverage(bevName, size);		
	}
	@Override
	public void processSmoothieOrder(String bevName, SIZE size, int numOfFruits, boolean addProtien) {
		this.currentOrder.addNewBeverage(bevName, size, numOfFruits, addProtien);
	}
	@Override
	public int findOrder(int orderNo) {
		for(int i = 0; i < numOfOrders.size(); i++) {
			if(numOfOrders.get(i).getOrderNo() == orderNo) {
				return i; 
			}
		}
		
		return -1;
	}
	public double totalMonthlySale() {
		double total = 0;
		for(int i = 0; i < numOfOrders.size(); i++) {
			total+=numOfOrders.get(i).calcOrderTotal();
		}
		return total;
	}
	public double totalOrderPrice(int orderNo) {
		return numOfOrders.get(findOrder(orderNo)).calcOrderTotal();
	}
	
	
	public String toString() {
		String str = "BEV SHOP\nMONTHLY SALES:" + totalMonthlySale()  +"\n\n";
		for(int i = 0; i < numOfOrders.size(); i++) {
			str += "Order " + i + "\n";
			str += numOfOrders.get(i).toString();
		}
		return str;
	}
	public void sortOrders() {
		for (int i = 0; i < numOfOrders.size()-1; i++) {
			int minOrder = i;
			for (int j = i+1; j < numOfOrders.size(); j++) {
				if (numOfOrders.get(j).getOrderNo() < numOfOrders.get(minOrder).getOrderNo()) {
					minOrder = j;
				}
			}

			Order temp = numOfOrders.get(minOrder);
			numOfOrders.set(minOrder, numOfOrders.get(i));
			numOfOrders.set(i, temp);
		}
	}
	public Order getOrderAtIndex(int index) {
		return numOfOrders.get(index);
	}
	
	public int getNumOfAlcoholDrink() {
		return currentOrder.findNumOfBeveType(TYPE.ALCOHOL);
	}
	public Order getCurrentOrder() {
		return this.currentOrder;
	}


	public void setCurrentOrder(Order currentOrder) {
		this.currentOrder = currentOrder;
	}
	public int totalNumOfMonthlyOrders() {
		return numOfOrders.size();
	}


	public boolean isMaxFruit(int i) {
		return i>MAX_FRUIT;
	}

	public int getMaxOrderForAlcohol() {
		return MINIMUM_AGE;
	}

	public int getMinAgeForAlcohol() {
		return MAX_ALCOHOLS;
	}
	
    
    
    
}
    
    
  
    
    
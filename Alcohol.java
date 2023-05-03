public class Alcohol extends Beverage {
    private static final double WEEKEND_COST = 0.6;

    private boolean isWeekendOffered;

    public Alcohol(String name, SIZE size, boolean isWeekendOffered) {
        super (name, TYPE.ALCOHOL, size);
        this.isWeekendOffered = isWeekendOffered;
    }

    public boolean isWeekendOffered() {
        return isWeekendOffered;
    }

    public void setWeekendOffered(boolean weekendOffered) {
        isWeekendOffered = weekendOffered;
    }

    @Override
    public String toString() {
    	String outStr = "Alchohol Name: " + this.getBevName() + "\n";
		outStr += "Size: " + this.getSize() + "\n";
		outStr += "Served On Weekends: " + ((isWeekendOffered) ? "Yes\n": "No\n");
		outStr += "Price: " + this.calcPrice() + "\n";
		return outStr;
	}
    @Override
    public boolean equals(Object o) {
		return (this.getSize() == ((Beverage) o).getSize()) && (this.getBevName() == ((Beverage) o).getBevName()) && (this.getType() == ((Beverage) o).getType()) && (this.isWeekendOffered() == ((Alcohol) o).isWeekendOffered());
    }
    @Override
    public double calcPrice() {
        double basePrice = super.calcPrice();
        double weekendCost = isWeekendOffered ? WEEKEND_COST : 0;
        return basePrice + weekendCost;
    }
}

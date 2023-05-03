public class Smoothie extends Beverage {
    private static final double FRUIT_COST = 0.5;
    private static final double PROTEIN_COST = 1.5;

    private int numFruits;
    private boolean hasProteinPowder;

    public Smoothie(String name, SIZE size, int numFruits, boolean hasProteinPowder) {
        super(name,TYPE.SMOOTHIE, size);
        this.numFruits = numFruits;
        this.hasProteinPowder = hasProteinPowder;
    }

    public int getNumOfFruits() {
        return numFruits;
    }

    public void setNumFruits(int numFruits) {
        this.numFruits = numFruits;
    }

    public boolean hasProteinPowder() {
        return hasProteinPowder;
    }

    public void setHasProteinPowder(boolean hasProteinPowder) {
        this.hasProteinPowder = hasProteinPowder;
    }

    @Override
    public String toString() {
        String str = super.toString();
        str += ", ";
        if (hasProteinPowder) {
            str += "with protein, ";
        } else {
            str += "without protein, ";
        }
        str += numFruits + " fruits, ";
        str += "$" + String.format("%.2f", calcPrice());
        return str;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        Smoothie s = (Smoothie) o;
        return numFruits == s.numFruits && hasProteinPowder == s.hasProteinPowder;
    }

    @Override
    public double calcPrice() {
        double basePrice = super.calcPrice();
        double fruitCost = numFruits * FRUIT_COST;
        double proteinCost = hasProteinPowder ? PROTEIN_COST : 0;
        return basePrice + fruitCost + proteinCost;
    }
    public String getBevName() {
		return this.getName();
	}

	public SIZE getSize() {
		return getSize();
	}

	
	public boolean getAddProtien() {

		return getAddProtien();
	}
}

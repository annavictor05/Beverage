public abstract class Beverage {
    private final String name;
    private final TYPE type;
    private SIZE size;
    private final double basePrice = 2.0;
    private final double sizePrice = 1.0;

    public Beverage(String name, TYPE type, SIZE size) {
        this.name = name;
        this.type = type;
        this.size = size;
    }

    public double calcPrice() {
    	if(this.size.equals(SIZE.SMALL)) {
    		return basePrice;
    	}
    	if(this.size.equals(SIZE.MEDIUM)) {
			return basePrice+sizePrice;	
		}
		else {
			return basePrice+(sizePrice*2);
		}
    }

    @Override
    public String toString() {
        return name + " (" + size + ")";
    }

    
    public boolean equals(Beverage beverage) {
        return name.equals(beverage.name) && type.equals(beverage.type) && size.equals(beverage.size);
    }
    public TYPE getBevType() {
    	return this.type;
    }
    public String getBevName() {

		return this.name;
	}

    public String getName() {
        return name;
    }

    public TYPE getType() {
        return type;
    }

    public SIZE getSize() {
        return size;
    }

    public void setSize(SIZE size) {
        this.size = size;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public double getSizePrice() {
        return sizePrice;
    }
}

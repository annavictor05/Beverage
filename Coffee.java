public class Coffee extends Beverage {
    private boolean getExtraShot;
    private boolean getExtraSyrup;
    private final double EXTRA_PRICE = 0.5;
    String name;
    SIZE size;
    TYPE type = TYPE.COFFEE;

    public Coffee(String name,  SIZE size, boolean hasExtraShot, boolean hasExtraSyrup) {
        super(name, TYPE.COFFEE, size);
        this.getExtraShot = hasExtraShot;
        this.getExtraSyrup = hasExtraSyrup;
        this.name = name;
        this.size = size;
        
    }
    public double getBasePrice() {
		return super.getBasePrice();
    }
	

    @Override
    public double calcPrice() {
        double price = super.calcPrice();
        int result =0;
        if (getExtraShot) {
        	result++;
        }
        if (getExtraSyrup) {
        	result++;
        }
        
        return price+(EXTRA_PRICE*result);
    }

    @Override
    public String toString() {
    	String extra =  "";
		if(getExtraShot) {
			extra +="Extra shot";
		}if(getExtraSyrup) {
			extra+="Extra syrup";
		}else {
			extra+="Nothing";
		}
		return "Name : " + this.name + " Size : " + this.size + " Contains : "+extra+" Price : " + this.calcPrice();
	}

   
    public String getBevName() {
		return this.name;
	}

	public SIZE getSize() {

		return this.size;
	}

	public TYPE getType() {

		return this.type;
	}


	public boolean getExtraShot() {


		return getExtraShot;
	}


	public boolean getExtraSyrup() {

		return getExtraSyrup;
	}

}

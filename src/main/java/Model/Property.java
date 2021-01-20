package Model;

public class Property {

    private Player owner = null;
    private int selling_price;
    private int loan_price;
    private int position;

    public Property(int selling_price, int loan_price, int position){
        this.selling_price = selling_price;
        this.loan_price = loan_price;
        this.position = position;
    }

    public int getSelling_price(){
        return this.selling_price;
    }

    public int getLoan_price(){
        return this.loan_price;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public Player getOwner(){
        return this.owner;
    }

    public void resetProperty(){
        this.owner = null;
    }

    @Override
    public String toString() {
        if(getOwner() != null){
            return "Property{" +
                    "owner=" + getOwner().getName() +
                    ", selling_price=" + selling_price +
                    ", loan_price=" + loan_price +
                    ", postion=" + position +
                    '}';
        }
        return "Property{" +
                "selling_price=" + selling_price +
                ", loan_price=" + loan_price +
                ", postion=" + position +
                '}';


    }
}

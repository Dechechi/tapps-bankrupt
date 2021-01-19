package Model;

public class Property {

    private Player owner;
    private int selling_price;
    private int loan_price;
    private boolean bought;

    public Property(Player owner, int selling_price, int loan_price, boolean bought){
        this.owner = owner;
        this.selling_price = selling_price;
        this.loan_price = loan_price;
        this.bought = bought;
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
}

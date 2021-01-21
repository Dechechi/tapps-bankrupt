package purchase;

import model.Property;

public class PurchaseInpulsive implements Purchase{
    @Override
    public boolean purchase(Property property, int coins) {
        if(coins >= property.getSelling_price()){
            return true;
        }
        return false;
    }
}

package purchase;

import model.Property;

public class PurchaseCautious implements Purchase{
    @Override
    public boolean purchase(Property property, int coins) {
        if(coins - property.getSelling_price() >= 80){
            return true;
        }
        return false;
    }
}

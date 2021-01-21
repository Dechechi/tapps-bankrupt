package purchase;

import model.Property;

public class PurchasePicky implements Purchase{
    @Override
    public boolean purchase(Property property, int coins) {
        if(property.getLoan_price() > 50 && coins >= property.getSelling_price()){
            return true;
        }
        return false;
    }
}

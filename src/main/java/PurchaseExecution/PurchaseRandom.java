package PurchaseExecution;

import Model.Property;

import java.util.Random;

public class PurchaseRandom implements Purchase{
    @Override
    public boolean purchase(Property property, int coins) {
        Random rd =  new Random();
        int percent = rd.nextInt(100);
        if(percent >= 50 && coins >= property.getSelling_price()){
            return true;
        }
        return false;
    }
}

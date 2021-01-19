package Model;

import PurchaseExecution.Purchase;

import java.util.List;

public class Player {

    private String name;
    private int coins = 300;
    private int position = 0;
    private List<Property> properties = null;
    private Purchase behavior;

    public Player(String name, Purchase behavior){
        this.name = name;
        this.behavior = behavior;
    }

    public void setBehavior(Purchase behavior){
        this.behavior = behavior;
    }

    public boolean executePurchase(Property property){
        if(behavior.purchase(property, coins)){
            properties.add(property);
            this.coins -= property.getSelling_price();
            return true;
        }
        return false;
    }
}

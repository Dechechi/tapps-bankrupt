package Model;

import PurchaseExecution.Purchase;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private int coins = 300;
    private int position = 0;
    private List<Property> properties = new ArrayList<Property>();
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

    public void addCoins(int value){
        this.coins += value;
    }

    public void payLoan(Property property){
        if(property.getOwner().isAlive()) {
            this.coins -= property.getLoan_price();
            property.getOwner().addCoins(property.getLoan_price());
        }
    }

    public boolean isAlive(){
        return coins >= 0;
    }

    public void walk(int steps, int boardSize){
        this.position += steps;
        if(this.position > boardSize){
            addCoins(100);
            this.position = this.position - boardSize;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public int getCoins() {
        return coins;
    }

    public void resetProperties(){
        for(Property property : properties){
            property.setOwner(null);
        }
    }

    public void resetPlayer(){
        this.coins = 300;
        this.position = 0;
        this.properties = new ArrayList<Property>();
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", coins=" + coins +
                ", position=" + position +
                ", properties=" + properties +
                ", behavior=" + behavior +
                '}';
    }
}

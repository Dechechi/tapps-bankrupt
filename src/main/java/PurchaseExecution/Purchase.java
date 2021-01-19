package PurchaseExecution;

import Model.Property;

public interface Purchase {
    boolean purchase(Property property, int coins);
}

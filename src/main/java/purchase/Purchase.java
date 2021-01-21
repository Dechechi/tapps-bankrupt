package purchase;

import model.Property;

public interface Purchase {
    boolean purchase(Property property, int coins);
}

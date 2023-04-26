package toy_market.toys;

import java.util.ArrayList;

public abstract class Base_unit {
    int id;
    Type type;
    double chance;
    protected Base_unit(int id, Type type, double chance) {
        this.id = id;
        this.type = type;
        this.chance = chance;
    }

    public double setChance(double chance) {
        this.chance = chance;
        return this.chance;
    }
}

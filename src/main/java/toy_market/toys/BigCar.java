package toy_market.toys;

import java.util.ArrayList;

public class BigCar extends Base_unit {
    public BigCar(int id, String type, double chance) {
        super(id, Type.valueOf(type), chance);
    }
    public BigCar(int id) {
        super(id, Type.valueOf("bigCar"), 0.15);
    }
    @Override
    public String toString() {
        return ("Id: "+id+", "+type+", chance: "+chance);
    }
}

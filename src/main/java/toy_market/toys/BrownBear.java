package toy_market.toys;

public class BrownBear extends Base_unit {
    public BrownBear(int id, String type, double chance) {
        super(id, Type.valueOf(type), chance);
    }
    public BrownBear(int id) {
        super(id, Type.valueOf("brownbear"), 0.25);
    }
    @Override
    public String toString() {
        return ("Id: "+id+", "+type+", chance: "+chance);
    }

}

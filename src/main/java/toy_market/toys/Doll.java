package toy_market.toys;
public class Doll extends Base_unit{
    public Doll(int id, String type, double chance) {
        super(id, Type.valueOf(type), chance);
    }
    public Doll(int id) {
        super(id, Type.valueOf("doll"), 0.2);
    }
    @Override
    public String toString() {
        return ("Id: "+id+", "+type+", chance: "+chance);
    }
}

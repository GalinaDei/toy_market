package toy_market;
import toy_market.toys.*;
import static toy_market.toys.Store.*;
public class Main {
    public static void main(String[] args) {
        Store store = new Store();
        AddToy(Store.brownBears);
        AddToy(dolls);
        AddToy(bigCars);
        AddPrizeList(brownBears, dolls, bigCars, prizeList);
        while (true) {
            GetPrize(prizeList);
            if (prizeList.size()==0)
                break;;
        }
    }
}
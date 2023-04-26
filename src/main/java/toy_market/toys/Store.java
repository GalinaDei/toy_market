package toy_market.toys;
import java.io.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Store {
    public static ArrayList<Base_unit> brownBears;
    public static ArrayList<Base_unit> dolls;
    public static ArrayList<Base_unit> bigCars;
    public static ArrayList<Base_unit> prizeList;
    private static int storeSize = 10;

    public Store() {
        brownBears = new ArrayList<Base_unit>(storeSize);
        dolls = new ArrayList<Base_unit>(storeSize);
        bigCars = new ArrayList<Base_unit>(storeSize);
        prizeList = new ArrayList<Base_unit>(storeSize);
    }

    public static void AddToy(ArrayList<Base_unit> arrayToys) {
        try(FileWriter writer = new FileWriter("Id.txt", false))
        {
            String text = "0";
            writer.write(text);
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        while (arrayToys.size() < storeSize+1) {
            int id = 0;
            try {
                File file = new File("Id.txt");
                FileReader fr = new FileReader(file);
                BufferedReader reader = new BufferedReader(fr);
                id = Integer.parseInt(reader.readLine())+1;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (Objects.equals(arrayToys, brownBears)) {
                brownBears.add(new BrownBear(id));
            }
            if (Objects.equals(arrayToys, Store.dolls)) {
                arrayToys.add(new Doll(id));
            }
            if (Objects.equals(arrayToys, Store.bigCars)) {
                arrayToys.add(new BigCar(id));
            }
            try(FileWriter writer = new FileWriter("Id.txt", false))
            {
                String text = Integer.toString(id);
                writer.write(text);
                writer.flush();
            }
            catch(IOException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
    public static void AddPrizeList(ArrayList<Base_unit>brownBears, ArrayList<Base_unit>dolls,ArrayList<Base_unit>bigCars, ArrayList<Base_unit>prizeList){
        while (prizeList.size() < 5) {
            Type type = Type.values()[new Random().nextInt(Type.values().length)];
            if (Objects.equals(brownBears.get(0).type, type)) {
                prizeList.add(brownBears.get(0));
                brownBears.remove(0);
            }
            if (Objects.equals(dolls.get(0).type, type)) {
                prizeList.add(dolls.get(0));
                dolls.remove(0);
            }
            if (Objects.equals(bigCars.get(0).type, type)) {
                prizeList.add(bigCars.get(0));
                bigCars.remove(0);
            }
        }
        System.out.println("Prizelist: "+"\n"+prizeList);
    }
    public static void GetPrize(ArrayList<Base_unit>prizeList){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose one digit from 1 to 100 and enter it: ");
        int digit = scanner.nextInt();
        int bearNumber = 0;
        int dollNumber = 0;
        int carNumber = 0;
        for (int i = 0; i < prizeList.size(); i++) {
            if (Objects.equals(prizeList.get(i).type, Type.brownbear)){bearNumber++;}
            if (Objects.equals(prizeList.get(i).type, Type.doll)){dollNumber++;}
            if (Objects.equals(prizeList.get(i).type, Type.bigCar)){carNumber++;}
        }
        double bearChance = 0;
        double dollChance = 0;
        double carChance = 0;
        for (int i = 0; i < prizeList.size(); i++) {
            if (Objects.equals(prizeList.get(i).type, Type.brownbear)){bearChance = Math.round(100*prizeList.get(i).chance*bearNumber/prizeList.size());}
            if (Objects.equals(prizeList.get(i).type, Type.doll)){dollChance = Math.round(100*prizeList.get(i).chance*dollNumber/prizeList.size());}
            if (Objects.equals(prizeList.get(i).type, Type.bigCar)){carChance = Math.round(100*prizeList.get(i).chance*carNumber/prizeList.size());}
        }
        int [] array = new int[100];
        int winBear = 0;
        int winDoll= 0;
        int winCar = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
            if (digit == array[i] && array[i] % Math.round(100 / bearChance) == 0) {
                winBear++;
            }
            if (digit == array[i] && array[i] % Math.round(100 / dollChance) == 0) {
                winDoll++;
            }
            if (digit == array[i] && array[i] % Math.round(100 / carChance) == 0) {
                winCar++;
            }
        }
        if (winBear > 0){
            System.out.println("Congratulations! You win a brown bear.");
            for (int i = 0; i < prizeList.size(); i++) {
                if (Objects.equals(prizeList.get(i).type, Type.brownbear)){prizeList.remove(i);}
            }
        }
        if (winDoll > 0) {
            System.out.println("Congratulations! You win a doll.");
            for (int i = 0; i < prizeList.size(); i++) {
                if (Objects.equals(prizeList.get(i).type, Type.doll)){prizeList.remove(i);}
            }
        }
        if (winCar >0) {
            System.out.println("Congratulations! You win a big car.");
            for (int i = 0; i < prizeList.size(); i++) {
                if (Objects.equals(prizeList.get(i).type, Type.bigCar)){prizeList.remove(i);}
            }
        }else {System.out.println("Sorry... May be next time.");}
        winBear = 0;
        winDoll= 0;
        winCar = 0;
        }
    }

import java.io.*;
import java.util.*;

public class Meal {

    private String name;
    private String items;
    private String date;

    private Meal(String name, String items, String date){

        this.name = name;
        this.items = items;
        this.date = date;
    }

    public static void preparePlan(){
        Scanner sc = new Scanner(System.in);
        String filename = "meals.txt";

        System.out.print("Enter meal name: ");
        String name = sc.nextLine();
        System.out.print("Enter recipes: ");
        String ingredients = sc.nextLine();
        System.out.print("Enter date: ");
        String date = sc.nextLine();
        System.out.print("Press ENTER to confirm: ");
        String temp = sc.nextLine();

        String mealData = String.join(":", name, ingredients, date);
        IIKH.writeToFile(mealData, filename);
        IIKH.menu();
    }

    public static void browsePlanDB(){

        Meal[] mealArray = new Meal[10];
        int c = 0;

        try{
            FileReader fr = new FileReader("meals.txt");
            BufferedReader bufr = new BufferedReader(fr);
            String line = bufr.readLine();
            while(line != null){
                String[] items = line.split(":");
                System.out.println("rdfidjfiodhfidfoij");
                Meal newMeal = new Meal(items[0], items[1], items[2]);
                mealArray[c] = newMeal;
                c++;
                line = bufr.readLine();
            }
            bufr.close();
        }
        catch(IOException e){
            System.out.println("Error while reading file.");
        }

        System.out.println("Meal Database");
        System.out.println("=============");
        for(int i=0;i<c;i++){
            System.out.println("Name: "+mealArray[i].name + "\n" + "Recipe: " + mealArray[i].items + "\n" + "Date: " + mealArray[i].date);
            System.out.println("-----------");
        }
        IIKH.menu();
    }
    public static void editPlan(){

    }


}

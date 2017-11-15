import java.io.*;
import java.util.*;
public class Recipe {

    private String name;
    private String ingredients;
    private String method;
    private String time;

    private Recipe(String name, String ingredients, String method, String time){

        this.name = name;
        this.ingredients = ingredients;
        this.method = method;
        this.time = time;
    }

    public static void addRecipe(){

        Scanner sc = new Scanner(System.in);
        String filename = "recipes.txt";

        System.out.print("Enter name: ");
        String nR = sc.nextLine();
        System.out.print("Enter ingredients: ");
        String nI = sc.nextLine();
        System.out.print("Enter method of preparation: ");
        String nM = sc.nextLine();
        System.out.print("Enter approximate time of preparation: ");
        String nT = sc.nextLine();
        System.out.print("Press ENTER to confirm: ");
        String temp = sc.nextLine();

        String recipeData = String.join(":", nR, nI, nM, nT);
        IIKH.writeToFile(recipeData, "recipes.txt");
        IIKH.menu();
    }

    public static void editRecipe(){
    }

    public static void browseRecipeDB(){
        Recipe[] recipeArray = new Recipe[10];
        int c = 0;

        try{
            FileReader fr = new FileReader("recipes.txt");
            BufferedReader bufr = new BufferedReader(fr);
            String line = bufr.readLine();
            while(line != null){
                String[] items = line.split(":");
                Recipe newRecipe = new Recipe(items[0], items[1], items[2], items[3]);
                recipeArray[c] = newRecipe;
                c++;
                line = bufr.readLine();
            }
            bufr.close();
        }
        catch(IOException e){
            System.out.println("Error while reading file.");
        }
        System.out.println("Recipe Database");
        System.out.println("=============");
        for(int i=0;i<c;i++){
            System.out.println("Name: "+recipeArray[i].name + "\n" + "Recipe: " + recipeArray[i].ingredients + "\n" + "Date: " + recipeArray[i].method + "\n" + "Time: " + recipeArray[i].time);
            System.out.println("-----------");
        }
        IIKH.menu();
    }
}

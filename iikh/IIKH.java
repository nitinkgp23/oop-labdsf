import java.util.*;
import java.io.*;

public class IIKH{

    static void writeToFile(String data, String filename){

        try {
            File targetFile = new File(filename);
            // if file doesnt exists, then create it
            if (!targetFile.exists()) {
                targetFile.createNewFile();
            }

            FileWriter fw = new FileWriter(targetFile.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(data);
            bw.newLine();
            bw.close();
            System.out.println("Writing to file :" + filename + " is done.");
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }


    public static void main(String[] args){


        System.out.println("Welcome to IIKH");
        System.out.println("===============");
        menu();
    }
    public static void menu(){
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Add new Recipe.");
        System.out.println("2. Edit existing Recipe.");
        System.out.println("3. Browse the Recipe Database.");
        System.out.println("4. Prepare meal plan.");
        System.out.println("5. Edit the current meal plan.");
        System.out.println("6. Browse Meal Database.");

        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        if(choice == 0) {
            System.out.println("Enter a valid choice.");
        }
        else {
            makeChoice(choice);}
    }

    public static int isValidChoice(String input){
        int choice;
        try{
            choice = Integer.parseInt(input);
            if((choice > 0) && (choice <= 6))
                return choice;
            else
                return 0;
        }
        catch(NumberFormatException e){
            return 0;
    }
}

    public static void makeChoice(int choice){
        switch(choice){

            case 1:
                Recipe.addRecipe();
                break;

            case 2:
                Recipe.editRecipe();
                break;

            case 3:
                Recipe.browseRecipeDB();
                break;

            case 4:
                Meal.preparePlan();
                break;

            case 5:
                Meal.editPlan();
                break;

            case 6:
                Meal.browsePlanDB();
                break;

            default:
                System.out.println("No Choice");
        }
    }
}

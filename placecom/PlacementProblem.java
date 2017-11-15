
public class PlacementProblem{

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
            System.out.println("Error writing to file: " + filename);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}

public class Welcome {

    public void registerStudent(){
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Student Registration.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Student Registration");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void registerCompany() throws IOException{
    }

    private boolean studentApplication(){
        try{
                FileReader fr = new FileReader("students.txt");
            try (BufferedReader bufr = new BufferedReader(fr)) {
                String line = bufr.readLine();
                while(line != null){
                    String[] items = line.split(":");

                    Student can = new Student(items[0], items[1], Float.parseFloat(items[2]), Integer.parseInt(items[3]));
                    line = bufr.readLine();
                    can.applyToCompanies();
                }
            }
                return true;
            }
        catch(IOException e1){
            System.out.println("Error while reading file students.txt.");
        }
        return false;
    }

    private boolean studentAccept(){
        try{
                FileReader fr = new FileReader("students.txt");
            try (BufferedReader bufr = new BufferedReader(fr)) {
                String line = bufr.readLine();
                while(line != null){
                    String[] items = line.split(":");

                    Student can = new Student(items[0], items[1], Float.parseFloat(items[2]), Integer.parseInt(items[3]));
                    line = bufr.readLine();
                    can.acceptOffer();
                }
            }
                return true;
            }
        catch(IOException e){
            System.out.println("Error while reading file students.txt");
        }
        return false;
    }

    private boolean companyShortlist(){
        try{
                FileReader fr = new FileReader("companies.txt");
            try (BufferedReader bufr = new BufferedReader(fr)) {
                String line = bufr.readLine();
                while(line != null){
                    String[] items = line.split(":");

                    Company company = new Company(items[0], Float.parseFloat(items[1]), Integer.parseInt(items[2]), Integer.parseInt(items[3]));
                    line = bufr.readLine();
                    company.shortlist();
                }
            }
            return true;
        }
        catch(IOException e1){
            System.out.println("Error while reading file companies.txt.");
        }
        return false;
    }

    private boolean companyCount(){
        try{
            FileReader fr = new FileReader("companies.txt");
            try (BufferedReader bufr = new BufferedReader(fr)) {
                String line = bufr.readLine();
                while(line != null){
                    String[] items = line.split(":");

                    Company company = new Company(items[0], Float.parseFloat(items[1]), Integer.parseInt(items[2]), Integer.parseInt(items[3]));
                    line = bufr.readLine();
                    company.count();
                }
            }
                return true;
        }
        catch(IOException e1){
            System.out.println("Error while reading file companies.txt");
        }
        return false;
    }

    public void results() throws IOException{
        FileWriter targetfile = new FileWriter("studentsapplication.txt");
        targetfile.write("");
        targetfile.close();
        boolean flag = studentApplication();
        System.out.println("Students Applied");
        if(flag){
            targetfile = new FileWriter("shortlist.txt");
            targetfile.write("");
            targetfile.close();
            flag = companyShortlist();
            System.out.println("Shortlisted");
        }
        if(flag){
            targetfile = new FileWriter("placements.txt");
            targetfile.write("");
            targetfile.close();
            flag = studentAccept();
            System.out.println("Placed");
        }
        if (flag){
            targetfile = new FileWriter("company_stats.txt");
            targetfile.write("");
            targetfile.close();
            flag = companyCount();
            System.out.println("Counted");
        }
    }

    public void showResults(){
        String output = "";// = "Roll No.\t\tName\t\t\tCompany\n";
        try{
            FileReader fr = new FileReader("placements.txt");
            try (BufferedReader bufr = new BufferedReader(fr)) {
                String line = bufr.readLine();
                while(line != null){
                    String[] items = line.split(":");
                    output = output + "Roll No: " + items[0] + "\nName: " + items[1] + "\nCompany: " + items[2] + "\n\n";
                    line = bufr.readLine();
                }
            }
            fr.close();

            fr = new FileReader("company_stats.txt");
            output = "";
            try (BufferedReader bufr = new BufferedReader(fr)) {
                String line = bufr.readLine();
                while(line != null){
                    String[] items = line.split(":");
                    output = output + items[0] + "\nVacancies: " + items[1] + "\nSelected: " + items[2] + "\n\n";
                    line = bufr.readLine();
                }
            }
        }
        catch(IOException e1){
        System.out.println("Error while reading file placements.txt");
        }
    }

}

import java.io.*;
import java.util.*;

public class Student {
    public String name;
    float cgpa;
    int expected_salary;
    public String rollNo;

    public Student() {
    }

    public Student(String rollNo, String name, float cgpa, int expected_salary) {
        this.rollNo = rollNo;
        this.name = name;
        this.cgpa = cgpa;
        this.expected_salary = expected_salary;
    }

    private void register(){
        String filename = "students.txt";
        String data;
        data = String.join(":",rollNo , name, Float.toString(cgpa), Integer.toString(expected_salary));
        PlacementProblem.writeToFile(data, filename);
    }

    public void DoneRegistration(){
          Scanner sc = new Scanner(System.in);
          System.out.print("Enter Student's name: ");
          name = sc.nextLine();
          System.out.print("Enter Student's roll no: ");
          rollNo = sc.nextLine();
          System.out.print("Enter Student's CGPA: ");
          cgpa = sc.nextFloat();
          System.out.print("Enter Student's Expected Salary: ");
          expected_salary = sc.nextInt();

          if(cgpa>10 || cgpa<=0){
              Alert alert = new Alert(AlertType.ERROR);
              alert.setTitle("CGPA out of range");
              alert.setHeaderText(null);
              alert.setContentText("Enter CGPA in the range 0-10.");
              alert.showAndWait();
          }
      else {
          register();
      }
    }

    public void CancelRegistration(){
    }

    void apply(Company c){
        /*Write the student object on a new database, each line contains the list of students
        applying for a single company.
         */
        String filename = "studentsapplication.txt";
        String candidateData = c.name + ":" + rollNo + ":" + cgpa;
        PlacementProblem.writeToFile(candidateData, filename);
    }

    public void applyToCompanies(){

        try{
            FileReader fr = new FileReader("companies.txt");
            BufferedReader bufr = new BufferedReader(fr);
            String line = bufr.readLine();
            while(line != null){
                String[] items = line.split(":");

                Company com = new Company(items[0], Float.parseFloat(items[1]), Integer.parseInt(items[2]), Integer.parseInt(items[3]));
                if (com.salaryOffered > this.expected_salary){
                    System.out.println(com.name + com.salaryOffered + this.expected_salary);
                    apply(com);
                }
                line = bufr.readLine();
            }
            bufr.close();
        }
        catch(IOException e){
            System.out.println("Error while reading file companies.txt");
        }
    }

    public void acceptOffer(){
        try{
            ObservableList<Pair<String, Float>> data = FXCollections.observableArrayList();
            FileReader fr = new FileReader("shortlist.txt");
            try (BufferedReader bufr = new BufferedReader(fr)) {
                String line = bufr.readLine();
                while(line != null){
                    String[] items = line.split(":");
                    if(items[0].equals(rollNo)){
                        Pair company = new Pair(items[1], Float.parseFloat(items[2]));
                        data.add(company);
                    }
                    line = bufr.readLine();
                }
            }
            FXCollections.sort(data, (Pair<String, Float> p1, Pair<String, Float> p2) -> p1.getValue().compareTo(p2.getValue()));
            FXCollections.reverse(data);
            String print_data;
            if (data.size()>0){
                print_data = rollNo + ":" + name + ":" + data.get(0).getKey();
            }
            else{
                print_data = rollNo + ":" + name + ": None";
            }
            PlacementProblem.writeToFile(print_data, "placements.txt");
        }
        catch(IOException e){
            System.out.println("Error while reading file shortlist.txt");
        }
    }
}

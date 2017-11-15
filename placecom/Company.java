public class Pair{
    String name;
    float cgpa;
}

public class Company {
    public String name;
    public float cgReq;
    public int salaryOffered;
    int vacancy;

    public Company() {
    }

    public Company(String name, float cgReq, int salaryOffered, int vacancy) {
        this.name = name;
        this.cgReq = cgReq;
        this.salaryOffered = salaryOffered;
        this.vacancy = vacancy;
    }

    private void register(){
        String filename = "companies.txt";
        String data;
        data = String.join(":", name, Float.toString(cgReq), Integer.toString(salaryOffered), Integer.toString(vacancy));
        PlacementProblem.writeToFile(data, filename);
    }

    public void DoneRegistration(){

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Company's name: ");
        name = sc.nextLine();
        System.out.print("Enter Company's vacancy: ");
        vacancy = sc.nextInt();
        System.out.print("Enter Company's CGPA Required: ");
        cgReq = sc.nextFloat();
        System.out.print("Enter Student's Expected Salary: ");
        salaryOffered = sc.nextInt();

        if(cgReq>10 || cgReq<=0){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("CGPA out of range");
            alert.setHeaderText(null);
            alert.setContentText("Enter CGPA in the range 0-10");
            alert.showAndWait();
        }
        else {
            register();
        }
    }

    public void CancelRegistration(){
    }

    public void shortlist(){
        try{
            ObservableList<Pair<String, Float>> data = FXCollections.observableArrayList();
            FileReader fr = new FileReader("studentsapplication.txt");
            try (BufferedReader bufr = new BufferedReader(fr)) {
                String line = bufr.readLine();
                while(line != null){
                    String[] items = line.split(":");
                    //System.out.println(items[0] + ":" + name);
                    if(items[0].equals(name)){
                        System.out.println("|");
                        Pair student = new Pair(items[1], Float.parseFloat(items[2]));
                        data.add(student);
                    }
                    line = bufr.readLine();
                }
            }
            FXCollections.sort(data, (Pair<String, Float> p1, Pair<String, Float> p2) -> p1.getValue().compareTo(p2.getValue()));
            FXCollections.reverse(data);
            for(int i = 0; i<vacancy && i<data.size(); i++){
                System.out.println(data.get(i).getValue() + ":" + cgReq);
                if((float)data.get(i).getValue()>=cgReq){
                    String shortlist = data.get(i).getKey() + ":" + name + ":" + Integer.toString(salaryOffered);
                    PlacementProblem.writeToFile(shortlist, "shortlist.txt");
                    System.out.println(shortlist);
                }
            }
        }
        catch(IOException e){
            System.out.println("Error while reading file studentsapplication.txt");
        }
    }

    public void count(){
        int count = 0;
        try {
            FileReader fr = new FileReader("placements.txt");
            BufferedReader bufr = new BufferedReader(fr);
            String line = bufr.readLine();
            while(line != null){
                String[] items = line.split(":");
                if(items[2].equals(name)){
                    System.out.println("placement.problem.Company.count()");
                    count += 1;
                }
                line = bufr.readLine();
            }
            String print_data = name + ":" +Integer.toString(vacancy) + ":" + Integer.toString(count);
            PlacementProblem.writeToFile(print_data, "company_stats.txt");
        } catch (IOException e) {
        }
    }
}

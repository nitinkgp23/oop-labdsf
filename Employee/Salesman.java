public class Salesman {
    String name, employeeID;
    int sales;
    static final int commissionRate = 20;

    double salary;

    public Salesman(String name, String employeeID, int sales){
        this.name = name;
        this.employeeID = employeeID;
        this.sales = sales;
    }

    public double calculate_salary(){
        return (commissionRate*sales)/100;
    }

    public void set_salary(){
        this.salary = calculate_salary();
    }

    public void print_salary(){
        System.out.println("Salary:"+ this.salary);
    }
    public void print_details(){
        System.out.println("Name:"+ this.name);
        System.out.println("Employee type:"+ " Salesman");
        System.out.println("Sales:"+ this.sales);
        System.out.println("Salary:"+ this.salary + "\n");
    }
}

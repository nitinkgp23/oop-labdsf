public class Manager extends Salesman{

    int basePay;
    static final int commissionRate = 30;

    public Manager(String name, String employeeID, int sales, int basePay){
        super(name, employeeID, sales);

        this.basePay = basePay;
    }

    public double calculate_salary(){
        return basePay + (commissionRate*sales)/100;
    }

    public void print_details(){
        System.out.println("Name:"+ this.name);
        System.out.println("Employee type:"+ " Manager");
        System.out.println("Sales:"+ this.sales);
        System.out.println("Salary:"+ this.salary + "\n");
    }
}

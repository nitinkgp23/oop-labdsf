public class Employee {

    public static void main(String args[]) {

        Manager m1 = new Manager("Manager 1","123343434",1000,500);
        Salesman s1 = new Salesman("Salesman 1","4354545",1000);
        m1.set_salary();
        s1.set_salary();
        m1.print_details();
        s1.print_details();
    }
}

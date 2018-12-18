public class BusinessEmployee extends Employee {
    protected double budget;

    public BusinessEmployee(String name){
        super(name, 50000);
    }

    public String employeeStatus(){
        return this.toString() + " with a budget of " + this.budget;
    }

    // to do
    public double getBonusBudget(){
        return 0.0;
    }
}

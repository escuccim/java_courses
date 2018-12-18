public class TechnicalEmployee extends Employee {
    protected int checkIns;

    public TechnicalEmployee(String name){
        super(name, 75000);
        this.checkIns = 0;
    }

    public String employeeStatus(){
        return this.toString() + " has " + this.checkIns + " successful checkins.";
    }
}

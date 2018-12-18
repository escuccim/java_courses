public abstract class Employee {
    protected String name;
    protected double baseSalary;
    private int employee_id;
    private static int max_employee_id = 0;
    protected Employee manager;
    protected double bonus;

    public Employee(String name, double baseSalary){
        this.name = name;
        this.baseSalary = baseSalary;
        this.employee_id = this.max_employee_id + 1;
        this.max_employee_id++;
    }

    public double getBaseSalary(){
        return this.baseSalary;
    }

    public String getName(){
        return this.name;
    }

    public int getEmployeeID(){
        return this.employee_id;
    }

    public Employee getManager(){
        return this.manager;
    }

    public boolean equals(Employee other){
        return this.employee_id == other.employee_id;
    }

    public String toString(){
        return this.employee_id + " " + this.name;
    }

    public abstract String employeeStatus();
}

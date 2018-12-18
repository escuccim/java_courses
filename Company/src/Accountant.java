public class Accountant extends BusinessEmployee {
    public TechnicalLead technicalLead;

    public Accountant(String name){
        super(name);
        this.budget = 0;
    }

    public TechnicalLead getTeamSupported(){
        return this.technicalLead;
    }

    public void supportTeam(TechnicalLead lead){
        this.technicalLead = lead;
        this.budget += lead.baseSalary + (lead.baseSalary * 0.1);
    }

    public boolean approveBonus(double bonus){
        if(this.technicalLead == null){
            return false;
        } else if(bonus > this.budget){
            return true;
        } else {
            return false;
        }
    }

    public String employeeStatus(){
        return super.toString() + " is supporting " + this.technicalLead.toString();
    }
}

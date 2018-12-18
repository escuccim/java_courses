import java.util.*;

public class BusinessLead extends BusinessEmployee {
    private int headCount;
    protected ArrayList<Accountant> directReports;
    private int checkIns = 0;

    public BusinessLead(String name){
        super(name);
        this.baseSalary *= 2;
        this.headCount = 10;
    }

    public boolean hasHeadCount(){
        if(this.directReports == null){
            return false;
        } else {
            return this.directReports.size() < this.headCount;
        }
    }

    public boolean addReport(Accountant e, TechnicalLead supportTeam){
        if(this.hasHeadCount()){
            this.directReports.add(e);
            this.budget += (e.baseSalary * 1.1);
            e.technicalLead = supportTeam;
            return true;
        } else {
            return false;
        }
    }

    public boolean requestBonus(Employee e, double bonus){
        if(bonus < this.budget){
            this.budget -= bonus;
            e.bonus += bonus;
            return true;
        } else {
            return false;
        }
    }

    public boolean approveBonus(Employee e, double bonus){
        return true;
    }

    public String getTeamStatus(){
        String status = super.toString() + " has " + this.checkIns + " successful checkins ";

        if(this.directReports == null || this.directReports.size() == 0){
            status += " and no direct reports yet\n";
        } else {
            status += " and is managing:\n";
            for(int i = 0; i < this.directReports.size(); i++){
                status += this.directReports.get(i).toString() + "\n";
            }
        }

        return status;
    }
}

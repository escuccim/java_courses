import java.util.*;

public class TechnicalLead extends TechnicalEmployee {
    private int headCount;
    private int numDirectReports;
    private ArrayList<SoftwareEngineer> directReports;

    public TechnicalLead(String name){
        super(name);
        this.baseSalary *= 1.3;
        this.numDirectReports = 0;
    }

    public boolean hasHeadCount(){
        return this.numDirectReports < this.headCount;
    }

    public boolean addReport(SoftwareEngineer e){
        if(this.hasHeadCount()){
            this.directReports.add(e);
            this.numDirectReports++;

            // add this person as employee's manager
            e.manager = this;
            return true;
        } else {
            return false;
        }
    }

    public boolean approveCheckIn(SoftwareEngineer e){
        // check if employee reports to this lead and has code access
        if(e.getCodeAccess() && this.directReports.contains(e)){
            return true;
        } else {
            return false;
        }
    }

    // to do
    public boolean requestBonus(Employee e, double bonus){
        return true;
    }

    // to do
    public String getTeamStatus(){
        String status = super.toString() + " has " + this.checkIns + " successful checkins ";

        if(this.directReports == null || this.directReports.size() == 0){
            status += " and no direct reports yet\n";
        } else {
            status += " and is managing:\n";
            for(int i = 0; i < this.directReports.size(); i++){
                status += this.directReports.get(i).toString() + " has " + this.directReports.get(i).checkIns + "\n";
            }
        }

        return status;
    }
}

public class SoftwareEngineer extends TechnicalEmployee {
    private boolean hasCodeAccess = false;
    public TechnicalLead manager;

    public SoftwareEngineer(String name){
        super(name);
    }

    public boolean getCodeAccess(){
        return this.hasCodeAccess;
    }

    public void setCodeAccess(boolean access){
        this.hasCodeAccess = access;
    }

    public int getSuccessfulCheckIns(){
        return this.checkIns;
    }

    public boolean checkInCode(){
        if(this.manager.approveCheckIn(this)) {
            this.checkIns++;
            return true;
        } else {
            return false;
        }
    }
}

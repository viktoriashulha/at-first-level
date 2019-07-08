package model;

public class Calculator {
    private String VMClass;
    private String instanceType;
    private String region;
    private String localSSD;
    private String commitmentTerm;
    private String email;
    private String cost;


    @Override
    public String toString() {
        return "Calculator{" +
                "VMClass='" + VMClass + '\'' +
                ", instanceType='" + instanceType + '\'' +
                ", region='" + region + '\'' +
                ", localSSD='" + localSSD + '\'' +
                ", commitmentTerm='" + commitmentTerm + '\'' +
                ", email'" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Calculator that = (Calculator) o;

        if (VMClass != null ? !VMClass.equals(that.VMClass) : that.VMClass != null) return false;
        if (instanceType != null ? !instanceType.equals(that.instanceType) : that.instanceType != null) return false;
        if (region != null ? !region.equals(that.region) : that.region != null) return false;
        if (localSSD != null ? !localSSD.equals(that.localSSD) : that.localSSD != null) return false;
        if (commitmentTerm != null ? !commitmentTerm.equals(that.commitmentTerm) : that.commitmentTerm != null)
            return false;
        return email != null ? email.equals(that.email) : that.email == null;
    }

    @Override
    public int hashCode() {
        int result = VMClass != null ? VMClass.hashCode() : 0;
        result = 31 * result + (instanceType != null ? instanceType.hashCode() : 0);
        result = 31 * result + (region != null ? region.hashCode() : 0);
        result = 31 * result + (localSSD != null ? localSSD.hashCode() : 0);
        result = 31 * result + (commitmentTerm != null ? commitmentTerm.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    public String getVMClass() {
        return VMClass;
    }

    public void setVMClass(String VMClass) {
        this.VMClass = VMClass;
    }

    public String getInstanceType() {
        return instanceType;
    }

    public void setInstanceType(String instanceType) {
        this.instanceType = instanceType;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getLocalSSD() {
        return localSSD;
    }

    public void setLocalSSD(String localSSD) {
        this.localSSD = localSSD;
    }

    public String getCommitmentTerm() {
        return commitmentTerm;
    }

    public void setCommitmentTerm(String commitmentTerm) {
        this.commitmentTerm = commitmentTerm;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }


}

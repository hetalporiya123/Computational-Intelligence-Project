package neuralnetwork;

public class DatasetRecord {

    private double age;
    private double monthlyCharges;
    private double yearsCustomer;
    private double complaints;
    private int churn;

    public DatasetRecord(
            double age,
            double monthlyCharges,
            double yearsCustomer,
            double complaints,
            int churn) {

        this.age = age;
        this.monthlyCharges = monthlyCharges;
        this.yearsCustomer = yearsCustomer;
        this.complaints = complaints;
        this.churn = churn;
    }

    public double getAge() {
        return age;
    }

    public double getMonthlyCharges() {
        return monthlyCharges;
    }

    public double getYearsCustomer() {
        return yearsCustomer;
    }

    public double getComplaints() {
        return complaints;
    }

    public int getChurn() {
        return churn;
    }
}
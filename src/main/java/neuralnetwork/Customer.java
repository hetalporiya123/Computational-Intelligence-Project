package neuralnetwork;

public class Customer {

    private double age;
    private double monthlyCharges;
    private double yearsCustomer;
    private double complaints;

    public Customer(
            double age,
            double monthlyCharges,
            double yearsCustomer,
            double complaints) {

        this.age = age;
        this.monthlyCharges = monthlyCharges;
        this.yearsCustomer = yearsCustomer;
        this.complaints = complaints;
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
}
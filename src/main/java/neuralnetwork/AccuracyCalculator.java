package neuralnetwork;

import java.util.List;

public class AccuracyCalculator {

    public static double calculateAccuracy(
            NeuralNetwork network,
            List<DatasetRecord> records) {

        int correct = 0;

        for (DatasetRecord record : records) {

            Customer customer =
                    new Customer(
                            record.getAge(),
                            record.getMonthlyCharges(),
                            record.getYearsCustomer(),
                            record.getComplaints()
                    );

            double prediction =
                    network.predict(customer);

            int predictedClass;

            if (prediction > 0.5)
                predictedClass = 1;
            else
                predictedClass = 0;

            if (predictedClass ==
                    record.getChurn()) {

                correct++;
            }
        }

        return (correct * 100.0)
                / records.size();
    }
}
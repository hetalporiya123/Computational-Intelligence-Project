package neuralnetwork;

import java.util.List;
import java.util.Random;

public class NeuralNetwork {

    private double[] weights;

    private double bias;

    private double learningRate = 0.01;

    private int datasetSize;
    private double accuracy;


    public NeuralNetwork() {

        weights = new double[4];

        Random random = new Random();

        for(int i = 0; i < weights.length; i++) {

            weights[i] =
                    random.nextDouble() - 0.5;
        }

        bias =
                random.nextDouble() - 0.5;
    }

    private double sigmoid(double x) {

        return 1.0 /
                (1.0 + Math.exp(-x));
    }

    public double predict(Customer customer) {

        double sum = bias;

        sum += normalize(
                customer.getAge(),
                100)
                * weights[0];

        sum += normalize(
                customer.getMonthlyCharges(),
                100)
                * weights[1];

        sum += normalize(
                customer.getYearsCustomer(),
                30)
                * weights[2];

        sum += normalize(
                customer.getComplaints(),
                10)
                * weights[3];

        return sigmoid(sum);
    }

    public void train(
            List<DatasetRecord> data,
            int epochs) {

        System.out.println(
                "Training Neural Network...");

        for(int epoch = 0;
            epoch < epochs;
            epoch++) {

            double totalError = 0;


            for(DatasetRecord record : data) {

                Customer customer =
                        new Customer(
                                record.getAge(),
                                record.getMonthlyCharges(),
                                record.getYearsCustomer(),
                                record.getComplaints()
                        );

                double prediction =
                        predict(customer);

                double error =
                        record.getChurn()
                                - prediction;

                totalError += Math.abs(error);

                weights[0] += learningRate *
                        error *
                        normalize(
                                record.getAge(),
                                100);

                weights[1] += learningRate *
                        error *
                        normalize(
                                record.getMonthlyCharges(),
                                100);

                weights[2] += learningRate *
                        error *
                        normalize(
                                record.getYearsCustomer(),
                                30);

                weights[3] += learningRate *
                        error *
                        normalize(
                                record.getComplaints(),
                                10);

                bias +=
                        learningRate *
                                error;
            }

            if(epoch % 1000 == 0) {

                System.out.printf(
                        "Epoch %d | Error = %.4f%n",
                        epoch,
                        totalError);
            }

        }

        System.out.println(
                "\nTraining Complete!");
    }

    public void printWeights() {

        System.out.println(
                "\nLearned Weights:");

        System.out.println(
                "Age = "
                        + weights[0]);

        System.out.println(
                "Monthly Charges = "
                        + weights[1]);

        System.out.println(
                "Years Customer = "
                        + weights[2]);

        System.out.println(
                "Complaints = "
                        + weights[3]);

        System.out.println(
                "Bias = "
                        + bias);

        System.out.println(
                "Learning Rate = "
                        + learningRate);

        System.out.println(
                "Activation Function = Sigmoid");
    }

    public double[] getWeights() {

        return weights;
    }

    public double getLearningRate() {

        return learningRate;
    }

    private double normalize(
            double value,
            double max) {

        return value / max;
    }
}
package neuralnetwork;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<DatasetRecord> data =
                DataLoader.loadData();

        System.out.println(
                "Records Loaded: "
                        + data.size());

        NeuralNetwork network =
                new NeuralNetwork();


        network.train(
                data,
                5000
        );

        network.printWeights();

        double accuracy =
                AccuracyCalculator
                        .calculateAccuracy(
                                network,
                                data);

        System.out.printf(
                "\nAccuracy: %.2f%%%n",
                accuracy);

        new ChurnPredictorGUI(network,data.size(),accuracy);
    }
}
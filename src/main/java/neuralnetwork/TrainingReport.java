package neuralnetwork;

import java.util.List;

public class TrainingReport {

    public static String generateReport() {

        List<DatasetRecord> data =
                DataLoader.loadData();

        int churnCount = 0;

        for (DatasetRecord record : data) {

            if (record.getChurn() == 1) {
                churnCount++;
            }
        }

        int stayCount =
                data.size() - churnCount;

        return String.format(
                """
                Dataset Records : %d
                
                Churn Customers : %d
                
                Stay Customers  : %d
                
                Input Neurons   : 4
                
                Hidden Neurons  : 3
                
                Output Neurons  : 1
                
                Activation      : Sigmoid
                """,
                data.size(),
                churnCount,
                stayCount
        );
    }
}
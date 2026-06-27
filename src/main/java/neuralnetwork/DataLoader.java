package neuralnetwork;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DataLoader {

    public static List<DatasetRecord> loadData() {

        List<DatasetRecord> records =
                new ArrayList<>();

        try {

            InputStream is =
                    DataLoader.class
                            .getClassLoader()
                            .getResourceAsStream(
                                    "customer_churn.csv");

            BufferedReader br =
                    new BufferedReader(
                            new InputStreamReader(is));

            br.readLine(); // skip header

            String line;

            while ((line = br.readLine()) != null) {

                String[] values =
                        line.split(",");

                records.add(
                        new DatasetRecord(
                                Double.parseDouble(values[0]),
                                Double.parseDouble(values[1]),
                                Double.parseDouble(values[2]),
                                Double.parseDouble(values[3]),
                                Integer.parseInt(values[4])
                        )
                );
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return records;
    }
}
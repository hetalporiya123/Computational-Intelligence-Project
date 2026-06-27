package neuralnetwork;

import javax.swing.*;
import java.awt.*;

public class ChurnPredictorGUI extends JFrame {

    private JTextField ageField;
    private JTextField chargesField;
    private JTextField yearsField;
    private JTextField complaintsField;
    private JLabel accuracyLabel;

    private JLabel resultLabel;
    private double accuracy;

    private NeuralNetwork network;
    private int datasetSize;

    public ChurnPredictorGUI(NeuralNetwork network, int datasetSize, double accuracy) {

        //Uses the trained model
        this.network = network;
        this.datasetSize = datasetSize;
        this.accuracy = accuracy;
        setTitle("Customer Churn Prediction");

        setSize(550,400);

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JLabel title =
                new JLabel(
                        "Customer Churn Prediction",
                        SwingConstants.CENTER);

        title.setFont(
                new Font("Arial",
                        Font.BOLD,
                        20));

        add(title, BorderLayout.NORTH);

        JPanel formPanel =
                new JPanel();

        formPanel.setLayout(
                new GridLayout(6,2,10,10));

        formPanel.add(new JLabel("Age"));
        ageField = new JTextField();
        formPanel.add(ageField);

        formPanel.add(new JLabel("Monthly Charges"));
        chargesField = new JTextField();
        formPanel.add(chargesField);

        formPanel.add(new JLabel("Years Customer"));
        yearsField = new JTextField();
        formPanel.add(yearsField);

        formPanel.add(new JLabel("Complaints"));
        complaintsField = new JTextField();
        formPanel.add(complaintsField);

        JButton predictButton =
                new JButton("Predict");

        formPanel.add(new JLabel(""));
        formPanel.add(predictButton);



        resultLabel =
                new JLabel(
                        "<html>Result</html>",
                        SwingConstants.CENTER);

        resultLabel.setVerticalAlignment(
                SwingConstants.TOP);

        resultLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        16));

        formPanel.add(resultLabel);
        formPanel.add(new JLabel(""));
        add(formPanel, BorderLayout.CENTER);

        predictButton.addActionListener(e -> {

            try {

                double age =
                        Double.parseDouble(
                                ageField.getText());

                double charges =
                        Double.parseDouble(
                                chargesField.getText());

                double years =
                        Double.parseDouble(
                                yearsField.getText());

                double complaints =
                        Double.parseDouble(
                                complaintsField.getText());

                Customer customer =
                        new Customer(
                                age,
                                charges,
                                years,
                                complaints);

                double prediction =
                        network.predict(customer);

                double percentage =
                        prediction * 100;

                double confidenceValue;

                if(prediction > 0.5)
                    confidenceValue = percentage;
                else
                    confidenceValue = 100 - percentage;

                String confidence;

                if(confidenceValue > 80)
                    confidence = "HIGH";
                else if(confidenceValue > 60)
                    confidence = "MEDIUM";
                else
                    confidence = "LOW";

                if(prediction > 0.5) {

                    resultLabel.setForeground(
                            Color.RED);

                    resultLabel.setText(
                            String.format(
                                    "<html>" +
                                            "Prediction: LEAVE<br>" +
                                            "Probability: %.2f%%<br>" +
                                            "Confidence: %s" +
                                            "</html>",
                                    percentage,
                                    confidence));

                } else {

                    resultLabel.setForeground(
                            new Color(0,128,0));

                    resultLabel.setText(
                            String.format(
                                    "<html>" +
                                            "Prediction: STAY<br>" +
                                            "Probability: %.2f%%<br>" +
                                            "Confidence: %s" +
                                            "</html>",
                                    100 - percentage,
                                    confidence));
                }

            } catch(Exception ex) {

                JOptionPane.showMessageDialog(
                        this,
                        "Enter valid values");
            }
        });

        setVisible(true);

    }
}
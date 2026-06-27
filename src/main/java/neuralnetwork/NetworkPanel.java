package neuralnetwork;

import javax.swing.*;
import java.awt.*;

public class NetworkPanel extends JPanel {

    private int datasetSize;
    private double accuracy;

    private double learningRate;
    private double[] weights;
    public NetworkPanel(int datasetSize, double accuracy, double learningRate, double[] weights) {

        this.datasetSize = datasetSize;
        this.accuracy = accuracy;
        this.learningRate = learningRate;
        this.weights = weights;
    }
    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        g.setFont(new Font("Arial", Font.BOLD, 16));



        g.drawString("INPUT LAYER", 40, 40);

        g.drawString("HIDDEN LAYER", 180, 40);

        g.drawString("OUTPUT LAYER", 340, 40);

        // Input layer
        g.fillOval(50,50,30,30);
        g.fillOval(50,120,30,30);
        g.fillOval(50,190,30,30);
        g.fillOval(50,260,30,30);

        g.drawString(
                String.format(
                        "Age (%.2f)",
                        weights[0]),
                0,
                115);

        g.drawString(
                String.format(
                        "Charges (%.2f)",
                        weights[1]),
                0,
                185);

        g.drawString(
                String.format(
                        "Years (%.2f)",
                        weights[2]),
                0,
                255);

        g.drawString(
                String.format(
                        "Complaints (%.2f)",
                        weights[3]),
                0,
                325);

        // Hidden layer
        g.fillOval(200,80,30,30);
        g.fillOval(200,160,30,30);
        g.fillOval(200,240,30,30);

        g.drawString("H1", 240, 100);
        g.drawString("H2", 240, 180);
        g.drawString("H3", 240, 260);

        // Output
        g.fillOval(350,150,40,40);

        g.drawString(
                "Output",
                400,
                175);

        g.drawString(
                "Churn",
                400,
                195);

        // Connections
        for(int y1=65; y1<=275; y1+=70){

            g.drawLine(80,y1,200,95);
            g.drawLine(80,y1,200,175);
            g.drawLine(80,y1,200,255);
        }

        g.drawLine(230,95,350,170);
        g.drawLine(230,175,350,170);
        g.drawLine(230,255,350,170);

        g.setFont(new Font("Arial", Font.PLAIN, 14));

        g.drawString(
                "Architecture: 4-3-1",
                20,
                330);

        g.drawString(
                "Dataset Records: " + datasetSize,
                180,
                330);

        g.drawString(
                "Activation: Sigmoid",
                20,
                360);

        g.drawString(
                "Learning Rate: "
                        + learningRate,
                180,
                360);

        g.drawString(
                String.format(
                        "Accuracy: %.2f%%",
                        accuracy),
                350,
                360);
    }
}
package swarm;

import javax.swing.*;
import java.awt.*;

public class SimulationPanel extends JPanel {

    private SwarmController controller;

    public SimulationPanel(SwarmController controller) {
        this.controller = controller;

        setPreferredSize(new Dimension(1000, 1000));
        setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        g.setColor(Color.LIGHT_GRAY);

        int width = getWidth();
        int height = getHeight();

        double scaleX = width / 1000.0;
        double scaleY = height / 1000.0;

        g.setColor(Color.GRAY);
        g.drawLine(width / 2, 0, width / 2, height);
        g.drawLine(0, height / 2, width, height / 2);

        g.drawString("Sector 1", width / 4, height / 4);

        g.drawString("Sector 2",
                (3 * width) / 4,
                height / 4);

        g.drawString("Sector 3",
                width / 4,
                (3 * height) / 4);

        g.drawString("Sector 4",
                (3 * width) / 4,
                (3 * height) / 4);
        // Draw Lost Person
        LostPerson person = controller.getLostPerson();

        // Draw Drones
        g.setColor(Color.BLUE);

        for (Drone drone : controller.getDrones()) {

            if (drone.isFoundTarget())
                g.setColor(Color.GREEN);
            else
                g.setColor(Color.BLUE);
            int droneX = (int)(drone.getX() * scaleX);
            int droneY = (int)(drone.getY() * scaleY);

            g.fillOval(
                    droneX - 5,
                    droneY - 5,
                    10,
                    10
            );

            g.drawString(
                    String.valueOf(drone.getId()),
                    droneX + 8,
                    droneY
            );
        }



        int personX = (int)(person.getX() * scaleX);
        int personY = (int)(person.getY() * scaleY);

        g.setColor(Color.RED);

        g.fillOval(
                personX - 12,
                personY - 12,
                24,
                24
        );

        g.setColor(Color.BLACK);

        g.drawString(
                "LOST PERSON",
                personX + 15,
                personY
        );


        g.setColor(Color.BLACK);

        g.setFont(new Font("Arial", Font.BOLD, 22));

        String title =
                "Drone Swarm Search and Rescue Simulation";

        FontMetrics fm = g.getFontMetrics();

        int titleWidth =
                fm.stringWidth(title);

        g.drawString(
                title,
                (getWidth() - titleWidth) / 2,
                30
        );

        g.setFont(new Font("Arial", Font.PLAIN, 14));

        g.drawString(
                "Iteration: " + controller.getIteration(),
                20,
                70
        );

        String status =
                controller.isTargetFound()
                        ? "TARGET FOUND"
                        : "SEARCHING";

        g.drawString(
                "Status: " + status,
                20,
                90
        );

        if (controller.isTargetFound()) {

            g.setColor(Color.GREEN);

            g.setFont(new Font("Arial", Font.BOLD, 16));

            g.drawString(
                    controller.getFinderMessage(),
                    20,
                    130
            );
        }

        int legendY = getHeight() - 30;

        g.setColor(Color.BLUE);
        g.fillOval(20, legendY, 10, 10);

        g.setColor(Color.BLACK);
        g.drawString("Drone", 40, legendY + 10);

        g.setColor(Color.RED);
        g.fillOval(120, legendY, 10, 10);

        g.setColor(Color.BLACK);
        g.drawString("Lost Person", 140, legendY + 10);

        g.setColor(Color.BLACK);

        g.drawString(
                String.format(
                        "Target Location: (%.0f, %.0f)",
                        controller.getTargetX(),
                        controller.getTargetY()
                ),
                20,
                110
        );
    }


}
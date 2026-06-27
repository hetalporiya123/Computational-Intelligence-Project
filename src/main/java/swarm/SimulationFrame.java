package swarm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimulationFrame extends JFrame {

    public SimulationFrame(SwarmController controller) {

        setTitle("Drone Swarm Search and Rescue");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SimulationPanel panel =
                new SimulationPanel(controller);

        add(panel);

        pack();

        setLocationRelativeTo(null);

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);

        Timer timer = new Timer(
                30,
                new ActionListener() {


                    @Override
                    public void actionPerformed(
                            ActionEvent e) {

                        if (!controller.isTargetFound()) {

                            controller.performSearchStep();

                        } else {

                            controller.performConvergenceStep();
                        }

                        panel.repaint();
                    }
                }


        );

        timer.start();
    }
}
package swarm;

public class Main {

    public static void main(String[] args) {

        SwarmController controller =
                new SwarmController();

        //controller.startMission();

        new SimulationFrame(controller);
    }
}
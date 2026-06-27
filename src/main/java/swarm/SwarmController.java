package swarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SwarmController {

    private List<Drone> drones;
    private String finderMessage = "";
    private LostPerson lostPerson;

    private boolean missionComplete = false;

    private static final int MIN_SEARCH_ITERATIONS = 75;
    private boolean targetFound = false;

    private int iteration = 0;

    public SwarmController() {

        drones = new ArrayList<>();

        Random random = new Random();

        for (int i = 1; i <= 20; i++) {

            double x = random.nextInt(1000);
            double y = random.nextInt(1000);

            drones.add(new Drone(i, x, y));
        }

        for (int i = 0; i < drones.size(); i++) {

            Drone d = drones.get(i);

            if (i < 5)
                d.setSector(0, 500, 0, 500);

            else if (i < 10)
                d.setSector(500, 1000, 0, 500);

            else if (i < 15)
                d.setSector(0, 500, 500, 1000);

            else
                d.setSector(500, 1000, 500, 1000);
        }

        double personX = random.nextInt(1000);
        double personY = random.nextInt(1000);

        lostPerson = new LostPerson(personX, personY);

        System.out.println("\n========== MISSION STARTED ==========");
        System.out.printf("Lost Person Location (Hidden): (%.0f, %.0f)%n",
                personX, personY);
        System.out.println("=====================================\n");
    }


    public void performSearchStep() {

        iteration++;

        if (targetFound) {
            return;


        }

        for (Drone drone : drones) {

            drone.searchSector();

            double distance =
                    drone.distanceTo(
                            lostPerson.getX(),
                            lostPerson.getY()
                    );

            if (distance < 40 &&
                    iteration >= MIN_SEARCH_ITERATIONS) {

                targetFound = true;

                drone.setFoundTarget(true);
                finderMessage =
                        "Drone " +
                                drone.getId() +
                                " found the lost person!";
                System.out.println("\nTARGET FOUND!");

                System.out.println(
                        "Drone " +
                                drone.getId() +
                                " found the lost person!"
                );

                System.out.println(
                        "Target found after " +
                                iteration +
                                " iterations."
                );

                System.out.printf(
                        "Target Location: (%.0f, %.0f)%n",
                        lostPerson.getX(),
                        lostPerson.getY()
                );

                break;
            }
        }


    }

    public void performConvergenceStep() {

        boolean allReached = true;

        for (Drone drone : drones) {

            double distance =
                    drone.distanceTo(
                            lostPerson.getX(),
                            lostPerson.getY()
                    );

            if (distance > 5) {

                drone.moveTowards(
                        lostPerson.getX(),
                        lostPerson.getY()
                );

                allReached = false;
            }
        }

        if (allReached) {

            missionComplete = true;
        }
    }

    public boolean isTargetFound() {
        return targetFound;
    }

    public List<Drone> getDrones() {
        return drones;
    }

    public LostPerson getLostPerson() {
        return lostPerson;
    }

    public int getIteration() {
        return iteration;
    }
    public double getTargetX() {
        return lostPerson.getX();
    }

    public double getTargetY() {
        return lostPerson.getY();
    }

    public String getFinderMessage() {
        return finderMessage;
    }

}
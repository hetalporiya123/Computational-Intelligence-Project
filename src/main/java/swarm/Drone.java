package swarm;

public class Drone {

    private final int id;

    private double x;
    private double y;

    private double speed;

    private boolean foundTarget;

    private double minX;
    private double maxX;
    private double minY;
    private double maxY;

    private double targetX;
    private double targetY;

    public Drone(int id, double x, double y) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.speed = 10;
        this.foundTarget = false;
    }

    public void generatePatrolPoint() {

        targetX = minX + Math.random() * (maxX - minX);
        targetY = minY + Math.random() * (maxY - minY);
    }

    public void searchSector() {


        double dx = targetX - x;
        double dy = targetY - y;

        double distance = Math.sqrt(dx * dx + dy * dy);

        if(distance < 20) {
            generatePatrolPoint();

            dx = targetX - x;
            dy = targetY - y;

            distance = Math.sqrt(dx * dx + dy * dy);
        }

        if(distance > 0) {
            x += 5 * dx / distance;
            y += 5 * dy / distance;
        }
    }

    public void moveTowards(double targetX, double targetY) {

        double dx = targetX - x;
        double dy = targetY - y;

        double distance = Math.sqrt(dx * dx + dy * dy);

        if (distance > 0) {

            x += speed * dx / distance;
            y += speed * dy / distance;
        }
    }

    public double distanceTo(double targetX, double targetY) {

        double dx = targetX - x;
        double dy = targetY - y;

        return Math.sqrt(dx * dx + dy * dy);
    }

    public int getId() {
        return id;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public boolean isFoundTarget() {
        return foundTarget;
    }

    public void setFoundTarget(boolean foundTarget) {
        this.foundTarget = foundTarget;
    }

    public void setSector(
            double minX,
            double maxX,
            double minY,
            double maxY) {

        this.minX = minX;
        this.maxX = maxX;
        this.minY = minY;
        this.maxY = maxY;
        generatePatrolPoint();

    }


}
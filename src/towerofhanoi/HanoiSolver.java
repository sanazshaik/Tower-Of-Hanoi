/**
 * 
 */
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Sanaz Shaik(906399883)
package towerofhanoi;

import java.util.Observable;

/**
 * @author sanazshaik
 * @version 2022.10.18
 */
public class HanoiSolver extends Observable {
    // ~ Fields ................................................................
    private Tower left;
    private Tower middle;
    private Tower right;
    private int numDisks;

    // Constructor ..........................................................
    /**
     * @param numDisks
     *            the number of disks
     * 
     *            initializes numDisks and each of the positions
     */
    public HanoiSolver(int numDisks) {
        this.numDisks = numDisks;
        left = new Tower(Position.LEFT);
        middle = new Tower(Position.MIDDLE);
        right = new Tower(Position.RIGHT);

    }

    // ~ Methods .......................................................


    // ----------------------------------------------------------
    /**
     * @return an integer
     *         the number of disks
     */
    public int disks() {
        return numDisks;
    }


    // ----------------------------------------------------------
    /**
     * @param pos
     *            the position used
     * @return position
     *         uses switch statements to return the specified position
     *         per case
     */
    public Tower getTower(Position pos) {
        switch (pos) {
            case LEFT:
                return left;
            case MIDDLE:
                return middle;
            case RIGHT:
                return right;
            default:
                return middle;

        }
    }


    // ----------------------------------------------------------
    /**
     * @return string representation
     *         string of the disks
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(left.toString());
        builder.append(middle.toString());
        builder.append(right.toString());
        return builder.toString();

    }


    // ----------------------------------------------------------
    /**
     * @param source
     *            removes the disk here
     * @param destination
     *            pushes the disk here
     *            removes the disk from the source tower
     *            onto the destination tower so the disk "moves"
     */
    private void move(Tower source, Tower destination) {
        Disk d = source.pop();
        destination.push(d);
        setChanged();
        notifyObservers(destination.position());
    }


    // ----------------------------------------------------------
    /**
     * @param currentDisks
     *            the number of disks present in hanoiSolver
     * @param startPole
     *            the left pole
     * @param tempPole
     *            the middle pole
     * @param endPole
     *            the right pole
     *            solveTowers method uses local method move to locate how
     *            the disks will move given the number of disks present
     */
    private void solveTowers(
        int currentDisks,
        Tower startPole,
        Tower tempPole,
        Tower endPole) {
        if (currentDisks == 1) {
            move(startPole, endPole);
        }
        else {
            solveTowers(currentDisks - 1, startPole, endPole, tempPole);
            solveTowers(1, startPole, tempPole, endPole);
            solveTowers(currentDisks - 1, tempPole, startPole, endPole);
        }
    }


    // ----------------------------------------------------------
    /**
     * the public method calls the solveTowers method
     */
    public void solve() {
        this.solveTowers(numDisks, left, middle, right);
    }
}

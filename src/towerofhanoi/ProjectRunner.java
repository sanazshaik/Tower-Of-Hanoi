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

/**
 * @author sanazshaik
 * @version 2022.10.19
 */
public class ProjectRunner {

    // Method ..........................................................

    // ----------------------------------------------------------
    /**
     * Builds a window
     */
    public static void main(String[] args) {
        int disks = 6;
        if (args.length == 1) {
            disks = Integer.parseInt(args[0]);
        }
        HanoiSolver solver = new HanoiSolver(disks);
        PuzzleWindow window = new PuzzleWindow(solver);
    }
}

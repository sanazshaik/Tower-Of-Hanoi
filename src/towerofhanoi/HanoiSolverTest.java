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

import student.TestCase;

/**
 * @author sanazshaik
 * @version 2022.10.19
 */
public class HanoiSolverTest extends TestCase {
    // ~ Fields ................................................................
    private HanoiSolver two;
    private Disk disk1;
    private Disk disk2;
    private Disk disk3;

    // ----------------------------------------------------------
    /**
     * set up method
     */
    public void setUp() {
        two = new HanoiSolver(3);
        disk1 = new Disk(30);
        disk2 = new Disk(20);
        disk3 = new Disk(10);
    }


    // ----------------------------------------------------------
    /**
     * tests to check how many disks are in hanoiSolver
     */
    public void testDisks() {
        assertEquals(3, two.disks());
    }


    // ----------------------------------------------------------
    /**
     * tests to check correct position value assigned
     * to hanoiSolver
     */
    public void testGetTower() {
        assertEquals(Position.LEFT, two.getTower(Position.LEFT).position());
        assertEquals(Position.MIDDLE, two.getTower(Position.MIDDLE).position());
        assertEquals(Position.RIGHT, two.getTower(Position.RIGHT).position());
        assertEquals(Position.MIDDLE, two.getTower(Position.DEFAULT)
            .position());
    }


    // ----------------------------------------------------------
    /**
     * tests the correct string representation of the
     * disks pushed onto the towers and hanoiSolver
     */
    public void testToString() {
        two.getTower(Position.RIGHT).push(disk1);
        two.getTower(Position.MIDDLE).push(disk2);
        two.getTower(Position.LEFT).push(disk3);
        assertEquals("[10][20][30]", two.toString());
    }


    // ----------------------------------------------------------
    /**
     * tests the solve method by pushing a disk onto the tower
     * and to hanoiSolver and checking the position
     * size accordingly
     */
    public void testSolve() {
        two.getTower(Position.LEFT).push(disk1);
        two.getTower(Position.LEFT).push(disk2);
        two.getTower(Position.LEFT).push(disk3);
        two.solve();
        assertEquals(3, two.getTower(Position.RIGHT).size());
    }
}

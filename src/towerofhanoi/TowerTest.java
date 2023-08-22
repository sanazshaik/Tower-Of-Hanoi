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
 * @version 2022.10.18
 */
public class TowerTest extends TestCase {
    // ~ Fields ................................................................
    private Tower one;
    private Disk two;
    private Disk three;
    private Tower five;

    // ----------------------------------------------------------
    /**
     * set up method
     */
    public void setUp() {
        one = new Tower(Position.LEFT);
        five = new Tower(Position.LEFT);
        two = new Disk(5);
        three = new Disk(10);
    }


    // ----------------------------------------------------------
    /**
     * tests the position of the tower returned
     */
    public void testPosition() {
        assertEquals(Position.LEFT, one.position());
    }


    // ----------------------------------------------------------
    /**
     * tests the validity of whether to push the disk
     */
    public void testPush() {
        Exception thrown = null;
        try {
            one.push(two);
            one.push(three);
        }
        catch (Exception exception) {
            thrown = exception;
        }

        // checks whether an Exception was actually thrown
        assertNotNull(thrown);

        // checks whether the right type of Exception was thrown
        assertTrue(thrown instanceof IllegalStateException);

        Exception exception = null;
        try {
            one.push(null);
            fail("push() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("push() is throwing the wrong type of exceptions",
            exception instanceof IllegalArgumentException);

        assertTrue(five.isEmpty());
        five.push(three);
        assertEquals(five.peek(), three);
        five.push(two);
        assertEquals(five.peek(), two);
    }
}

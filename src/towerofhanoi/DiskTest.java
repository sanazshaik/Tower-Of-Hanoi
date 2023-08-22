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
public class DiskTest extends TestCase {
    // ~ Fields ................................................................
    private Disk one;
    private Disk two;
    private Disk three;

    // ----------------------------------------------------------
    /**
     * Set up method
     */
    public void setUp() {
        one = new Disk(5);
        two = new Disk(5);
        three = new Disk(10);
    }


    // ----------------------------------------------------------
    /**
     * tests to see if the correct values are returned
     * when disks are compared
     * throws exception if disk is null
     */
    public void testCompareTo() {
        Exception exception = null;
        try {
            one.compareTo(null);
            fail("compareTo() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("compareTo() is throwing the wrong type of exceptions",
            exception instanceof IllegalArgumentException);
        assertEquals(0, one.compareTo(two));
        assertEquals(1, three.compareTo(two));
        assertEquals(-1, one.compareTo(three));

    }


    // ----------------------------------------------------------
    /**
     * tests the string representation of a number
     */
    public void testToString() {
        assertEquals("5", one.toString());
    }


    // ----------------------------------------------------------
    /**
     * tests the equals method
     * false when disk is null
     * false when disk width doesn't match other disk width
     * true when disk width matches
     * true when compared to itself
     */
    public void testEquals() {
        assertTrue(one.equals(two));
        assertFalse(one.equals(null));
        assertFalse(one.equals("5"));
        assertTrue(one.equals(one));
        assertFalse(one.equals(three));

    }
}

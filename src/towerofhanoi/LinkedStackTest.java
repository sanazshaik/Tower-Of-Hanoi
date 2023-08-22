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

import java.util.EmptyStackException;
import student.TestCase;

/**
 * @author sanazshaik
 * @version 2022.10.18
 */
public class LinkedStackTest extends TestCase {
    // ~ Fields ................................................................
    private LinkedStack<String> one;

    // ----------------------------------------------------------
    /**
     * Set up method
     */
    public void setUp() {
        one = new LinkedStack<String>();
    }


    /**
     * tests the size of the linked stack
     */
    public void testSize() {
        one.push("cat");
        assertEquals(1, one.size());
    }


    /**
     * tests whether the clear method returns a 0 when cleared
     */
    public void testClear() {
        one.push("cat");
        one.push("dog");
        one.clear();
        assertEquals(0, one.size());
    }


    /**
     * tests to see if nothing is in the stack
     */
    public void testIsEmpty() {
        assertTrue(one.isEmpty());
        one.push("cat");
        assertFalse(one.isEmpty());
    }


    /**
     * tests to see the correct string representation output
     */
    public void testToString() {
        one.push("cat");
        one.push("dog");
        assertEquals("[dog, cat]", one.toString());
    }


    /**
     * checks the top of the stack
     * throws exception, otherwise
     */
    public void testPeek() {
        Exception thrown = null;
        try {
            one.peek();
        }
        catch (Exception exception) {
            thrown = exception;
        }

        // checks whether an Exception was actually thrown
        assertNotNull(thrown);

        // checks whether the right type of Exception was thrown
        assertTrue(thrown instanceof EmptyStackException);

        one.push("cat");
        assertEquals("cat", one.peek());
    }
    /**
     * @return the length
     *              of the queue
     */
   


    /**
     * checks the removal of top item
     * throws exception if null
     */
    public void testPop() {
        Exception thrown = null;
        try {
            one.pop();
        }
        catch (Exception exception) {
            thrown = exception;
        }

        // checks whether an Exception was actually thrown
        assertNotNull(thrown);

        // checks whether the right type of Exception was thrown
        assertTrue(thrown instanceof EmptyStackException);

        one.push("cat");
        one.push("dog");
        assertEquals("dog", one.pop());
    }


    /**
     * checks if item is added to top of the stack with size
     */
    public void testPush() {
        one.push("cat");
        assertEquals(1, one.size());
    }
}

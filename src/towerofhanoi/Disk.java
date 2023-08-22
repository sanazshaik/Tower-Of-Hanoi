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

import cs2.Shape;
import java.awt.Color;
import student.TestableRandom;

/**
 * @author sanazshaik
 * @version 2022.10.17
 */
public class Disk extends Shape implements Comparable<Disk> {

    // Constructor ..........................................................
    /**
     * @param width
     *            the width of the coordinates
     *            calls super constructor and sets a randomized color background
     */
    public Disk(int width) {
        super(0, 0, width, PuzzleWindow.DISK_HEIGHT);
        TestableRandom random = new TestableRandom();
        int size = random.nextInt(250);
        Color color = new Color(size);
        super.setBackgroundColor(color);
    }

    // ~ Methods .......................................................


    // ----------------------------------------------------------
    /**
     * @param otherDisk
     *            compare to another disk
     *            if the other disk is null, exception thrown
     *            if this disk is less than other disk, negative number
     *            if greater than other disk, positive number
     *            if equal, 0
     * @return number
     */
    @Override
    public int compareTo(Disk otherDisk) {
        if (otherDisk == null) {
            throw new IllegalArgumentException();
        }

        int a = this.getWidth();
        int b = otherDisk.getWidth();

        if (a < b) {
            return -1;
        }
        else if (a > b) {
            return 1;
        }
        return 0;
    }


    // ----------------------------------------------------------
    /**
     * @return string value
     *         of getWidth()
     */
    public String toString() {
        int a = this.getWidth();
        return String.valueOf(a);
    }


    // ----------------------------------------------------------
    /**
     * @param obj
     *            object comparing to
     * @return boolean values
     *         if disks' width equal each other, true
     *         if disk is null, false
     *         else, false
     */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null) {
            return false;
        }
        if (this.getClass() == obj.getClass()) {
            Disk other = (Disk)obj;
            return this.getWidth() == other.getWidth();
        }
        return false;
    }
}

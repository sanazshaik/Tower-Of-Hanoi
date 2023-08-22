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
 * @version 2022.10.18
 */
public class Tower extends LinkedStack<Disk> {
    // ~ Fields ................................................................
    private Position position;

    // Constructor ..........................................................
    /**
     * @param position
     *            specifies any position to be in the parameter
     *            initializes position and calls the super constructor
     */
    public Tower(Position position) {
        super();
        this.position = position;
    }

    // ~ Methods .......................................................


    // ----------------------------------------------------------
    /**
     * @return position
     *         the position of the tower
     */
    public Position position() {
        return position;
    }


    // ----------------------------------------------------------
    /**
     * @param disk
     *            the disk being compared
     *            throws exceptions when Disk is null
     *            or doesn't satisfy the tower being empty or
     *            top of the stack greater than pushed disk
     */
    @Override
    public void push(Disk disk) {
        if (disk == null) {
            throw new IllegalArgumentException();
        }
        if (super.isEmpty() || super.peek().compareTo(disk) > 0) {
            super.push(disk);
        }
        else {
            throw new IllegalStateException();
        }
    }

}

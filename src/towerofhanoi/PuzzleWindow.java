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

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import cs2.Button;
import cs2.Shape;
import cs2.Window;
import cs2.WindowSide;

/**
 * @author sanazshaik
 * @version 2022.10.19
 */
public class PuzzleWindow implements Observer {
    // ~ Fields ................................................................
    private HanoiSolver game;
    private Shape left;
    private Shape middle;
    private Shape right;
    private Window window;

    static final int WIDTH_FACTOR = 8;
    static final int DISK_GAP = 0;
    static final int DISK_HEIGHT = 10;

    // ~ Methods .......................................................
    // ----------------------------------------------------------
    /**
     * pauses between disk movements
     */
    private void sleep() {
        try {
            Thread.sleep(500);
        }
        catch (Exception e) {
        }
    }


    // ----------------------------------------------------------
    /**
     * @param postion
     *            position used as parameter
     *            moves the disk depending on where the poles are
     *            followed by math
     */
    private void moveDisk(Position position) {
        Disk currentDisk = game.getTower(position).peek();
        Shape currentPole;

        switch (position) {
            case LEFT:
                currentPole = left;
                break;
            case MIDDLE:
                currentPole = middle;
                break;
            case RIGHT:
                currentPole = right;
                break;
            default:
                currentPole = middle;
                break;
        }
        int x = currentPole.getX();
        int y = currentPole.getY() + currentPole.getHeight() - game.getTower(
            position).size() * DISK_HEIGHT;

        int w = currentDisk.getWidth();
        currentDisk.moveTo(x - w / 2 + currentPole.getWidth() / 2, y);

    }


    // Constructor ..........................................................
    // ----------------------------------------------------------
    /**
     * @param game
     *            hanoiSolver object being used
     * 
     *            adds shapes to the window
     *            adds a solve button
     */
    public PuzzleWindow(HanoiSolver game) {
        this.game = game;
        game.addObserver(this);
        window = new Window();
        window.setTitle("Tower of Hanoi");

        left = new Shape(150, 150, 5, 100, Color.BLACK);
        middle = new Shape(300, 150, 5, 100, Color.RED);
        right = new Shape(450, 150, 5, 100, Color.GREEN);

        for (int i = game.disks(); i > 0; i--) {
            Disk disk = new Disk(WIDTH_FACTOR * i);
            game.getTower(Position.LEFT).push(disk);
            window.addShape(game.getTower(Position.LEFT).peek());
            moveDisk(Position.LEFT);
        }
        window.addShape(left);
        window.addShape(middle);
        window.addShape(right);

        Button solve = new Button("Solve");
        window.addButton(solve, WindowSide.NORTH);
        solve.onClick(this, "clickedSolve");

    }


    // ----------------------------------------------------------
    /**
     * @param o
     * @param arg
     *            arg is compared to the position class
     * 
     *            update method is called when move method calls
     *            notifyObservers method
     */
    @Override
    public void update(Observable o, Object arg) {
        if (arg.getClass() == Position.class) {
            moveDisk((Position)arg);
        }
        sleep();
    }


    // ----------------------------------------------------------
    /**
     * @param button
     *            the button that is being implemented
     *            display is updated when solve method is called
     */
    public void clickedSolve(Button button) {
        button.disable();
        new Thread() {
            public void run() {
                game.solve();
            }
        }.start();
    }

}

/*I, Angelo Marcelo, worked on the assignment alone,
    using only course materials.*/

import java.awt.Rectangle;

/**
 * The abstract class representing Houses from the North.
 * Includes a move method override that gives a health boost
 * while in the north.
 *
 * @author Angelo Marcelo
 * @version 1.0
 */
public abstract class NorthHouse extends House {

    /**
     * Fully qualified constructor for the North House classes
     *
     * @param imageFilename filename of crest image
     * @param xPos original x position of the House object
     * @param yPos original x position of the House object
     * @param health the starting health of the House object
     * @param maxAge the maximum age of the House object
     * @param bounds the rectangle object representing Westeros
     */
    public NorthHouse(String imageFilename, int xPos, int yPos,
        int health, int maxAge, Rectangle bounds) {
        super(imageFilename, xPos, yPos, health, maxAge, bounds);
    }

    @Override
    protected void move() {
        while (true) {
            int newX = xPos + (int) (50 * (Math.random() - .5));
            int newY = yPos + (int) (50 * (Math.random() - .5));
            if (bounds.contains(newX, newY)) {
                xPos = newX;
                yPos = newY;
                if (yPos > Westeros.HEIGHT / 2) {
                    health--;
                }
                age++;
                return;
            }
        }
    }
}
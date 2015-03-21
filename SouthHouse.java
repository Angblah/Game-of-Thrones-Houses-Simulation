/*I, Angelo Marcelo, worked on the assignment alone,
    using only course materials.*/

import java.awt.Rectangle;

/**
 * Abstract class representing Houses from the South.
 * Includes a move method override that increases the speed
 * in the South.
 *
 * @author Angelo Marcelo
 * @version 1.0
 */
public abstract class SouthHouse extends House {

    /**
     * Fully qualified constructor for the South House class.
     *
     * @param imageFilename filename of crest image
     * @param xPos original x position of the House object
     * @param yPos original x position of the House object
     * @param health the starting health of the House object
     * @param maxAge the maximum age of the House object
     * @param bounds the rectangle object representing Westeros
     */
    public SouthHouse(String imageFilename, int xPos, int yPos,
        int health, int maxAge, Rectangle bounds) {
        super(imageFilename, xPos, yPos, health, maxAge, bounds);
    }

    @Override
    protected void move() {
        while (true) {
            int newX, newY;
            if (yPos > Westeros.HEIGHT / 2) {
                newX = xPos + (int) (75 * (Math.random() - .5));
                newY = yPos + (int) (75 * (Math.random() - .5));
            } else {
                newX = xPos + (int) (50 * (Math.random() - .5));
                newY = yPos + (int) (50 * (Math.random() - .5));
            }

            if (bounds.contains(newX, newY)) {
                xPos = newX;
                yPos = newY;
                health--;
                age++;
                return;
            }
        }
    }
}
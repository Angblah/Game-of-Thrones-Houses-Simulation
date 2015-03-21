/*I, Angelo Marcelo, worked on the assignment alone,
    using only course materials.*/

import java.awt.Rectangle;

/**
 * Class representing those from the House Schauer.
 * The House Schauer's main goal is to have a blood
 * barath of Baratheons. They choose to release their
 * barath upon those of House Baratheon.
 *
 * @author Angelo Marcelo
 * @version 1.0
 */
public class Schauer extends House {

    private static int schauerCount = 0;

    /**
     * Fully qualified Constructor for House Schauer
     * Passes along Schauer characteristics to the other constructors
     * and increases the Schauer headcount
     *
     * @param xPos The initial x position of the Object
     * @param yPos The initial y position of the Object
     * @param bounds The rectangle object representing Westeros
     */
    public Schauer(int xPos, int yPos, Rectangle bounds) {
        super("glass.png", xPos, yPos, 100, 58, bounds);
        schauerCount++;
    }

    /**
     * Returns the count of House Schauer members
     *
     * @return headcount of House Schauer members
     */
    public int getSchauerCount() {
        return schauerCount;
    }

    @Override
    public boolean canReproduceWithHouse(House otherHouse) {
        return (otherHouse != parent1 && otherHouse != parent2
            && otherHouse != child && otherHouse instanceof Targaryen
            && schauerCount < 12 && child == null);
    }
    @Override
    public boolean canHarmHouse(House otherHouse) {
        return (otherHouse instanceof Baratheon);
    }
    @Override
    public House reproduceWithHouse(House otherHouse) {
        if (Math.random() < .2) {
            House baby = new Targaryen(xPos, yPos, bounds);
            baby.parent1 = this;
            baby.parent2 = otherHouse;
            this.child = baby;
            otherHouse.child = baby;
            return baby;
        } else {
            return null;
        }
    }
    @Override
    public void harmHouse(House otherHouse) {
        if (Math.random() <= .30) {
            otherHouse.health -= 12;
        }
    }
    @Override
    public boolean isDead() {
        boolean isDead = (health <= 0 || isOld());
        if (isDead) {
            schauerCount--;
        }
        return isDead;
    }
}
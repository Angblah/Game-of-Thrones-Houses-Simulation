/*I, Angelo Marcelo, worked on the assignment alone,
    using only course materials.*/

import java.awt.Rectangle;

/**
 * Class representing those from the House Baratheon.
 * Extends the SouthHouse class.
 *
 * @author Angelo Marcelo
 * @version 1.0
 */
public class Baratheon extends SouthHouse {

    private static int baratheonCount = 0;

    /**
     * Fully qualified Constructor for House Baratheon
     * Passes along Baratheon characteristics to the other constructors
     * and increases the Baratheon headcount
     *
     * @param xPos The initial x position of the Object
     * @param yPos The initial y position of the Object
     * @param bounds The rectangle object representing Westeros
     */
    public Baratheon(int xPos, int yPos, Rectangle bounds) {
        super("stag.png", xPos, yPos, 100, 52, bounds);
        baratheonCount++;
    }

    /**
     * Returns the count of House Baratheon members
     *
     * @return headcount of House Baratheon members
     */
    public int getBaratheonCount() {
        return baratheonCount;
    }

    @Override
    public boolean canReproduceWithHouse(House otherHouse) {
        return (otherHouse != parent1 && otherHouse != parent2
            && otherHouse != child && otherHouse instanceof Lannister
            && baratheonCount < 10 && child == null);
    }
    @Override
    public boolean canHarmHouse(House otherHouse) {
        return (otherHouse instanceof Targaryen);
    }
    @Override
    public House reproduceWithHouse(House otherHouse) {
        if (Math.random() < .2) {
            House baby = new Baratheon(xPos, yPos, bounds);
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
        otherHouse.health -= 32;
    }
    @Override
    public boolean isDead() {
        boolean isDead = (health <= 0 || isOld());
        if (isDead) {
            baratheonCount--;
        }
        return isDead;
    }
}
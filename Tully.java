/*I, Angelo Marcelo, worked on the assignment alone,
    using only course materials.*/

import java.awt.Rectangle;

/**
 * Class representing those from House Tully
 * Extends the NorthHouse class.
 *
 * @author Angelo Marcelo
 * @version 1.0
 */
public class Tully extends NorthHouse {

    private static int tullyCount = 0;

    /**
     * Fully qualified Constructor for House Tully
     * Passes along Tully characteristics to the other constructors
     * and increases the Tully headcount
     *
     * @param xPos The initial x position of the Object
     * @param yPos The initial y position of the Object
     * @param bounds The rectangle object representing Westeros
     */
    public Tully(int xPos, int yPos, Rectangle bounds) {
        super("trout.png", xPos, yPos, 100, 70, bounds);
        tullyCount++;
    }

    /**
     * Returns the count of House Tully members
     *
     * @return headcount of House Tully members
     */
    public int getTullyCount() {
        return tullyCount;
    }

    @Override
    public boolean canReproduceWithHouse(House otherHouse) {
        return (otherHouse != parent1 && otherHouse != parent2
            && otherHouse != child && otherHouse instanceof Stark
            && tullyCount < 10 && child == null);
    }
    @Override
    public boolean canHarmHouse(House otherHouse) {
        return (otherHouse instanceof Lannister);
    }
    @Override
    public House reproduceWithHouse(House otherHouse) {
        if (Math.random() < .2) {
            House baby = new Tully(xPos, yPos, bounds);
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
        if (Math.random() <= .20) {
            otherHouse.health -= 23;
        }
    }
    @Override
    public boolean isDead() {
        boolean isDead = (health <= 0 || isOld());
        if (isDead) {
            tullyCount--;
        }
        return isDead;
    }
}
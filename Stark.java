/*I, Angelo Marcelo, worked on the assignment alone,
    using only course materials.*/

import java.awt.Rectangle;

/**
 * Class representing those from the House Stark.
 * Extends the NorthHouse class.
 *
 * @author Angelo Marcelo
 * @version 1.0
 */
public class Stark extends NorthHouse {

    private static int starkCount = 0;

    /**
     * Fully qualified Constructor for House Stark
     * Passes along Stark characteristics to the other constructors
     * and increases the Stark headcount
     *
     * @param xPos The initial x position of the Object
     * @param yPos The initial y position of the Object
     * @param bounds The rectangle object representing Westeros
     */
    public Stark(int xPos, int yPos, Rectangle bounds) {
        super("direwolf.png", xPos, yPos, 100, 60, bounds);
        starkCount++;
    }

    /**
     * Returns the count of House Stark members
     *
     * @return headcount of House Stark members
     */
    public int getStarkCount() {
        return starkCount;
    }

    @Override
    public boolean canReproduceWithHouse(House otherHouse) {
        return (otherHouse != parent1 && otherHouse != parent2
            && otherHouse != child && otherHouse instanceof Tully
            && starkCount < 10 && child == null);
    }
    @Override
    public boolean canHarmHouse(House otherHouse) {
        return (otherHouse instanceof Lannister);
    }
    @Override
    public House reproduceWithHouse(House otherHouse) {
        if (Math.random() < .2) {
            House baby = new Stark(xPos, yPos, bounds);
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
        if (Math.random() <= .40) {
            otherHouse.health -= 23;
        }
    }
    @Override
    public boolean isDead() {
        boolean isDead = (health <= 0 || isOld());
        if (isDead) {
            starkCount--;
        }
        return isDead;
    }
}
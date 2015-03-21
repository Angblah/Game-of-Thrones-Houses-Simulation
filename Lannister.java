/*I, Angelo Marcelo, worked on the assignment alone,
    using only course materials.*/

import java.awt.Rectangle;

/**
 * Class representing those from the House Lannister.
 * Extends the SouthHouse class.
 *
 * @author Angelo Marcelo
 * @version 1.0
 */
public class Lannister extends SouthHouse {

    private static int lannisterCount = 0;

    /**
     * Fully qualified Constructor for House Lannister
     * Passes along Lannister characteristics to the other constructors
     * and increases the Lannister headcount
     *
     * @param xPos The initial x position of the Object
     * @param yPos The initial y position of the Object
     * @param bounds The rectangle object representing Westeros
     */
    public Lannister(int xPos, int yPos, Rectangle bounds) {
        super("lion.png", xPos, yPos, 100, 46, bounds);
        lannisterCount++;
    }

    /**
     * Returns the count of House Lannister members
     *
     * @return headcount of House Lannister members
     */
    public int getLannisterCount() {
        return lannisterCount;
    }

    @Override
    public boolean canReproduceWithHouse(House otherHouse) {
        return (otherHouse != parent1 && otherHouse != parent2
            && otherHouse != child && otherHouse instanceof SouthHouse
            && lannisterCount < 10 && child == null);
    }
    @Override
    public boolean canHarmHouse(House otherHouse) {
        return (otherHouse instanceof NorthHouse);
    }
    @Override
    public House reproduceWithHouse(House otherHouse) {
        if (Math.random() < .1) {
            House baby = new Lannister(xPos, yPos, bounds);
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
        boolean trulyTully = otherHouse instanceof Tully;
        if (Math.random() <= .80 && trulyTully) {
            otherHouse.health -= 26;
        } else if (Math.random() <= .6 && !trulyTully) {
            otherHouse.health -= 23;
        }
    }
    @Override
    public boolean isDead() {
        boolean isDead = (health <= 0 || isOld());
        if (isDead) {
            lannisterCount--;
        }
        return isDead;
    }
}
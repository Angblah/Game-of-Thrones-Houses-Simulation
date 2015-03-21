/*I, Angelo Marcelo, worked on the assignment alone,
    using only course materials.*/

import java.awt.Rectangle;

/**
 * Class representing those from the House Targaryen.
 * Extends the House class.
 *
 * @author Angelo Marcelo
 * @version 1.0
 */
public class Targaryen extends House {

    private static int targaryenCount = 0;

    /**
     * Fully qualified Constructor for House Targaryen
     * Passes along Targaryen characteristics to the other constructors
     * and increases the Targaryen headcount
     *
     * @param xPos The initial x position of the Object
     * @param yPos The initial y position of the Object
     * @param bounds The rectangle object representing Westeros
     */
    public Targaryen(int xPos, int yPos, Rectangle bounds) {
        super("dragon.png", xPos, yPos, 100, bounds);
        targaryenCount++;
    }

    /**
     * Returns the count of House Targaryen members
     *
     * @return headcount of House Targaryen members
     */
    public int getTargaryenCount() {
        return targaryenCount;
    }

    @Override
    public boolean canReproduceWithHouse(House otherHouse) {
        return (otherHouse != parent1 && otherHouse != parent2
            && otherHouse != child && otherHouse instanceof Targaryen
            && targaryenCount < 12 && child == null);
    }
    @Override
    public boolean canHarmHouse(House otherHouse) {
        return (otherHouse instanceof NorthHouse
            || otherHouse instanceof Lannister);
    }
    @Override
    public House reproduceWithHouse(House otherHouse) {
        if (Math.random() < .1) {
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
        otherHouse.health -= 16;
    }
    @Override
    public boolean isDead() {
        boolean isDead = (health <= 0 || isOld());
        if (isDead) {
            targaryenCount--;
        }
        return isDead;
    }
}
/*I, Angelo Marcelo, worked on the assignment alone,
    using only course materials.*/

import javax.swing.ImageIcon;
import java.awt.Rectangle;
import java.awt.Graphics;

/**
 * The abstract House for the Game of Thrones Simulation.
 * This is the base class of all the Houses in the simulation.
 *
 * @author Angelo Marcelo
 * @version 1.0
 */
public abstract class House {

    protected ImageIcon image;
    protected String imageFilename;
    protected int xPos, yPos;
    protected int health, age;
    protected int maxAge;
    protected Rectangle bounds;
    protected House parent1, parent2;
    protected House child = null;

    /**
     * Fully qualified constructor for House class
     *
     * @param imageFilename filename of crest image
     * @param xPos original x position of the House object
     * @param yPos original x position of the House object
     * @param health the starting health of the House object
     * @param maxAge the maximum age of the House object
     * @param bounds the rectangle object representing Westeros
     */
    public House(String imageFilename, int xPos, int yPos,
        int health, int maxAge, Rectangle bounds) {
        image = new ImageIcon(imageFilename);
        this.xPos = xPos;
        this.yPos = yPos;
        this.health = health;
        this.age = 0;
        this.maxAge = maxAge;
        this.bounds = bounds;
    }
    /**
     * Partially qualified constructor for House class.
     * Doesn't have a maximum age, so sets it to 1000.
     *
     * @param imageFilename filename of crest image
     * @param xPos original x position of the House object
     * @param yPos original x position of the House object
     * @param health the starting health of the House object
     * @param bounds the rectangle object representing Westeros
     */
    public House(String imageFilename, int xPos, int yPos,
        int health, Rectangle bounds) {
        image = new ImageIcon(imageFilename);
        this.xPos = xPos;
        this.yPos = yPos;
        this.health = health;
        this.age = 0;
        this.maxAge = 1000;
        this.bounds = bounds;
    }
    /**
     * Partially qualified constructor for House class.
     * Without default coordinates, sets it to the center of
     * the map, but still has a maximum age.
     *
     * @param imageFilename filename of crest image
     * @param health the starting health of the House object
     * @param maxAge the maximum age of the House object
     * @param bounds the rectangle object representing Westeros
     */
    public House(String imageFilename, int health,
        int maxAge, Rectangle bounds) {
        image = new ImageIcon(imageFilename);
        this.xPos = Westeros.WIDTH / 2;
        this.yPos = Westeros.HEIGHT / 2;
        this.health = health;
        this.age = 0;
        this.maxAge = maxAge;
        this.bounds = bounds;
    }
    /**
     * Least qualified constructor for House class
     * Sets x and y to the center of the map and
     * max age to 1000
     *
     * @param imageFilename filename of crest image
     * @param health the starting health of the House object
     * @param bounds the rectangle object representing Westeros
     */
    public House(String imageFilename, int health, Rectangle bounds) {
        image = new ImageIcon(imageFilename);
        this.xPos = Westeros.WIDTH / 2;
        this.yPos = Westeros.HEIGHT / 2;
        this.health = health;
        this.age = 0;
        this.maxAge = 1000;
        this.bounds = bounds;
    }

    /**
     * Method that controls the movement of the House objects
     */
    protected void move() {
        while (true) {
            int newX = xPos + (int) (50 * (Math.random() - .5));
            int newY = yPos + (int) (50 * (Math.random() - .5));
            if (bounds.contains(newX, newY)) {
                xPos = newX;
                yPos = newY;
                if (this instanceof Schauer) {
                    health--;
                    age++;
                }
                return;
            }
        }
    }

    /**
     * Method that sets health of a House object to 0 or dead.
     */
    protected void die() {
        health = 0;
    }

    /**
     * Method that checks for House object collision based off of the
     * image width and height
     *
     * @param otherHouse The house object that may be colliding
     */
    protected boolean collidesWithHouse(House otherHouse) {
        return (otherHouse.xPos <= xPos + image.getIconWidth()
            && otherHouse.xPos >= xPos) && (otherHouse.yPos <= yPos
            + image.getIconHeight() && otherHouse.yPos >= yPos);
    }
    /**
     * Method that checks whether a House object has surpassed their
     * maximum age
     *
     * @return A boolean representing whether or not they are too old
     */
    protected boolean isOld() {
        return (age > maxAge);
    }
    /**
     * Method that checks to see if the House object is dead
     * and decreases the Headcount by one.
     *
     * @return A boolean representing whether or not they are dead
     */
    public abstract boolean isDead();
    /**
     * Method that checks to see if the House member can
     * reproduce with the member of the other House.
     *
     * @param otherHouse The other house
     * @return A boolean representing whether or not they may be partners
     */
    protected abstract boolean canReproduceWithHouse(House otherHouse);
    /**
     * Method that goes through the process of reproduction
     * Increases the headcount of the House and sets the Parent and Child
     *
     * @param otherHouse The partner House
     * @return The child of the partnership or a
     * null if reproduction did not occur
     */
    protected abstract House reproduceWithHouse(House otherHouse);
    /**
     * Method that checks to see if the House members may fight.
     *
     * @param otherHouse The prospective brawler
     * @return A boolean representing whether they can harm each other
     */
    protected abstract boolean canHarmHouse(House otherHouse);
    /**
     * Method that processes the fight between House members
     *
     * @param otherHouse The Brawler of the other House
     */
    protected abstract void harmHouse(House otherHouse);



    /**
     * Should draw the House at its location.
     */
    protected void draw(Graphics g) {
        image.paintIcon(null, g, xPos, yPos);
    }
}

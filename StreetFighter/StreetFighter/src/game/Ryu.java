package game;

import city.cs.engine.*;

/**
 * Simple character
 */
public class Ryu extends Walker {

    // Remember:  using the keyword static below means the fields shape and image belong to the class, rather than any instance. 
    // That means there is a single shape and image for all instances of the class.
    private static final Shape shape = new BoxShape(5, 7f);

    private static BodyImage image
            = new BodyImage("data/ryu.gif", 15f);

    private int orangeCount;
    private int liveCount;

    public Ryu(World world) {
        super(world, shape);
        addImage(image);
        orangeCount = 0;
        liveCount = 1;
    }

    public int getOrangeCount() {
        return orangeCount;
    }

    public void incrementOrangeCount() {
        orangeCount++;
        System.out.println("Tasty! Food Count = " + orangeCount);
    }

    public int getLiveCount() {
        return liveCount;
    }

    public void decrementLiveCount() {
        liveCount--;
        System.out.println("Fatality! Lives Left: " + liveCount);
    }
}

package game;

import city.cs.engine.*;

/**
 * Doors in a game. When the actor collides with a door, if
 * the current level is complete the game is advanced to the
 * next level. 
 */
public class Door extends StaticBody {   
    
    /**
     * Initialise a new door.
     * @param world The world.
     */
    public Door(World world) {
        super(world, new BoxShape(1.5f, 1.5f));
        addImage(new BodyImage("data/door1.jpg", 10f));
    }
}

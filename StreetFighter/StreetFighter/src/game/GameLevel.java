package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * A level of the game.
 */
public abstract class GameLevel extends World {
    private Ryu player;
    private Ken player2;
    
    public Ryu getPlayer() {
        return player;
        
    }
    
    public Ken getPlayer2() {
        return player2;
    }
    
    /**
     * Populate the world of this level.
     * Child classes should this method with additional bodies.
     */
    public void populate(Game game) {
        // make a character
        player = new Ryu(this);
        player.setPosition(startPosition());
        
        player2 = new Ken(this);
        player2.setPosition(startPosition2());
        
        Door door = new Door(this);
        door.setPosition(doorPosition());
        door.addCollisionListener(new DoorListener(game));
    }
    
    /** The initial position of the player. */
    public abstract Vec2 startPosition();
    
    /** The initial position of the player2. */
    public abstract Vec2 startPosition2();
    
    /** The position of the exit door. */
    public abstract Vec2 doorPosition();
    
    /** Is this level complete? */
    public abstract boolean isCompleted();
}

package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Level 2 of the game
 */
public class Level2 extends GameLevel {

    private static final int NUM_ORANGES = 6;

    /**
     * Populate the world.
     */
    @Override
    public void populate(Game game) {
        super.populate(game);

        // make the ground
        Shape GroundShape = new BoxShape(50, 1f);
        Body GroundSize = new StaticBody(this, GroundShape);
        GroundSize.setPosition(new Vec2(0, -26f));
        
        // make Wall
        Shape WallShape = new BoxShape(1, 50f);
        Body WallSize = new StaticBody(this, WallShape);
        WallSize.setPosition(new Vec2(-53, -24f));
        
        Shape Wall1Shape = new BoxShape(1, 50f);
        Body Wall1Size = new StaticBody(this, Wall1Shape);
        Wall1Size.setPosition(new Vec2(53, -24f));
        
        Shape CeilingShape = new BoxShape(50, 1f);
        Body CeilingSize = new StaticBody(this, CeilingShape);
        CeilingSize.setPosition(new Vec2(0, 45f));
        

        // make platforms
        Shape PlatformShape = new BoxShape(6, 0.5f);
        Body PlatformSize = new StaticBody(this, PlatformShape);
        PlatformSize.addImage(new BodyImage("data/grassplatform.png",15f));
        PlatformSize.setPosition(new Vec2(-20, -5f));
        
        Shape Platform1Shape = new BoxShape(6, 0.5f);
        Body Platform1Size = new StaticBody(this, Platform1Shape);
        Platform1Size.addImage(new BodyImage("data/grassplatform.png",15f));
        Platform1Size.setPosition(new Vec2(20, -5f));
        

        for (int i = 0; i < NUM_ORANGES; i++) {
            Body orange = new Turkey(this);
            orange.setPosition(new Vec2(i * 2 - 10, 10));
            orange.addCollisionListener(new Pickup(getPlayer()));
        }
    }

    @Override
    public Vec2 startPosition() {
        return new Vec2(-40, 20);
    }
    
     @Override
    public Vec2 startPosition2() {
        return new Vec2(40, 20);
    }

    @Override
    public Vec2 doorPosition() {
        return new Vec2(-20f, -20f);
    }

    @Override
    public boolean isCompleted() {
        return getPlayer().getOrangeCount() == NUM_ORANGES;
    }
}

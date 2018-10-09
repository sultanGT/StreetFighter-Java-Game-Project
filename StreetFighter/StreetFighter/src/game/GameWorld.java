package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 *
 * @author greg
 */

/**
 * A world with some bodies.
 */
public class GameWorld extends World {
    private Ryu ryu;
    private Ken ken;
    

    
    public GameWorld() {
        super();
        
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
        Shape PlatformShape = new BoxShape(6, 1f);
        Body PlatformSize = new StaticBody(this, PlatformShape);
        PlatformSize.addImage(new BodyImage("data/grassplatform.png",15f));
        PlatformSize.setPosition(new Vec2(-20, -5f));
        
        Shape Platform1Shape = new BoxShape(6, 1f);
        Body Platform1Size = new StaticBody(this, Platform1Shape);
        Platform1Size.addImage(new BodyImage("data/grassplatform.png",15f));
        Platform1Size.setPosition(new Vec2(20, -5f));
        
        

        
        // make a character
        ryu = new Ryu(this);
        ryu.setPosition(new Vec2(-40, 20));
        
        
        // make a character
        
        ken = new Ken(this);
        ken.setPosition(new Vec2(40, 20));
        
      for (int i = 0; i < 11; i++) {
            Body orange = new Turkey(this);
            orange.setPosition(new Vec2(i*2-10, 10));
            orange.addCollisionListener(new Pickup(ryu));
            ken.addCollisionListener(new Pickup(ryu));
            
      }
        
       
        

        
        
        
        
    }
    
    public Ryu getPlayer() {
        return ryu;
    }
    
    
    
    
}

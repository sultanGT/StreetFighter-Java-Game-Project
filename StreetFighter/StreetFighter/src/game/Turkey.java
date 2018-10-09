package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.awt.Color;

/**
 *
 * @author greg
 */


/**
 * An orange.
 */
public class Turkey extends DynamicBody {
    private static Shape shape = new CircleShape(2f);
    private static final BodyImage image =
         new BodyImage("data/turkey.png", 5f);
    
    public Turkey(World world) {
        super(world, shape);
        addImage(image);
        
    }
}

package game;

import city.cs.engine.*;
import game.Ryu;

/**
 * Collision listener that allows the bird to collect things.
 */
public class Pickup implements CollisionListener {
    private Ryu ryu;
    
    public Pickup(Ryu ryu) {
        this.ryu = ryu;
    }

    @Override
    public void collide(CollisionEvent e) {
        
        if (e.getReportingBody() instanceof Ken && e.getOtherBody() == ryu) {
            ryu.decrementLiveCount();
            e.getReportingBody().destroy();
        }
        
        else if
        
            (e.getReportingBody() instanceof Turkey && e.getOtherBody() == ryu) {
            ryu.incrementOrangeCount();
            e.getReportingBody().destroy();
        }
    }
    
}

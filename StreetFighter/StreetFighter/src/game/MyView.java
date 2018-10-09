package game;

import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import city.cs.engine.*;
import java.awt.Color;

/**
 * extended view
 */
public class MyView extends UserView {
    Ryu ryu;
    
    private static final Image background1 = new ImageIcon("data/Level1Background.gif").getImage();
    private static final Image background2 = new ImageIcon("data/Level4Background.gif").getImage();
    private static final Image background3 = new ImageIcon("data/Level5Background.gif").getImage();
    
    private GameLevel world;
    
    public MyView(GameLevel world, Ryu ryu, int width, int height) {
        super(world, width, height);
        this.ryu = ryu;
        
    }
    
    @Override
    protected void paintBackground(Graphics2D g) {
        
        switch (this.getWorld().getClass().getName()) {
            
        case "game.Level1":
         
        g.drawImage(background1, 0, 0, 2000, 1000,this);
        break;
     
        case "game.Level2":
        g.drawImage(background2, 0, 0, 2000, 1000, this);
        break;
   
        case "game.Level3":
        g.drawImage(background3, 0, 0, 2000, 1000, this);
        break;
        default:
        break;
        }
    
    }

    @Override
    protected void paintForeground(Graphics2D g) {
        
        g.drawString("Turkey Count  :  " + ryu.getOrangeCount(), 1500,25);
    }

}

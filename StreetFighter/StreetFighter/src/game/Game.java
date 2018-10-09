package game;

import city.cs.engine.*;
import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

/**
 * The computer game.
 */
public class Game {

    /**
     * The World in which the bodies move and interact.
     */
    private GameLevel world;

    /**
     * A graphical display of the world (a specialised JPanel).
     */
    private UserView view;

    private int level;

    private Controller controller;

    /**
     * Initialise a new Game.
     */
    public Game() {

        // make the world
        level = 1;
        world = new Level1();
        world.populate(this);

        view = new MyView(world, world.getPlayer(), 2000, 1000);

        // make a view
        // uncomment this to draw a 1-metre grid over the view
        // view.setGridResolution(1);
        // display the view in a frame
        final JFrame frame = new JFrame("Event handling");

        Container buttons = new ControlPanel(this);
        frame.add(buttons, BorderLayout.WEST);
        
        

        // quit the application when the game window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // display the world in the window
        frame.add(view);
        frame.setFocusable(true);
        frame.requestFocusInWindow();
        
        // don't let the game window be resized
        frame.setResizable(false);
        // size the game window to fit the world view
        frame.pack();
        // make the window visible
        frame.setVisible(true);
        // get keyboard focus
        frame.requestFocus();
        // give keyboard focus to the frame whenever the mouse enters the view

        controller = new Controller(world.getPlayer());
        frame.addKeyListener(controller);

        // uncomment to make the view track the bird
        // world.addStepListener(new Tracker(view, world.getPlayer()));
        //uncomment this to make a debugging view
        // JFrame debugView = new DebugViewer(world, 500, 500);
        // start!
        world.start();
    }

    /**
     * The player in the current level.
     */
    public Ryu getPlayer() {
        return world.getPlayer();
    }
    
    public Ken getPlayer2() {
        return world.getPlayer2();
    }
    
  
    
    public void pause(){
        world.stop();
    }
    /**
     * Is the current level of the game finished?
     */
    public boolean isCurrentLevelCompleted() {
        return world.isCompleted();
    }

    /**
     * Advance to the next level of the game.
     */
    public void goNextLevel() {
        world.stop();
        if (level == 3) {
            System.exit(0);
        } else if (level == 1) {
            level++;
            // get a new world
            world = new Level2();
            // fill it with bodies
            world.populate(this);
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            
            // show the new world in the view
            view.setWorld(world);

            world.start();
        } else if (level == 2){
            level++;
            // get a new world
            world = new Level3();
            // fill it with bodies
            world.populate(this);
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            
            // show the new world in the view
            view.setWorld(world);

            world.start();
        }
    }

    /**
     * Run the game.
     */
    public static void main(String[] args) {
        new Game();

    }
}

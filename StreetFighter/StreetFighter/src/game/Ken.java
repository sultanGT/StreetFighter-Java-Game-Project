/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.BodyImage;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.Walker;
import city.cs.engine.World;

/**
 *
 * @author sulta
 */

    public class Ken extends Walker {

    // Remember:  using the keyword static below means the fields shape and image belong to the class, rather than any instance. 
    // That means there is a single shape and image for all instances of the class.
    private static final Shape shape = new BoxShape(5,7f);

    private static final BodyImage image =
        new BodyImage("data/ken.gif", 15f);

 
    public Ken(World world) {
        super(world, shape);
        addImage(image);
        
    }

    }



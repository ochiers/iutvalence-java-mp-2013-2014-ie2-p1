package fr.iutvalence.java.mp.BrickBreaker;

import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Float;

public class TestJava2D
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        Rectangle2D.Float rect1 = new Rectangle2D.Float(1,1,20,20);
        Rectangle2D.Float rect2 = new Rectangle2D.Float(15,15,10,10);
        Rectangle2D.Float dest = new Rectangle2D.Float();
        
        Rectangle2D.intersect(rect1, rect2, dest);
        System.out.println(dest.toString());
    }

}

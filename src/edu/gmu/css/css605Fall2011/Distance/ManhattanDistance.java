/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gmu.css.css605Fall2011.Distance;

import edu.gmu.css.css605Fall2011.KMeans.Point;

/**
 *
 * @author ckhyde
 */
public class ManhattanDistance implements Distance
{
    public double dGetDistance(Point a, Point b)
    { 
        double dTempDistance = 0.0;
        
        dTempDistance = Math.abs(a.dGetX() - b.dGetX()) + Math.abs(a.dGetY() - b.dGetY());
        
        return dTempDistance;
    }    
}

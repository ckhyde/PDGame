/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gmu.css.css605Fall2011.KMeans;

/**
 *
 * @author ckhyde
 */
public class Point 
{
    //public int x, y;
    public double dX, dY;
    
    String sID;
    
    public Point()
    {
      this(0, 0, "Null");    
    }
    
    public Point(double dInputX, double dInputY)
    {
      this(dInputX, dInputY, "NoID");    
    }       
    
    public Point(double dInputX, double dInputY, String sIDescript)
    {
        this.dX = dInputX;
        this.dY = dInputY;
        
        this.sID = sIDescript;        
    }        
    
    public double dGetX()
    {
        return dX;
    }
    
    public double dGetY()
    {
        return dY;
    }        
    
    public String iGetID()
    {
        return sID;
    }        
    
    public void setX(double dInputX)
    {
        dX = dInputX;
    }        
    
    public void setY(double dInputY)
    {
        dY = dInputY;
    }            
    
    public String toString()
    {
        return "Point ID: " + sID + ", X: " + dX + ", Y: " + dY;
    }
            
}

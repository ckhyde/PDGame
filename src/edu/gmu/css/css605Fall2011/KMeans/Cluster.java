/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gmu.css.css605Fall2011.KMeans;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import edu.gmu.css.css605Fall2011.Distance.*;       

/**
 *
 * @author ckhyde
 */
public class Cluster 
{    
    private Point centroid;
    private LinkedList<Point> data;     //List<Point> points;
    private double energy;
    private int iID;
    private int iSize;
    //EuclideanDistance distance = new EuclideanDistance();
    //ManhattanDistance distance = new ManhattanDistance();
    SquareEucDistance distance = new SquareEucDistance();
  
    public Cluster(int iClusterID)     //constructors
    {                
        Random rnd = new Random();
        
        data = new LinkedList<Point>();  
        //centroid = new Point(rnd.nextInt(10), rnd.nextInt(10), "Centroid");        
        centroid = new Point(0.0, 0.0, "Centroid");        
        
        iID = iClusterID;
        iSize = 0;
        energy = 0.0;
    }        
    /*
      -- centroid is random
     * 
     */
            
    public void calculateCentroid()
    {
        double dTempSumX = 0;
        double dTempSumY = 0;
        
        for (Point itP: data)
        {    
            dTempSumX += itP.dGetX();
            dTempSumY += itP.dGetY();
        }    
            
        setCentroid(dTempSumX/iSize, dTempSumY/iSize);
    }        
    /*
      -- return energy
     * 
     */
    
    public void setCentroid(double dCenterX, double dCenterY)
    {   
        centroid.setX(dCenterX);
        centroid.setY(dCenterY);
    }  
    
    public void calculateEnergy()
    {                
        double dTempEnergy = 0.0;
        
        setEnergy(0.0);
                
        for (Point itP: data)
        {    
            dTempEnergy += distance.dGetDistance(itP, centroid);            
        }    
        
        setEnergy(dTempEnergy);                   
    }        
    
    public void setEnergy(double dInputEnergy)
    {
        energy = dInputEnergy;
    }        
    
            
    public void addPoint(Point p)
    {
        data.add(p);
        iSize++;
    }        
    
    public Point getCentroid()
    {
        return centroid;
    }
    
    public LinkedList getPointList()
    {
        return data;
    }           
     
            
    public double getEnergy()
    {
        return energy;
    }    
    
    public int iGetID()
    {
        return iID;
    }        
    
    public Point getPoint(int index)
    {
        if (!data.isEmpty())
            return data.get(index);
        else 
            return null;
    }
    
    public Point getFirstPoint()
    {
        if (!data.isEmpty())
            return data.getFirst();
        else 
            return null;
    }                    
    
    public Point getLastPoint()
    {
        if (!data.isEmpty())
            return data.getLast();
        else 
            return null;
    }            
     
    public void removePoint()
    {
        if (!data.isEmpty())
            data.remove();
        
        iSize--;
    }                    
    
    public void removePoint(int index)
    {
        if (!data.isEmpty())
            data.remove(index);
        
        iSize--;
    }           
    
    public void removeAll()
    {
        while (!data.isEmpty())
            data.remove();
        
        iSize = 0;
    }        
       
    
    /*
    public void reassignPoints(List inputList)
    {
        for (Point itP: data)
        {
            double dTempMinDistance = Double.MAX_VALUE;
            double dTempDistance = 0.0;
            Cluster tempCloserCluster = null;
            
            for (Cluster itC: (ArrayList<Cluster>) inputList) 
            {
                //if (itC.iGetID() == iID) 
                //    continue;
                
                dTempDistance = distance.dGetDistance(itP, itC.getCentroid());
                
                if (dTempDistance < dTempMinDistance)
                {    
                    dTempMinDistance = dTempDistance;
                    
                    tempCloserCluster = itC;
                }    
                
            }    
            
            if (tempCloserCluster.iGetID() != iID)
            {    
                tempCloserCluster.addPoint(itP);
            }
        }          
    }
     * 
     */
    /*
      -- return number of reassignments
     * 
     */    
    
    
    public String toString()
    {
        String s = "Cluster " + iID + " (Size = " + iSize + "): \n";
        
        for (Point itP: data)
            s += itP + "\n";    
            
        return s;
    }        
}


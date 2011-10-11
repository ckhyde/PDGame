/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gmu.css.css605Fall2011.KMeans;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.lang.Double;
import java.io.*;
import java.util.Random;

import edu.gmu.css.css605Fall2011.Distance.*;     

/**
 *
 * @author ckhyde
 */
public class KMeans 
{    
    private ArrayList<Cluster> c;
    private double dEpsilon = 0.01;      //for stopping condition
    //private int iInitNumCluster = 4;
    private List<Point> p;
  
    //public void init(List<Point> data, int k) throws IOException //k = initial number of clusters
    public void init(int iInitNumCluster) throws IOException //k = initial number of clusters
    {
        //int iTempCounter = iInitNumCluster;        
        int iTempCounter = 0;        
        
        c = new ArrayList<Cluster>();
        p = new LinkedList<Point>();                
        
        BufferedInputCSVFile.read("Match scores.csv", p);
                
        while(iTempCounter < iInitNumCluster)
        {
            c.add(new Cluster(iTempCounter));
                                    
            //System.out.println(c.get(iTempCounter).iGetID());
            
            iTempCounter++;
        }    
        
        //while(!p.isEmpty())
        for (Point itP: p)
        {
            Random rnd = new Random();
            
            //c.get(rnd.nextInt(iInitNumCluster)).addPoint(p.get(p.size()-1));            
            c.get(rnd.nextInt(iInitNumCluster)).addPoint(itP);            
            
            //p.get(p.size()-1);
            //System.out.println(p.get(p.size()-1));
            //p.remove(p.size()-1);
        }
                
        
        
        for (Cluster itC: c) 
        {                        
            itC.calculateCentroid();
            itC.calculateEnergy();
            
            System.out.println(itC);
            System.out.println("Centroid is: " + itC.getCentroid());
            System.out.println("Energy is: " + itC.getEnergy() + "\n");
        } 
         
        
    }        
    /*
     * -- create k clusters
	-- for point in data:
	   - add point to random clusters	   
     * 
     */
                   
    public void reassignments()
    {
        //EuclideanDistance distance = new EuclideanDistance();                
        //ManhattanDistance distance = new ManhattanDistance();
        SquareEucDistance distance = new SquareEucDistance();
        
        for (Cluster itC: c)  
        {
            itC.removeAll();
        }
        
        for (Point itP: p)
        {                                   
            double dTempMinDistance = Double.MAX_VALUE;            
            double dTempDistance = 0.0;
            Cluster tempCloserCluster = null;        
            
            for (Cluster itC: c) 
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
            
            //if (tempCloserCluster.iGetID() != iID)
            //{    
            tempCloserCluster.addPoint(itP);
            //}            
                        
        }
        
        for (Cluster itC: c) 
        {                        
            itC.calculateCentroid();
            itC.calculateEnergy();
            
            System.out.println(itC);
            System.out.println("Centroid is: " + itC.getCentroid());
            System.out.println("Energy is: " + itC.getEnergy() + "\n");
        } 
    }   
        
        
    public double iteration()
    {        
        double dTempSumEnergy = 0.0;
        
        reassignments();
        
        for (Cluster itC: c)  
        {
            itC.calculateCentroid();
            itC.calculateEnergy();
            //itC.reassignPoints(c);
            
            dTempSumEnergy += itC.getEnergy();
        }    
        
        return dTempSumEnergy;    
    }      
    /*
     * 
    -- energy = 0    
	-- for every cluster:	   
	   - reassign points
	   - calculate centroid
	   - energy += getEnergy()   //energy of the whole system
     * 
     */
                   
    public void run()
    {        
        double dPre_energy = Double.MAX_VALUE;
        double dTempTotalEnergy = 0.0;
        double dTempDiffEnergy = 0.0;
        int iIterationCount = 1;
                
        do 
        {   
            System.out.println("======== \n Iteration " + iIterationCount);            
            
	    dTempTotalEnergy = iteration();                        
            
            dTempDiffEnergy = Math.abs(dPre_energy - dTempTotalEnergy);
            
            System.out.println(">>>>>>> Improvement: " + dTempDiffEnergy + "\n");
            
            iIterationCount++;
            dPre_energy = dTempTotalEnergy;
                    
	//} while((Math.abs(dPre_energy - dTempTotalEnergy) > dEpsilon) || (iIterationCount == 100));    //maybe add another stopping criterion for the maximal number of iterations    
            } while(dTempDiffEnergy > dEpsilon);    //maybe add another stopping criterion for the maximal number of iterations    
    }            
}

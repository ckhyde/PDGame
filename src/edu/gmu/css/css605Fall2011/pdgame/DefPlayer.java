/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gmu.css.css605Fall2011.pdgame;

/**
 *
 * @author ckhyde
 */
public class DefPlayer extends PDPlayer{
    
    public DefPlayer()
    {              
        sSelfID = "Defect Player";

        System.out.println("DefPlayer Constructor");
    }        
    
    //public void makeMove(int iOppMove) 
    public void makeMove(int iOppMove) 
    {                
        //setMove(1); //1 for Defect
        setMove(GameMove.DEFECT); 
                
        //return GameMove.DEFECT;                             
    }        
}

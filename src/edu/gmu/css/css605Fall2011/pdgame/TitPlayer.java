/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gmu.css.css605Fall2011.pdgame;

import java.util.Random;

/**
 *
 * @author ckhyde
 */
public class TitPlayer extends PDPlayer
{
    //int oppLastMove=GameMove.COOPERATE;
    
    public TitPlayer()
    {                          
        sSelfID = "T4T Player";
        
        System.out.println("TitPlayer Constructor");      
    }        
    
    //public void makeMove(int iOppMove) 
    public void makeMove(int iOppMove) 
    {         
        // At the first round arbitrarily choose action
        if (iOppMove == GameMove.NOMOVE)
        {
            Random rnd = new Random();
            //setMove(rnd.nextInt(2)); //Return an interger 0 or 1            
           
            if (rnd.nextFloat() >= 0.5)
            {   
                setMove(GameMove.DEFECT); 
                
                //return GameMove.DEFECT;
            }    
            else
            {   
                setMove(GameMove.COOPERATE);
                
                //return GameMove.COOPERATE;
            }   
        }           
        // React against Cooperation        
        else if (iOppMove == GameMove.COOPERATE)
        {    
           setMove(GameMove.COOPERATE);
           
           //return GameMove.COOPERATE;
        }           
        // React against Defect        
        //if (iOppMove == GameMove.DEFECT)
        else
        {
           setMove(GameMove.DEFECT);
           
           //return GameMove.DEFECT;
        }   
        
        //return iOppMove;
        //return 1;
    }        
    
    
    /*
    public int makeMove() {
        if (oppLastMove==GameMove.COOPERATE)
                return GameMove.COOPERATE;
        else
                return GameMove.DEFECT;
    } 
     * 
     */
}

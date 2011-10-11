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
public class RandomPlayer extends PDPlayer 
{            
    
    public RandomPlayer()
    {                          
      sSelfID = "Random Player";        
        
      System.out.println("RandomPlayer Constructor");
    }        
    
    //public void makeMove(int iOppMove) 
    public void makeMove(int iOppMove) 
    {
        Random rnd = new Random();
        
        //setMove(rnd.nextInt(2)); //Return an interger 0 or 1
        
        if (rnd.nextFloat() >= 0.5)
        {   
            setMove(GameMove.DEFECT); //Return an interger 0 or 1
            
            //return GameMove.DEFECT;
        }    
        else
        {   
            setMove(GameMove.COOPERATE);
            
            //return GameMove.COOPERATE;
        }    
                
            
    }          
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gmu.css.css605Fall2011.pdgame;

/**
 *
 * @author ckhyde
 */
public class OptTitPlayer extends PDPlayer
{
 
    public OptTitPlayer()
    {             
        sSelfID = "Optimistic T4T Player";

        System.out.println("OptTitPlayer Constructor");
    }        
    
    //public void makeMove(int iOppMove) 
    public void makeMove(int iOppMove) 
    {         
        // At the first round, be optimistic
        if (iOppMove == GameMove.NOMOVE)
        {
           //setMove(0);
            setMove(GameMove.COOPERATE); 
                
            //return GameMove.COOPERATE;             
        }   
        // React against Cooperation
        else if (iOppMove == GameMove.COOPERATE)
        {    
           //setMove(0);
            setMove(GameMove.COOPERATE); 
                
            //return GameMove.COOPERATE;                
        }   
        // React against Defect
        else //if (iOppMove == GameMove.DEFECT)
        {    
           //setMove(1);
            setMove(GameMove.DEFECT); 
                
            //return GameMove.DEFECT;                
        }    
        
        //return iOppMove;
    }        
}
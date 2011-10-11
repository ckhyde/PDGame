/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gmu.css.css605Fall2011.pdgame;

/**
 *
 * @author ckhyde
 */
public class PessTitPlayer extends PDPlayer
{
    
    public PessTitPlayer()
    {                    
      sSelfID = "Pessimistic T4T Player";        
        
      System.out.println("PessTitPlayer Constructor");
    }        
    
    //public void makeMove(int iOppMove) 
    public void makeMove(int iOppMove) 
    {         
        // At the first round, be pessimistic
        if (iOppMove == GameMove.NOMOVE)
        {            
            //setMove(1);
            setMove(GameMove.DEFECT);            
                
            //return GameMove.DEFECT;            
        }   
        // React against Cooperation
        else if (iOppMove == GameMove.COOPERATE)
        {
           //setMove(0);
            setMove(GameMove.COOPERATE); 
                
            //return GameMove.COOPERATE;            
           //System.out.println("iOppMove: "+ iOppMove);
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

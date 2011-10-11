/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gmu.css.css605Fall2011.pdgame;

/**
 *
 * @author ckhyde
 */
public class CoopPlayer extends PDPlayer
{
 
    public CoopPlayer()
    {                  
        sSelfID = "Cooperative Player";        
        
        System.out.println("CoopPlayer Constructor");
    }        
    
    //public void makeMove(int iOppMove) 
    public void makeMove(int iOppMove) 
    {                
        //setMove(0); //0 for Cooperation
        setMove(GameMove.COOPERATE); 
                
        //return GameMove.COOPERATE;                      
    }        
}
